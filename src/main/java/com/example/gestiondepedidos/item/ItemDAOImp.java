package com.example.gestiondepedidos.item;

import com.example.gestiondepedidos.domain.DBConnection;
import com.example.gestiondepedidos.products.Producto;
import com.example.gestiondepedidos.products.ProductoDAOImp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Implementación de la interfaz ItemDAO para acceder y gestionar datos de ítems en una base de datos.
 */
public class ItemDAOImp implements ItemDAO {
    /**
     * Conexión a la base de datos utilizada para acceder a los datos de ítems.
     */
    private static Connection connection;

    /**
     * Consulta SQL para cargar todos los ítems de un pedido por su código.
     */
    private static final String queryLoadAll = "SELECT * FROM item WHERE codigo_pedido = ?";

    /**
     * Constructor de la clase ItemDAOImp.
     *
     * @param conn Conexión a la base de datos que se utilizará para acceder a los datos de ítems.
     */
    public ItemDAOImp(Connection conn) {
        this.connection = conn;
    }

    /**
     * Carga todos los ítems asociados con un pedido específico desde la base de datos.
     *
     * @param codigo_Pedido Código del pedido para el cual se cargarán los ítems.
     * @return Una lista de objetos Item que representan los ítems del pedido.
     * @throws RuntimeException Si se produce un error durante la carga de los ítems desde la base de datos.
     */
    @Override
    public ArrayList<Item> loadAll(String codigo_Pedido) {
        ArrayList<Item> salida = new ArrayList();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(queryLoadAll);
            preparedStatement.setString(1, codigo_Pedido);
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()) {
                Item item = new Item();
                item.setId(resultSet.getInt("id"));
                item.setCodigo_pedido(resultSet.getString("codigo_pedido"));
                Integer productId = resultSet.getInt("producto_id");
                item.setCantidad(resultSet.getInt("cantidad"));
                ProductoDAOImp productoDAOImp = new ProductoDAOImp(DBConnection.getConnection());
                Producto producto = productoDAOImp.loadProduct(productId);
                item.setProducto_id(producto);
                salida.add(item);
            }

            return salida;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

