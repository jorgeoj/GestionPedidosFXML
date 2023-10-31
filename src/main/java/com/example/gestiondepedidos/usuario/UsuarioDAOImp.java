package com.example.gestiondepedidos.usuario;

import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Connection;


public class UsuarioDAOImp implements UsuarioDAO{

    private final Connection connection;

    public UsuarioDAOImp(Connection connection) {
        this.connection = connection;
    }

    private final static String queryLoadAll = "SELECT * FROM usuario";
    private final static String queryLoad = "SELECT * FROM usuario WHERE id = ?";
    private final static String queryLoadByName = "SELECT * FROM usuario WHERE nombre = ?";

    @Override
    public Usuario load(Long id) {
        Usuario salida = null;

        try(var pst = connection.prepareStatement(queryLoad)){
            pst.setLong(1,id);
            var rs = pst.executeQuery();
            if (rs.next()){
                salida = new Usuario(rs.getLong("id"),
                        rs.getString("nombre"),
                        rs.getString("contraseña"),
                        rs.getString("email"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return salida;
    }

    @Override
    public ArrayList<Usuario> loadAll() {
        return null;
    }
}
