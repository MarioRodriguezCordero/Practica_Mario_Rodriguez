package com.example.practica_mario_rodriguez;

import com.example.practica_mario_rodriguez.clase.Mineral;
import com.example.practica_mario_rodriguez.util.ShowAlert;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ListaMineralesController {

    @FXML
    private Button btnAnnadir;

    @FXML
    private Button btnEliminar;

    @FXML
    private Button btnModificar;

    @FXML
    private TableView<?> tblTabla;

    @FXML
    private TableColumn<?, ?> tblcBrillo;

    @FXML
    private TableColumn<?, ?> tblcColor;

    @FXML
    private TableColumn<?, ?> tblcDureza;

    @FXML
    private TableColumn<?, ?> tblcGrupo;

    @FXML
    private TableColumn<?, ?> tblcMineral;

    private DB_Manager dbManager;

    @FXML
    private void initialize(){
        dbManager = new DB_Manager();
        try {
            dbManager.conectar();
        } catch (ClassNotFoundException e) {
            ShowAlert.mostrarError("Error al conectar con la base de datos");
        } catch (SQLException e) {
            ShowAlert.mostrarError("Error al iniciar la aplicación");
        } catch (IOException e) {
            ShowAlert.mostrarError("Error al cargar la configuración");
        }
    }

    public void cargarDatos() {
        tblTabla.getItems().clear();
        try {
            ResultSet rs = DB_Manager.getMinerales(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
            if (rs != null) {
                while (rs.next()) {
                    String nombre = rs.getString("nombreUsuarios");
                    String Dificultad = rs.getString("Dificultad");
                    String resultado = rs.getString("Resultado");
                    lista.add(new Resultados(nombre, Dificultad, resultado));
                }
                rs.close();
            }
            columUsuario.setCellValueFactory(new PropertyValueFactory<>("NombreUsuarios"));
            columDificultad.setCellValueFactory(new PropertyValueFactory<>("Dificultad"));
            columResultado.setCellValueFactory(new PropertyValueFactory<>("Resultado"));
            tableEstadisticas.setItems(lista);
        } catch (SQLException sqle) {
            ShowAlert.mostrarError("Error cargando los datos de la aplicación");
        }
    }

    @FXML
    void annadir(ActionEvent event) {
        try {

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @FXML
    void eliminar(ActionEvent event) {
        try {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Eliminacion");
            alert.setHeaderText("¿Estas seguro de querer eliminar los minerales seleccionados?");
            alert.showAndWait();
            if(alert.getResult().getButtonData().isDefaultButton() == true){

            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @FXML
    void modificar(ActionEvent event) {
        try {

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
