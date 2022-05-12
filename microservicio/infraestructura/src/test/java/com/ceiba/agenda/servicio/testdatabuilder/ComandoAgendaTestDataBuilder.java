package com.ceiba.agenda.servicio.testdatabuilder;

import com.ceiba.agenda.comando.ComandoAgenda;

import java.time.LocalDate;


public class ComandoAgendaTestDataBuilder {

    private LocalDate fecha_inicio;
    private LocalDate fecha_fin;

    public ComandoAgendaTestDataBuilder() {
        LocalDate fecha = LocalDate.now();
        this.fecha_inicio = fecha;
        this.fecha_fin = fecha.plusDays(5);
    }

    public ComandoAgenda build(){
        return new ComandoAgenda(fecha_inicio,fecha_fin);
    }
}
