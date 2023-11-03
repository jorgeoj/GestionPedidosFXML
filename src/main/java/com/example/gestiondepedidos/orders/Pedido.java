package com.example.gestiondepedidos.orders;

import com.example.gestiondepedidos.item.Item;

import java.util.ArrayList;

public class Pedido {
    private Integer id;
    private String codigo;
    private String fecha;
    private Integer usuarioId;
    private Integer total;
    private ArrayList<Item> items = new ArrayList<>();

    //Constructores con y sin parametros
    public Pedido(Integer id, String codigo, String fecha, Integer usuarioId, Integer total, ArrayList<Item> items) {
        this.id = id;
        this.codigo = codigo;
        this.fecha = fecha;
        this.usuarioId = usuarioId;
        this.total = total;
        this.items = items;
    }

    public Pedido() {
    }

    //Getters y setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Integer getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Integer usuarioId) {
        this.usuarioId = usuarioId;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }

    //toString
    @Override
    public String toString() {
        return "Pedido{" +
                "id=" + id +
                ", codigo='" + codigo + '\'' +
                ", fecha='" + fecha + '\'' +
                ", usuarioId=" + usuarioId +
                ", total=" + total +
                ", items=" + items +
                '}';
    }
}
