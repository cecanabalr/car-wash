package com.ceiba.agenda.servicio;

import com.ceiba.agenda.modelo.entidad.Agenda;
import com.ceiba.agenda.puerto.repositorio.RepositorioAgenda;
import com.ceiba.dominio.excepcion.ExcepcionRangoFechaNoValido;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.util.List;

public class ServicioCrearAgenda {

    public static final String AGENDA_CREADA = "Agenda creada";
    public static final String RANGO_DE_FECHA_SELECCIONADO_NO_VALIDO = "El rango de fecha seleccionado no es valido";
    private final RepositorioAgenda repositorioAgenda;

    public ServicioCrearAgenda(RepositorioAgenda repositorioAgenda) {
        this.repositorioAgenda = repositorioAgenda;
    }

    public String ejecutar(List<Agenda> agendas){
            if (agendas.isEmpty()){
               throw new ExcepcionRangoFechaNoValido(RANGO_DE_FECHA_SELECCIONADO_NO_VALIDO);
            }else{
                agendas.forEach(agenda -> {
                    if(isDayWeek(agenda.getFecha_inicio())){
                        this.repositorioAgenda.crear(agenda);
                    }
                });
                return AGENDA_CREADA;
            }
    }

    private boolean isDayWeek(LocalDateTime fechaRangoInicial) {
        return !(fechaRangoInicial.getDayOfWeek() == DayOfWeek.SATURDAY
                || fechaRangoInicial.getDayOfWeek() == DayOfWeek.SUNDAY);
    }
}
