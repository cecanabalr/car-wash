package com.ceiba.reserva.comando.fabrica;

import com.ceiba.agenda.puerto.repositorio.RepositorioAgenda;
import com.ceiba.cantidad.puerto.repositorio.RepositorioCantidad;
import com.ceiba.reserva.comando.ComandoReserva;
import com.ceiba.reserva.modelo.entidad.Reserva;
import com.ceiba.servicio.puerto.repositorio.RepositorioServicio;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class FabricaReserva {

    private final RepositorioServicio repositorioServicio;
    private final RepositorioAgenda repositorioAgenda;

    private final RepositorioCantidad repositorioCantidad;

    public FabricaReserva(RepositorioServicio repositorioServicio, RepositorioAgenda repositorioAgenda, RepositorioCantidad repositorioCantidad) {
        this.repositorioServicio = repositorioServicio;
        this.repositorioAgenda = repositorioAgenda;
        this.repositorioCantidad = repositorioCantidad;
    }


    public Reserva crear(ComandoReserva comandoReserva){
        return new Reserva(
                0L,
                comandoReserva.getNombre(),
                comandoReserva.getPlaca(),
                LocalDateTime.now(),
                repositorioAgenda.existePorId(comandoReserva.getAgenda().getId()),
                repositorioServicio.existePorId(comandoReserva.getServicio().getId()),
                repositorioCantidad.existePorId(comandoReserva.getPlaca()),
                0
        );
    }
}
