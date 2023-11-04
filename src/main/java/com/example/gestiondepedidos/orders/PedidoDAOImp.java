package com.example.gestiondepedidos.orders;

import java.sql.Connection;
import java.util.ArrayList;

public class PedidoDAOImp implements PedidoDAO{

    private static Connection connection;
    private final static String queryLoadAll = "select * from pedido where usuario = ?";

    public PedidoDAOImp(Connection conn) {
        this.connection = conn;
    }

    //TODO aun hay que hacer esto de aqui
    @Override
    public ArrayList<Pedido> loadAll(Integer id) {
        return null;
    }
}
