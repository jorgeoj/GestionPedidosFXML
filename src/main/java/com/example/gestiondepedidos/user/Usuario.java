package com.example.gestiondepedidos.user;

import com.example.gestiondepedidos.orders.Pedido;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Clase que representa un usuario en la aplicación de gestión de pedidos.
 * Esta clase almacena información sobre el usuario, incluyendo su identificación, nombre, contraseña,
 * dirección de correo electrónico
 * y una lista de pedidos asociados con el usuario.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Usuario implements Serializable {
    /**
     * Identificación única del usuario.
     */
    private Integer id;

    /**
     * Nombre del usuario.
     */
    private String nombre;

    /**
     * Contraseña del usuario.
     */
    private String contrasenya;

    /**
     * Dirección de correo electrónico del usuario.
     */
    private String email;

    /**
     * ArrayList que almacena los pedidos asociados con el usuario.
     */
    private ArrayList<Pedido> pedidos;
}

