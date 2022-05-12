package com.ceiba.reserva.servicio.testdatabuilder;

import com.ceiba.reserva.modelo.entidad.Reserva;

import java.time.LocalDateTime;

public class ReservaTestDataBuilder {

    private Long id;
    private String nombre;
    private String placa;
    private LocalDateTime fechaCreacion;
    private Long idAgenda;
    private Long idServicio;

    private int total;

    public ReservaTestDataBuilder() {
        this.nombre = "carlos";
        this.placa = "ZXC123";
        this.fechaCreacion = LocalDateTime.of(2022,5,13,6,0);
        this.idAgenda = 60L;
        this.idServicio = 2L;
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

    public ReservaTestDataBuilder conIdAgenda(Long idAgenda) {
        this.idAgenda = idAgenda;
        return this;
    }

    public ReservaTestDataBuilder conIdServicio(Long idServicio) {
        this.idServicio = idServicio;
        return this;
    }

    public ReservaTestDataBuilder conTotal(int total) {
        this.total = total;
        return this;
    }

    public Reserva build(){
        return new Reserva(id,nombre,placa,fechaCreacion,idAgenda,idServicio,total);
    }
}
