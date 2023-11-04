package com.example.gestiondepedidos.item;

import com.example.gestiondepedidos.domain.DBConnection;
import com.example.gestiondepedidos.products.Producto;
import com.example.gestiondepedidos.products.ProductoDAOImp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ItemDAOImp implements ItemDAO{
    private static Connection connection;
    private static final String queryLoadAll = "select * from item where codigo_pedido = ?";

    public ItemDAOImp(Connection conn) {
        this.connection = conn;
    }
    @Override
    public ArrayList<Item> loadAll(String codigo_Pedido) {
        ArrayList<Item> salida = new ArrayList();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from item where codigo_pedido = ?");
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
