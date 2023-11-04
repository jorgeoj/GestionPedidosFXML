package com.example.gestiondepedidos.item;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ItemDAO {
    ArrayList<Item> loadAll(String var) throws SQLException;
}
