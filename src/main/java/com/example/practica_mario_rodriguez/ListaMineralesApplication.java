package com.example.practica_mario_rodriguez;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ListaMineralesApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(ListaMineralesApplication.class.getResource("listaMin_PantallaPrincipal.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Lista Minerales");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) { launch(); }
}