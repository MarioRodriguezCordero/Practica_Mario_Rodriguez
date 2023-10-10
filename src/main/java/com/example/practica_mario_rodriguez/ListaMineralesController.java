package com.example.practica_mario_rodriguez;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class ListaMineralesController {

    @FXML
    private Button btnAnnadir;

    @FXML
    private Button btnEliminar;

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

}
