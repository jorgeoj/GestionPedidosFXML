package com.example.gestiondepedidos.products;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Implementación de la interfaz ProductoDAO para acceder y gestionar datos de productos en una base de datos.
 */
public class ProductoDAOImp implements ProductoDAO {
    /**
     * Conexión a la base de datos utilizada para acceder a los datos de productos.
     */
    private static Connection connection;

    /**
     * Consulta SQL para cargar un producto por su identificador.
     */
    private static String queryLoadAll = "SELECT * FROM producto WHERE id=?";

    /**
     * Constructor de la clase ProductoDAOImp.
     *
     * @param conn Conexión a la base de datos que se utilizará para acceder a los datos de productos.
     */
    public ProductoDAOImp(Connection conn) {
        connection = conn;
    }

    /**
     * Carga un producto desde la base de datos utilizando su identificador.
     *
     * @param id Identificador del producto que se desea cargar.
     * @return Objeto Producto si se encuentra el producto con el identificador especificado, o null si no se encuentra.
     * @throws RuntimeException Si se produce un error durante la carga del producto desde la base de datos.
     */
    @Override
    public Producto loadProduct(Integer id) {
        Producto producto = null;
        try {
            // Se prepara y ejecuta la consulta.
            PreparedStatement preparedStatement = connection.prepareStatement(queryLoadAll);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                producto = new Producto();
                producto.setId(resultSet.getInt("id"));
                producto.setNombre(resultSet.getString("nombre"));
                producto.setPrecio(resultSet.getDouble("precio"));
                producto.setCantidad_disponible(resultSet.getInt("cantidad_disponible"));
            }

            return producto;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}