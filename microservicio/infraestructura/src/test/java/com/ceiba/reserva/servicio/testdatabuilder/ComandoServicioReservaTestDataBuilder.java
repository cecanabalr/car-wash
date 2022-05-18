package com.ceiba.reserva.servicio.testdatabuilder;

import com.ceiba.reserva.comando.ComandoAgendaReserva;
import com.ceiba.reserva.comando.ComandoServicioReserva;

public class ComandoServicioReservaTestDataBuilder {

    private Long id;

    public ComandoServicioReservaTestDataBuilder() {
        this.id = 1L;
    }

    public ComandoServicioReserva build(){
        return new ComandoServicioReserva(id);
    }
}
