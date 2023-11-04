package com.example.gestiondepedidos.products;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Clase que representa un producto en la aplicación de gestión de pedidos.
 * Esta clase almacena información sobre el producto, incluyendo su identificación, nombre, precio y cantidad disponible.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Producto implements Serializable {
    /**
     * Identificador único del producto.
     */
    private Integer id;

    /**
     * Nombre del producto.
     */
    private String nombre;

    /**
     * Precio del producto.
     */
    private Double precio;

    /**
     * Cantidad disponible del producto.
     */
    private Integer cantidad_disponible;
}

