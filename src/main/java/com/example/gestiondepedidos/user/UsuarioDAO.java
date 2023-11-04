package com.example.gestiondepedidos.user;

import com.example.gestiondepedidos.user.Usuario;

import java.util.ArrayList;

/**
 * Interfaz que define operaciones para acceder y gestionar datos de usuarios en una base de datos.
 */
public interface UsuarioDAO {
    /**
     * Carga un usuario desde la base de datos utilizando su dirección de correo electrónico y contraseña.
     *
     * @param email      Dirección de correo electrónico del usuario.
     * @param contrasenya Contraseña del usuario a verificar.
     * @return Objeto Usuario si se encuentra el usuario y la contraseña es correcta, o null si no se encuentra.
     */
    Usuario loadUser(String email, String contrasenya);
}

