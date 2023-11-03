package com.example.gestiondepedidos.domain;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;
import java.util.logging.Logger;

public class DBConnection {
    private static Connection connection;
    private static Logger logger;

    static {
        logger = Logger.getLogger(DBConnection.class.getName());

        String url;
        String user;
        String password;
        Properties properties = new Properties();
        try{
            //Cargar la configuracion de la bd
            InputStream inputStream = DBConnection.class.getClassLoader().getResourceAsStream("bbdd.properties");
            properties.load(inputStream);
            //URL de la conexion
            url = "jdbc:mysql://"+properties.get("host") + ":" + properties.get("port") + "/" + properties.get("dbname");
            user = (String) properties.get("user");
            password = (String) properties.get("pass");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        try{
            connection = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static Connection getConnection(){
        return connection;
    }
}
