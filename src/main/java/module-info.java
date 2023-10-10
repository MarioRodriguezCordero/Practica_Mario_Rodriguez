module com.example.practica_mario_rodriguez {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;
    requires java.sql;

    opens com.example.practica_mario_rodriguez to javafx.fxml;
    exports com.example.practica_mario_rodriguez;
    exports com.example.practica_mario_rodriguez.util;
    opens com.example.practica_mario_rodriguez.util to javafx.fxml;
    exports com.example.practica_mario_rodriguez.clase;
    opens com.example.practica_mario_rodriguez.clase to javafx.fxml;
}