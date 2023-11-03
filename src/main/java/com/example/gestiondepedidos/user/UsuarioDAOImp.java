package com.example.gestiondepedidos.user;

import com.example.gestiondepedidos.user.Usuario;
import com.example.gestiondepedidos.user.UsuarioDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class UsuarioDAOImp implements UsuarioDAO {

    private final Connection connection;

    //private final static String loadUserByName = "SELECT * FROM usuario WHERE nombre = ?";
    private final static String loadUserByEmail = "SELECT * FROM usuario WHERE email = ?";

    public UsuarioDAOImp(Connection connection) {
        this.connection = connection;
    }


    @Override
    public Usuario loadUser(String email, String contrasenya) {
        Usuario usuario = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(loadUserByEmail);
            preparedStatement.setString(1, email);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()){
                //TODO necesito la linea de abajo? y como arreglarla si la necesito
                //usuario = new Usuario(email, contrasenya);
                usuario.setId(resultSet.getInt("id"));
                usuario.setNombre(resultSet.getString("nombre"));
                usuario.setContrasenya(resultSet.getString("contrasenya"));
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return usuario;
    }
}
