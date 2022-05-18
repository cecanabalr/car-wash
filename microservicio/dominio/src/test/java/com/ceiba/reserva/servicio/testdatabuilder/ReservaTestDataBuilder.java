package com.ceiba.reserva.servicio.testdatabuilder;

import com.ceiba.agenda.modelo.entidad.Agenda;
import com.ceiba.agenda.servicio.testdatabuilder.AgendaTestDataBuilder;
import com.ceiba.cantidad.modelo.entidad.Cantidad;
import com.ceiba.cantidad.servicio.testdatabuilder.CantidadTestDataBuilder;
import com.ceiba.reserva.modelo.entidad.Reserva;
import com.ceiba.servicio.modelo.entidad.Servicio;
import com.ceiba.servicio.servicio.testdatabuilder.ServicioTestDataBuilder;

import java.time.LocalDateTime;

public class ReservaTestDataBuilder {

    private Long id;
    private String nombre;
    private String placa;
    private LocalDateTime fechaCreacion;
    private Agenda agenda;
    private Servicio servicio;
    private Cantidad cantidad;
    private int total;

    public ReservaTestDataBuilder() {
        this.nombre = "carlos";
        this.placa = "ZXC123";
        this.fechaCreacion = LocalDateTime.of(2022,5,13,6,0);
        this.agenda = new AgendaTestDataBuilder().conId(1L).build();
        this.servicio = new ServicioTestDataBuilder().conId(1L).build();
        this.cantidad = new CantidadTestDataBuilder().conId(1L).build();
        this.total = 0;
    }

    public ReservaTestDataBuilder conId(Long id) {
        this.id = id;
        return this;
    }

    public ReservaTestDataBuilder conNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public ReservaTestDataBuilder conPlaca(String placa) {
        this.placa = placa;
        return this;
    }

    public ReservaTestDataBuilder conFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
        return this;
    }

    public ReservaTestDataBuilder conIdAgenda(Agenda agenda) {
        this.agenda = agenda;
        return this;
    }

    public ReservaTestDataBuilder conIdServicio(Servicio servicio) {
        this.servicio = servicio;
        return this;
    }

    public ReservaTestDataBuilder conCantidad(Cantidad cantidad) {
        this.cantidad = cantidad;
        return this;
    }

    public ReservaTestDataBuilder conTotal(int total) {
        this.total = total;
        return this;
    }

    public Reserva build(){
        return new Reserva(id,nombre,placa,fechaCreacion,agenda,servicio,cantidad,total);
    }
}
