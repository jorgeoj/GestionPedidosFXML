package com.example.gestiondepedidos.orders;

import com.example.gestiondepedidos.Sesion;
import com.example.gestiondepedidos.domain.DBConnection;
import com.example.gestiondepedidos.item.ItemDAOImp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class PedidoDAOImp implements PedidoDAO{

    private static Connection connection;
    private final static String queryLoadAll = "select * from pedido where usuario = ?";

    public PedidoDAOImp(Connection conn) {
        this.connection = conn;
    }

    public ArrayList<Pedido> loadAll(Integer id) {
        ArrayList<Pedido> salida = new ArrayList();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(queryLoadAll);
            ItemDAOImp itemDAOImp = new ItemDAOImp(DBConnection.getConnection());
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()) {
                Pedido pedido = new Pedido();
                pedido.setId(resultSet.getInt("id"));
                pedido.setCodigo(resultSet.getString("codigo"));
                pedido.setFecha((new SimpleDateFormat("yyyy-MM-dd")).format(resultSet.getDate("fecha")));
                pedido.setUsuarioId(resultSet.getInt("usuario"));
                pedido.setTotal(resultSet.getInt("total"));
                pedido.setItems(itemDAOImp.loadAll(pedido.getCodigo()));
                Sesion.setPedido(pedido);
                salida.add(pedido);
            }

            return salida;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
