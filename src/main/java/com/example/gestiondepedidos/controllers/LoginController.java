package com.example.gestiondepedidos.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.Serializable;

public class LoginController implements Serializable {

    @FXML
    private TextField txtUsuario;
    @FXML
    private PasswordField pswdField;
    @FXML
    private Button buttonEntrar;
    @FXML
    private Label txtInfo;

    @FXML
    public void login(ActionEvent actionEvent){
        String user = txtUsuario.getText();
        String password = pswdField.getText();
        //Coger usuario y contraseña y comprobarlos para pasar o no
    }

    /*
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        //Metodo de inicializacion de la clase
    }
     */

}