package com.ceiba.reserva.servicio.testdatabuilder;

import com.ceiba.reserva.comando.ComandoAgendaReserva;

public class ComandoAgendaReservaTestDataBuilder {
    private Long id;

    public ComandoAgendaReservaTestDataBuilder() {
        this.id = 1L;
    }

    public ComandoAgendaReserva build(){
        return new ComandoAgendaReserva(id);
    }
}
