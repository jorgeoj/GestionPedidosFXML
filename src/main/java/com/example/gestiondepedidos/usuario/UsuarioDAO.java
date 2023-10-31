package com.example.gestiondepedidos.usuario;

import java.util.ArrayList;

public interface UsuarioDAO {

    public Usuario load(Long id);
    public ArrayList<Usuario> loadAll();
}
