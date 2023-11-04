package com.example.gestiondepedidos.item;

import com.example.gestiondepedidos.products.Producto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
/**
 * Clase que representa un ítem en la aplicación de gestión de pedidos.
 * Esta clase almacena información sobre el ítem, incluyendo su identificación, código de pedido al que pertenece, producto asociado y cantidad.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Item implements Serializable {
    /**
     * Identificador único del ítem.
     */
    private Integer id;

    /**
     * Código de pedido al que pertenece el ítem.
     */
    private String codigo_pedido;

    /**
     * Producto asociado con el ítem.
     */
    private Producto producto_id;

    /**
     * Cantidad de productos en el ítem.
     */
    private Integer cantidad;
}

