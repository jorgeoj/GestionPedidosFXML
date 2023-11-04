package com.example.gestiondepedidos.orders;

import com.example.gestiondepedidos.item.Item;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Clase que representa un pedido en la aplicación de gestión de pedidos.
 * Esta clase almacena información sobre el pedido, incluyendo su identificación, código, fecha,
 * identificador de usuario, total
 * y una lista de ítems asociados con el pedido.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pedido implements Serializable {
    /**
     * Identificador único del pedido.
     */
    private Integer id;

    /**
     * Código identificativo del pedido.
     */
    private String codigo;

    /**
     * Fecha en la que se realizó el pedido.
     */
    private String fecha;

    /**
     * Identificador del usuario que realizó el pedido.
     */
    private Integer usuarioId;

    /**
     * Total del pedido.
     */
    private Integer total;

    /**
     * Lista de ítems asociados con el pedido.
     */
    private ArrayList<Item> items = new ArrayList<>();
}

