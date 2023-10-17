package com.example.practica_mario_rodriguez;

import com.example.practica_mario_rodriguez.clase.Mineral;
import com.example.practica_mario_rodriguez.util.R;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class DB_Manager {
    private Connection conexion;

    public void conectar() throws ClassNotFoundException, SQLException, IOException {
        try {
            Properties configuration = new Properties();
            configuration.load(R.getProperties("database.properties"));
            String host = configuration.getProperty("host");
            String port = configuration.getProperty("port");
            String name = configuration.getProperty("name");
            String username = configuration.getProperty("username");
            String password = configuration.getProperty("password");

            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/" + name + "?serverTimezone=UTC",
                    username, password);
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }

    }

    public void desconectar() {
        try{
            conexion.close();
        } catch (SQLException e){
            System.out.println(e.getMessage());;
        }
    }



    public void annadirMineral(Mineral mineral) throws SQLException {
        try{
            String sql = "INSERT INTO lista_minerales (mineral, color, brillo, dureza_Mohs, grupo) VALUES (?, ?, ?, ?, ?)";

            PreparedStatement sentencia = conexion.prepareStatement(sql);
            sentencia.setString(1, mineral.getMineral());
            sentencia.setString(2, mineral.getColor());
            sentencia.setString(3, mineral.getBrillo());
            sentencia.setString(4, mineral.getDureza_Mohs());
            sentencia.setString(5, mineral.getGrupo());
            sentencia.executeUpdate();
        } catch (SQLException e){
            System.out.println(e.getMessage());;
        }
    }

    public void eliminarMineral(Mineral mineral) throws SQLException {
        try{
            String sql = "DELETE FROM lista_minerales WHERE mineral = ?";

            PreparedStatement sentencia = conexion.prepareStatement(sql);
            sentencia.setString(1, mineral.getMineral());
            sentencia.executeUpdate();
        } catch (SQLException e){
            System.out.println(e.getMessage());;
        }
    }

    public void modificarMineral(Mineral mineralAntiguo, Mineral mineralNuevo) throws SQLException {
        try{
            String sql = "UPDATE lista_minerales SET mineral = ?, color = ?, brillo = ?, dureza_Mohs = ?, grupo = ? WHERE id = ?";

            PreparedStatement sentencia = conexion.prepareStatement(sql);
            sentencia.setString(1, mineralNuevo.getMineral());
            sentencia.setString(2, mineralNuevo.getColor());
            sentencia.setString(3, mineralNuevo.getBrillo());
            sentencia.setString(4, mineralNuevo.getDureza_Mohs());
            sentencia.setString(5, mineralNuevo.getGrupo());
            sentencia.setInt(6, mineralAntiguo.getId());
            sentencia.executeUpdate();
        } catch (SQLException e){
            System.out.println(e.getMessage());;
        }
    }

    public static ResultSet getMinerales(int resultSetType, int resultSetConcurrency) {
        try {
            Statement stmt = conexion.createStatement(resultSetType, resultSetConcurrency);
            ResultSet rs = stmt.executeQuery("SELECT * FROM minerales");
            //stmt.close();
            return rs;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

}
