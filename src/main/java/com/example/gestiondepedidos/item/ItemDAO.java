package com.example.gestiondepedidos.item;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Interfaz que define operaciones para acceder y gestionar datos de ítems en una base de datos.
 */
public interface ItemDAO {
    /**
     * Carga todos los ítems asociados con un pedido específico desde la base de datos.
     *
     * @param codigo_Pedido Código del pedido para el cual se cargarán los ítems.
     * @return Una lista de objetos Item que representan los ítems del pedido.
     * @throws SQLException Si se produce un error durante la operación de carga de los ítems desde la base de datos.
     */
    ArrayList<Item> loadAll(String codigo_Pedido) throws SQLException;
}

