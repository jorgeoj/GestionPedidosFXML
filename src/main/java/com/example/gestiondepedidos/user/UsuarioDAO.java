package com.example.gestiondepedidos.user;

import com.example.gestiondepedidos.user.Usuario;

import java.util.ArrayList;

public interface UsuarioDAO {

    public Usuario loadUser(String email, String contrasenya);
}
