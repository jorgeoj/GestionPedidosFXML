package com.example.gestiondepedidos.user;

import com.example.gestiondepedidos.orders.Pedido;

import java.io.Serializable;
import java.util.ArrayList;


public class Usuario implements Serializable {
    private Integer id;
    private String nombre;
    private String contrasenya;
    private String email;
    //ArrayList de pedidos para almacenar los pedidos de un usuario
    private ArrayList<Pedido> pedidos;

    public Usuario(Integer id, String nombre, String contrasenya, String email) {
        this.id = id;
        this.nombre = nombre;
        this.contrasenya = contrasenya;
        this.email = email;
    }

    //TODO constructor para el arrayList


    //Getters y setters
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

    public String getContrasenya() {
        return contrasenya;
    }

    public void setContrasenya(String contrasenya) {
        this.contrasenya = contrasenya;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    //Metodo to string
    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", contrasenya='" + contrasenya + '\'' +
                ", email='" + email + '\'' +
                ", pedidos=" + pedidos +
                '}';
    }


}
