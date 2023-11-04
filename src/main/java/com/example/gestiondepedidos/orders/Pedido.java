package com.example.gestiondepedidos.orders;

import com.example.gestiondepedidos.item.Item;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pedido implements Serializable {
    private Integer id;
    private String codigo;
    private String fecha;
    private Integer usuarioId;
    private Integer total;
    private ArrayList<Item> items = new ArrayList<>();
}
