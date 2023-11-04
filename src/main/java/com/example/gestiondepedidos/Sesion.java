package com.example.gestiondepedidos;

import com.example.gestiondepedidos.item.Item;
import com.example.gestiondepedidos.orders.Pedido;
import com.example.gestiondepedidos.products.Producto;
import com.example.gestiondepedidos.user.Usuario;

import java.util.ArrayList;

public class Sesion {
    private static Integer pos = null;
    private static Usuario usuario;
    private static Pedido pedido;
    private static ArrayList<Pedido> pedidos = new ArrayList();
    private static ArrayList<Producto> productos = new ArrayList();
    private static ArrayList<Item> items = new ArrayList();

    public Sesion() {
    }

    public static Integer getPos() {
        return pos;
    }

    public static void setPos(Integer pos) {
        Sesion.pos = pos;
    }

    public static Pedido getPedido() {
        return pedido;
    }

    public static void setPedido(Pedido pedido) {
        Sesion.pedido = pedido;
    }

    public static Usuario getUsuario() {
        return usuario;
    }

    public static void setUsuario(Usuario usuario) {
        Sesion.usuario = usuario;
    }

    public static ArrayList<Pedido> getPedidos() {
        return pedidos;
    }

    public static void setPedidos(ArrayList<Pedido> pedidos) {
        Sesion.pedidos = pedidos;
    }

    public static ArrayList<Producto> getProductos() {
        return productos;
    }

    public static void setProductos(ArrayList<Producto> productos) {
        Sesion.productos = productos;
    }

    public static ArrayList<Item> getItems() {
        return items;
    }

    public static void setItems(ArrayList<Item> items) {
        Sesion.items = items;
    }
}
