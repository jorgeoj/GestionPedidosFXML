package com.example.gestiondepedidos.domain;

import com.example.gestiondepedidos.user.Usuario;

import java.util.ArrayList;

public interface UsuarioDAO {

    public Usuario load(Long id);
    public ArrayList<Usuario> loadAll();
}
