package com.example.gestiondepedidos;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Clase principal de la aplicación de gestión de pedidos.
 * Esta clase inicia y gestiona la interfaz gráfica de la aplicación, cargando diferentes pantallas FXML.
 */
public class Main extends Application {
    /**
     * Representa la ventana principal de la aplicación.
     */
    private static Stage myStage;

    /**
     * Método principal de inicio de la aplicación.
     *
     * @param stage Objeto Stage que representa la ventana principal de la aplicación.
     * @throws IOException Si se produce un error al cargar el archivo FXML de inicio de sesión.
     */
    @Override
    public void start(Stage stage) throws IOException {
        myStage = stage;
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("ventana-login.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 700, 500);
        stage.setResizable(false);
        stage.setTitle("Gestión de pedidos");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Carga un archivo FXML que representa la interfaz de usuario de la aplicación de gestión de usuarios.
     *
     * @param ruta Ruta al archivo FXML que se va a cargar.
     */
    public static void loadFXMLUsuario(String ruta) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource(ruta));
            Scene scene = new Scene(fxmlLoader.load(), 850, 600);
            myStage.setScene(scene);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Carga un archivo FXML que representa la interfaz de usuario de detalles de un pedido.
     *
     * @param ruta Ruta al archivo FXML que se va a cargar.
     */
    public static void loadFXMLDetalles(String ruta) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource(ruta));
            Scene scene = new Scene(fxmlLoader.load(), 600, 400);
            myStage.setScene(scene);
        } catch (IOException var3) {
            var3.printStackTrace();
            throw new RuntimeException(var3);
        }
    }

    /**
     * Carga un archivo FXML que representa la interfaz de inicio de sesión de la aplicación.
     *
     * @param ruta Ruta al archivo FXML que se va a cargar.
     */
    public static void loadFXMLLogin(String ruta) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource(ruta));
            Scene scene = new Scene(fxmlLoader.load(), 700, 500);
            myStage.setScene(scene);
        } catch (IOException var3) {
            throw new RuntimeException(var3);
        }
    }

    /**
     * Método principal de inicio de la aplicación.
     *
     * @param args Argumentos de la línea de comandos.
     */
    public static void main(String[] args) {
        launch();
    }
}
