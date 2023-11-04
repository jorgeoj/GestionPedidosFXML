package com.example.gestiondepedidos.orders;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Interfaz que define operaciones para acceder y gestionar datos de pedidos en una base de datos.
 */
public interface PedidoDAO {
    /**
     * Carga todos los pedidos asociados con un usuario específico desde la base de datos.
     *
     * @param id Identificador del usuario para el cual se cargarán los pedidos.
     * @return Una lista de objetos Pedido que representan los pedidos del usuario.
     * @throws SQLException Si se produce un error durante la operación de carga de los pedidos desde la base de datos.
     */
    ArrayList<Pedido> loadAll(Integer id) throws SQLException;
}

