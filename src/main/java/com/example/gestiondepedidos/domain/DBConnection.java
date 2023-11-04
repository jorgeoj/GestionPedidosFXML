package com.example.gestiondepedidos.domain;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;
import java.util.logging.Logger;

/**
 * Clase que gestiona la conexión a la base de datos utilizada en la aplicación de gestión de pedidos.
 * Esta clase carga la configuración de la base de datos desde un archivo de propiedades y establece una conexión
 * a la base de datos MySQL.
 */
public class DBConnection {
    /**
     * Conexión a la base de datos.
     */
    private static Connection connection;

    /**
     * Objeto para registrar eventos y mensajes de la clase.
     */
    private static Logger logger = Logger.getLogger(DBConnection.class.getName());

    /**
     * Constructor de la clase DBConnection.
     */
    public DBConnection() {
    }

    static {
        String url;
        String user;
        String password;

        Properties properties = new Properties();

        try {
            // Cargar la configuración de la base de datos desde un archivo de propiedades.
            InputStream inputStream = DBConnection.class.getClassLoader().getResourceAsStream("bbdd.properties");
            properties.load(inputStream);
            // URL de la conexión a la base de datos.
            url = "jdbc:mysql://" + properties.get("host") + ":" + properties.get("port") + "/" + properties.get("dbname");
            user = (String) properties.get("user");
            password = (String) properties.get("pass");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        try {
            // Establecer la conexión a la base de datos.
            connection = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Obtiene la conexión a la base de datos.
     *
     * @return Conexión a la base de datos.
     */
    public static Connection getConnection() {
        return connection;
    }
}

