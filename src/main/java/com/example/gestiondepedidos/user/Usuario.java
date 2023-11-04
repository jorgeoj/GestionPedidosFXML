package com.example.gestiondepedidos.user;

import com.example.gestiondepedidos.orders.Pedido;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Usuario implements Serializable {
    private Integer id;
    private String nombre;
    private String contrasenya;
    private String email;
    //ArrayList de pedidos para almacenar los pedidos de un usuario
    private ArrayList<Pedido> pedidos;

}
