package com.ceiba.agenda.servicio.testdatabuilder;

import com.ceiba.agenda.modelo.entidad.Agenda;

import java.time.LocalDateTime;

public class AgendaTestDataBuilder {
    private Long id;
    private LocalDateTime fecha_inicio;
    private LocalDateTime fecha_fin;
    private LocalDateTime fecha_creacion;
    private Boolean disponibilidad;

    public AgendaTestDataBuilder() {
        this.fecha_inicio = LocalDateTime.of(2022,5,13,7,0);
        this.fecha_fin = LocalDateTime.of(2022,5,13,8,0);
        this.fecha_creacion = LocalDateTime.of(2022,5,13,6,0);
        this.disponibilidad = true;
    }

    public AgendaTestDataBuilder conId(Long id) {
        this.id = id;
        return this;
    }
    public AgendaTestDataBuilder conFechaInicio(LocalDateTime fechaInicio) {
        this.fecha_inicio = fechaInicio;
        return this;
    }
    public AgendaTestDataBuilder conFechaFin(LocalDateTime fechaFin) {
        this.fecha_fin = fechaFin;
        return this;
    }
    public AgendaTestDataBuilder conFechaCreacion(LocalDateTime fechaCreacion) {
        this.fecha_creacion = fechaCreacion;
        return this;
    }
    public AgendaTestDataBuilder conDisponibilidad(boolean disponibilidad) {
        this.disponibilidad = disponibilidad;
        return this;
    }

    public Agenda build(){
        return new Agenda(id,fecha_inicio,fecha_fin,fecha_creacion,disponibilidad);
    }
}
