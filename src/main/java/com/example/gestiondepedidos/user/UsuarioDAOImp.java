package com.example.gestiondepedidos.user;

import com.example.gestiondepedidos.user.Usuario;
import com.example.gestiondepedidos.user.UsuarioDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


/**
 * Implementación de la interfaz UsuarioDAO para acceder y gestionar datos de usuarios en una base de datos.
 */
public class UsuarioDAOImp implements UsuarioDAO {
    /**
     * Conexión a la base de datos utilizada para acceder a los datos de usuarios.
     */
    private final Connection connection;

    /**
     * Consulta SQL para cargar un usuario por su dirección de correo electrónico.
     */
    private final static String loadUserByEmail = "SELECT * FROM usuario WHERE email = ?";

    /**
     * Constructor de la clase UsuarioDAOImp.
     *
     * @param conn Conexión a la base de datos que se utilizará para acceder a los datos de usuarios.
     */
    public UsuarioDAOImp(Connection conn) {
        this.connection = conn;
    }

    /**
     * Carga un usuario desde la base de datos utilizando su dirección de correo electrónico y contraseña.
     *
     * @param email      Dirección de correo electrónico del usuario.
     * @param contrasenya Contraseña del usuario a verificar.
     * @return Objeto Usuario si se encuentra el usuario y la contraseña es correcta, o null si no se encuentra.
     * @throws RuntimeException Si se produce un error durante la carga del usuario o la contraseña es incorrecta.
     */
    @Override
    public Usuario loadUser(String email, String contrasenya) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(loadUserByEmail);
            preparedStatement.setString(1, email);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                Usuario usuario = new Usuario();
                usuario.setId(resultSet.getInt("id"));
                usuario.setNombre(resultSet.getString("nombre"));
                usuario.setContrasenya(resultSet.getString("contrasenya"));
                if (!contrasenya.equals(usuario.getContrasenya())) {
                    throw new Exception("Contraseña incorrecta");
                } else {
                    return usuario;
                }
            } else {
                throw new RuntimeException("Usuario incorrecto");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

