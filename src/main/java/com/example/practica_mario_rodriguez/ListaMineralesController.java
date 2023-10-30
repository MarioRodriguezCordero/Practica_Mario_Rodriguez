package com.example.practica_mario_rodriguez;

import com.example.practica_mario_rodriguez.clase.Mineral;
import com.example.practica_mario_rodriguez.util.ShowAlert;
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

public class ListaMineralesController {

    @FXML
    private Button btnAnnadir;

    @FXML
    private Button btnEliminar;

    @FXML
    private Button btnModificar;

    @FXML
    private TableView<Mineral> tblTabla;

    @FXML
    private TableColumn<Mineral, String> tblcBrillo;

    @FXML
    private TableColumn<Mineral, String> tblcColor;

    @FXML
    private TableColumn<Mineral, String> tblcDureza;

    @FXML
    private TableColumn<Mineral, String> tblcGrupo;

    @FXML
    private TableColumn<Mineral, String> tblcMineral;

    @FXML
    private void initialize(){
        try {
            DB_Manager.conectar();
        } catch (ClassNotFoundException e) {
            ShowAlert.mostrarError("Error al conectar con la base de datos");
        } catch (SQLException e) {
            ShowAlert.mostrarError("Error al iniciar la aplicación");
        } catch (IOException e) {
            ShowAlert.mostrarError("Error al cargar la configuración");
        }
    }

    public void cargarDatos() {
        ObservableList<Mineral> lista = FXCollections.observableArrayList();
        try {
            ResultSet rs = DB_Manager.getMinerales(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
            if (rs != null) {
                while (rs.next()) {
                    String mineral = rs.getString("mineral");
                    String color = rs.getString("color");
                    String brillo = rs.getString("brillo");
                    String dureza_Mohs = rs.getString("dureza_Mohs");
                    String grupo = rs.getString("grupo");
                    lista.add(new Mineral(mineral, color, brillo, dureza_Mohs, grupo));
                }
                rs.close();
            }
            tblcMineral.setCellValueFactory(new PropertyValueFactory<>("mineral"));
            tblcColor.setCellValueFactory(new PropertyValueFactory<>("color"));
            tblcBrillo.setCellValueFactory(new PropertyValueFactory<>("brillo"));
            tblcDureza.setCellValueFactory(new PropertyValueFactory<>("dureza_Mohs"));
            tblcGrupo.setCellValueFactory(new PropertyValueFactory<>("grupo"));
            tblTabla.setItems(lista);
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
