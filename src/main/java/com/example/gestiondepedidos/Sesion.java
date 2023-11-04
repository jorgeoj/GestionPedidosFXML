package com.example.gestiondepedidos;

import com.example.gestiondepedidos.item.Item;
import com.example.gestiondepedidos.orders.Pedido;
import com.example.gestiondepedidos.products.Producto;
import com.example.gestiondepedidos.user.Usuario;

import java.util.ArrayList;

/**
 * Clase que representa una sesión de usuario en la aplicación de gestión de pedidos.
 * Esta clase almacena información sobre el usuario, los pedidos, productos e items relacionados con la sesión.
 */
public class Sesion {
    private static Integer pos = null;
    private static Usuario usuario;
    private static Pedido pedido;
    private static ArrayList<Pedido> pedidos = new ArrayList();
    private static ArrayList<Producto> productos = new ArrayList();
    private static ArrayList<Item> items = new ArrayList();

    /**
     * Constructor por defecto de la clase Sesion.
     */
    public Sesion() {
    }

    /**
     * Obtiene la posición actual en la sesión.
     *
     * @return La posición actual.
     */
    public static Integer getPos() {
        return pos;
    }

    /**
     * Establece la posición actual en la sesión.
     *
     * @param pos La posición actual a establecer.
     */
    public static void setPos(Integer pos) {
        Sesion.pos = pos;
    }

    /**
     * Obtiene el pedido actual en la sesión.
     *
     * @return El pedido actual.
     */
    public static Pedido getPedido() {
        return pedido;
    }

    /**
     * Establece el pedido actual en la sesión.
     *
     * @param pedido El pedido a establecer como actual.
     */
    public static void setPedido(Pedido pedido) {
        Sesion.pedido = pedido;
    }

    /**
     * Obtiene el usuario actual en la sesión.
     *
     * @return El usuario actual.
     */
    public static Usuario getUsuario() {
        return usuario;
    }

    /**
     * Establece el usuario actual en la sesión.
     *
     * @param usuario El usuario a establecer como actual.
     */
    public static void setUsuario(Usuario usuario) {
        Sesion.usuario = usuario;
    }

    /**
     * Obtiene la lista de pedidos asociados con la sesión.
     *
     * @return La lista de pedidos.
     */
    public static ArrayList<Pedido> getPedidos() {
        return pedidos;
    }

    /**
     * Establece la lista de pedidos asociados con la sesión.
     *
     * @param pedidos La lista de pedidos a establecer.
     */
    public static void setPedidos(ArrayList<Pedido> pedidos) {
        Sesion.pedidos = pedidos;
    }

    /**
     * Obtiene la lista de productos asociados con la sesión.
     *
     * @return La lista de productos.
     */
    public static ArrayList<Producto> getProductos() {
        return productos;
    }

    /**
     * Establece la lista de productos asociados con la sesión.
     *
     * @param productos La lista de productos a establecer.
     */
    public static void setProductos(ArrayList<Producto> productos) {
        Sesion.productos = productos;
    }

    /**
     * Obtiene la lista de items asociados con la sesión.
     *
     * @return La lista de items.
     */
    public static ArrayList<Item> getItems() {
        return items;
    }

    /**
     * Establece la lista de items asociados con la sesión.
     *
     * @param items La lista de items a establecer.
     */
    public static void setItems(ArrayList<Item> items) {
        Sesion.items = items;
    }
}
