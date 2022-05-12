package com.ceiba.reserva.servicio.testdatabuilder;

import com.ceiba.reserva.comando.ComandoReserva;
import com.ceiba.servicio.comando.ComandoServicio;
import com.ceiba.servicio.servicio.testdatabuilder.ComandoServicioTestDataBuilder;

public class ComandoReservaTestDataBuilder {
    private String nombre;
    private String placa;
    private ComandoServicio servicio;
    private Long idAgenda;

    public ComandoReservaTestDataBuilder() {
        this.nombre = "carlos";
        this.placa = "ZXC123";
        this.servicio = new ComandoServicioTestDataBuilder().build();
        this.idAgenda = 1L;
    }

    public ComandoReserva build(){
        return new ComandoReserva(nombre,placa,servicio,idAgenda);
    }
}
