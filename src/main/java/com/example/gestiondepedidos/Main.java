package com.example.gestiondepedidos;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    //Representa la ventana ppal de la app
    private static Stage myStage;

    @Override
    public void start(Stage stage) throws IOException {
        myStage = stage;
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("ventana-login.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        stage.setResizable(false);
        stage.setTitle("Gestión de pedidos");
        stage.setScene(scene);
        stage.show();
    }

    public static void loadFXMLUsuario(String s) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource(s));
            Scene scene = new Scene((Parent) fxmlLoader.load(), 800, 650);
            myStage.setScene(scene);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void loadFXMLDetalles(String ruta) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource(ruta));
            Scene scene = new Scene((Parent)fxmlLoader.load(), 600, 430);
            myStage.setScene(scene);
        } catch (IOException var3) {
            throw new RuntimeException(var3);
        }
    }

    public static void loadFXMLLogin(String ruta) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource(ruta));
            Scene scene = new Scene((Parent)fxmlLoader.load(), 600, 430);
            myStage.setScene(scene);
        } catch (IOException var3) {
            throw new RuntimeException(var3);
        }
    }

    public static void main(String[] args) {
        launch();
    }
}