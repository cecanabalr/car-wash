package com.ceiba.reserva.comando.fabrica;

import com.ceiba.reserva.comando.ComandoReserva;
import com.ceiba.reserva.modelo.entidad.Reserva;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class FabricaReserva {

    public Reserva crear(ComandoReserva comandoReserva){
        return new Reserva(
                0L,
                comandoReserva.getNombre(),
                comandoReserva.getPlaca(),
                LocalDateTime.now(),
                comandoReserva.getIdAgenda(),
                comandoReserva.getServicio().getId(),
                comandoReserva.getServicio().getValor()
        );
    }
}
