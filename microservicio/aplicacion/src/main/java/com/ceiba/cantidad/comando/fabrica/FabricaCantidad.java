package com.ceiba.cantidad.comando.fabrica;

import com.ceiba.cantidad.modelo.entidad.Cantidad;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class FabricaCantidad {

    public Cantidad crear(String placa){
        return new Cantidad(0L, placa, 1, LocalDateTime.now());
    }
}
