package com.example.gestiondepedidos.products;

/**
 * Interfaz que define operaciones para acceder y gestionar datos de productos en una base de datos.
 */
public interface ProductoDAO {
    /**
     * Carga un producto desde la base de datos utilizando su identificador.
     *
     * @param id Identificador del producto que se desea cargar.
     * @return Objeto Producto si se encuentra el producto con el identificador especificado, o null si no se encuentra.
     */
    Producto loadProduct(Integer id);
}

