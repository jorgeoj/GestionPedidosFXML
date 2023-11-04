package com.example.gestiondepedidos.orders;

import java.util.ArrayList;

public interface PedidoDAO {
    public ArrayList<Pedido> loadAll(Integer id);
}
