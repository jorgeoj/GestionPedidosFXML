package com.example.gestiondepedidos.usuario;

import lombok.*;

import java.io.Serializable;

@Data
@RequiredArgsConstructor
@NoArgsConstructor
@AllArgsConstructor
public class Usuario implements Serializable {
    @NonNull
    Long id;
    @NonNull
    private String nombre;
    @NonNull
    private String password;
    @NonNull
    private String email;
}
