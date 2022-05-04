package com.ceiba.usuario.comando.fabrica;

import com.ceiba.usuario.modelo.entidad.Usuario;
import org.springframework.stereotype.Component;

import com.ceiba.usuario.comando.ComandoUsuario;

import java.time.LocalDateTime;

@Component
public class FabricaUsuario {

    public Usuario crear(ComandoUsuario comandoUsuario) {
        comandoUsuario.setFecha(LocalDateTime.now());
        return new Usuario(
                comandoUsuario.getId(),
                comandoUsuario.getNombre(),
                comandoUsuario.getClave(),
                comandoUsuario.getFecha()
        );
    }

}
