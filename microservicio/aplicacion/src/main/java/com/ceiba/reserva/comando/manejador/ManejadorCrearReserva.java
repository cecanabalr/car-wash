package com.ceiba.reserva.comando.manejador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.manejador.ManejadorComandoRespuesta;
import com.ceiba.reserva.comando.ComandoReserva;
import com.ceiba.reserva.comando.fabrica.FabricaReserva;
import com.ceiba.cantidad.comando.manejador.ManejadorCrearCantidad;
import com.ceiba.reserva.modelo.entidad.Reserva;
import com.ceiba.reserva.servicio.ServicioCrearReserva;
import org.springframework.stereotype.Component;

@Component
public class ManejadorCrearReserva  implements ManejadorComandoRespuesta<ComandoReserva, ComandoRespuesta<Long>> {


    private final FabricaReserva fabricaReserva;
    private final ServicioCrearReserva servicioCrearReserva;

    private final ManejadorCrearCantidad manejadorCrearCantidad;



    public ManejadorCrearReserva(FabricaReserva fabricaReserva, ServicioCrearReserva servicioCrearReserva, ManejadorCrearCantidad manejadorCrearCantidad) {
        this.fabricaReserva = fabricaReserva;
        this.servicioCrearReserva = servicioCrearReserva;
        this.manejadorCrearCantidad = manejadorCrearCantidad;
    }

    public ComandoRespuesta<Long> ejecutar(ComandoReserva comandoReserva){
        Reserva reserva = this.fabricaReserva.crear(comandoReserva);
        Long idReserva = this.servicioCrearReserva.ejecutar(reserva);
        this.manejadorCrearCantidad.ejecutar(comandoReserva.getPlaca());
        return new ComandoRespuesta<>(idReserva);
    }
}
