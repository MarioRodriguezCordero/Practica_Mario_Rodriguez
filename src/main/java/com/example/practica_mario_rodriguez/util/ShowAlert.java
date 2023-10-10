package com.example.practica_mario_rodriguez.util;

import javafx.scene.control.Alert;

public class ShowAlert {
    public static void mostrarError(String mensaje) {
        Alert alerta = new Alert(Alert.AlertType.ERROR);
        alerta.setContentText(mensaje);
        alerta.show();
    }
}
