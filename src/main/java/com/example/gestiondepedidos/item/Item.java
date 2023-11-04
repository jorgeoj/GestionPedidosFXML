package com.example.gestiondepedidos.item;

import com.example.gestiondepedidos.products.Producto;

import java.io.Serializable;

public class Item implements Serializable {
    private Integer id;
    private String codigo_pedido;
    private Producto producto_id;
    private Integer cantidad;

    //Constructores con y sin parametros
    public Item(Integer id, String codigo_pedido, Producto producto, Integer cantidad) {
        this.id = id;
        this.codigo_pedido = codigo_pedido;
        this.producto_id = producto;
        this.cantidad = cantidad;
    }

    public Item() {
    }

    //Getters y setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCodigo_pedido() {
        return codigo_pedido;
    }

    public void setCodigo_pedido(String codigo_pedido) {
        this.codigo_pedido = codigo_pedido;
    }

    public Producto getProducto() {
        return producto_id;
    }

    public void setProducto(Producto producto) {
        this.producto_id = producto;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    //to string

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", codigo_pedido='" + codigo_pedido + '\'' +
                ", producto=" + producto_id +
                ", cantidad=" + cantidad +
                '}';
    }
}
