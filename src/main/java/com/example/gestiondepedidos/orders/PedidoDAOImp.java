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

/**
 * Implementación de la interfaz PedidoDAO para acceder y gestionar datos de pedidos en una base de datos.
 */
public class PedidoDAOImp implements PedidoDAO {
    /**
     * Conexión a la base de datos utilizada para acceder a los datos de pedidos.
     */
    private static Connection connection;

    /**
     * Consulta SQL para cargar todos los pedidos de un usuario por su identificador.
     */
    private final static String queryLoadAll = "SELECT * FROM pedido WHERE usuario = ?";

    /**
     * Constructor de la clase PedidoDAOImp.
     *
     * @param conn Conexión a la base de datos que se utilizará para acceder a los datos de pedidos.
     */
    public PedidoDAOImp(Connection conn) {
        this.connection = conn;
    }

    /**
     * Carga todos los pedidos asociados con un usuario específico desde la base de datos.
     *
     * @param id Identificador del usuario para el cual se cargarán los pedidos.
     * @return Una lista de objetos Pedido que representan los pedidos del usuario.
     * @throws RuntimeException Si se produce un error durante la carga de los pedidos desde la base de datos.
     */
    public ArrayList<Pedido> loadAll(Integer id) {
        ArrayList<Pedido> salida = new ArrayList();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(queryLoadAll);
            ItemDAOImp itemDAOImp = new ItemDAOImp(DBConnection.getConnection());
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
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

