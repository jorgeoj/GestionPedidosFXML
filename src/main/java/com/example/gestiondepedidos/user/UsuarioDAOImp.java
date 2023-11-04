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

    public UsuarioDAOImp(Connection conn) {
        this.connection = conn;
    }


    @Override
    public Usuario loadUser(String email, String contrasenya) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(loadUserByEmail);
            preparedStatement.setString(1, email);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()){
                Usuario usuario = new Usuario();
                usuario.setId(resultSet.getInt("id"));
                usuario.setNombre(resultSet.getString("nombre"));
                usuario.setContrasenya(resultSet.getString("contrasenya"));
                if (!contrasenya.equals(usuario.getContrasenya())){
                    throw new Exception("Contraseña incorrecta");
                }else {
                    return usuario;
                }
            }else {
                throw new RuntimeException("Usuario incorrecto");
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
