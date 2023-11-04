package com.example.gestiondepedidos.controllers;

import com.example.gestiondepedidos.Main;
import com.example.gestiondepedidos.Sesion;
import com.example.gestiondepedidos.domain.DBConnection;
import com.example.gestiondepedidos.user.Usuario;
import com.example.gestiondepedidos.user.UsuarioDAOImp;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.Serializable;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Serializable {

    @FXML
    private TextField txtUsuario;
    @FXML
    private PasswordField pswdField;
    @FXML
    private Button buttonEntrar;
    @FXML
    private Label txtInfo;

    public LoginController(){}

    @FXML
    public void login(ActionEvent actionEvent){
        String user = txtUsuario.getText();
        String password = pswdField.getText();
        UsuarioDAOImp usuarioDAOImp = new UsuarioDAOImp(DBConnection.getConnection());
        //Coger usuario y contraseña y comprobarlos para pasar o no
        try{
            Usuario usuario= usuarioDAOImp.loadUser(user, password);
            Sesion.setUsuario(usuario);
            Main.loadFXMLUsuario("ventanaUsuario.fxml");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void initialize(URL url, ResourceBundle resourceBundle){}
}