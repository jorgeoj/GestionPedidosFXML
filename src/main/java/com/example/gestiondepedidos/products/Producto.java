package com.example.gestiondepedidos.products;

public class Producto {
    private Integer id;
    private String nombre;
    private Double precio;
    private Integer cantidad_disponible;

    //Constructores con parametros y vacio
    public Producto(Integer id, String nombre, Double precio, Integer cantidad_disponible) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad_disponible = cantidad_disponible;
    }

    public Producto() {
    }

    //Getters y setters de los parametros
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Integer getCantidad_disponible() {
        return cantidad_disponible;
    }

    public void setCantidad_disponible(Integer cantidad_disponible) {
        this.cantidad_disponible = cantidad_disponible;
    }

    //to string
    @Override
    public String toString() {
        return nombre + " / " + precio + "€";
    }
}
