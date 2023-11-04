package com.example.gestiondepedidos.item;

import com.example.gestiondepedidos.products.Producto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Item implements Serializable {
    private Integer id;
    private String codigo_pedido;
    private Producto producto_id;
    private Integer cantidad;

}
