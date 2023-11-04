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
    private TextField txtUser;
    @FXML
    private PasswordField txtPassword;
    @FXML
    private Button btnIniciar;
    @FXML
    private Label info;

    public LoginController(){}

    @Deprecated
    public void login(ActionEvent actionEvent){
        String user = txtUser.getText();
        String password = txtPassword.getText();
        UsuarioDAOImp usuarioDAOImp = new UsuarioDAOImp(DBConnection.getConnection());
        //Coger usuario y contraseña y comprobarlos para pasar o no
        try{
            Usuario usuario= usuarioDAOImp.loadUser(user, password);
            Sesion.setUsuario(usuario);
            Main.loadFXMLUsuario("ventana-usuario.fxml");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void initialize(URL url, ResourceBundle resourceBundle){}
}