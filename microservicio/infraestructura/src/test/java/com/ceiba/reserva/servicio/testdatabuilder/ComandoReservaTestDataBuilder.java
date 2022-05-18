package com.ceiba.reserva.servicio.testdatabuilder;

import com.ceiba.reserva.comando.ComandoAgendaReserva;
import com.ceiba.reserva.comando.ComandoReserva;
import com.ceiba.reserva.comando.ComandoServicioReserva;
public class ComandoReservaTestDataBuilder {
    private String nombre;
    private String placa;
    private ComandoServicioReserva servicio;
    private ComandoAgendaReserva agenda;

    public ComandoReservaTestDataBuilder() {
        this.nombre = "carlos";
        this.placa = "ZXC123";
        this.servicio = new ComandoServicioReservaTestDataBuilder().build();
        this.agenda = new ComandoAgendaReservaTestDataBuilder().build();
    }

    public ComandoReserva build(){
        return new ComandoReserva(nombre,placa,servicio,agenda);
    }
}
