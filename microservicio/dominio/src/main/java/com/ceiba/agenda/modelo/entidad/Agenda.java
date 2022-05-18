package com.ceiba.agenda.modelo.entidad;

import lombok.Getter;
import lombok.Setter;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import static com.ceiba.dominio.ValidadorArgumento.validarMenor;
import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;

@Getter
public class Agenda {

    private static final int HORA_FIN = 22;
    public static final int HORA_INICIO = 7;

    private static final String NO_PUEDE_SER_MAYOR_A_LA_FECHA_FINAL = "Fecha Inicial no puede ser mayor a la fecha final";
    private static final String SE_DEBE_INGRESAR_LA_FECHA_INICIAL = "Se debe ingresar la fecha inicial";
    private static final String SE_DEBE_INGRESAR_LA_FECHA_FINAL = "Se debe ingresar la fecha final";
    private Long id;
    private LocalDateTime fechaInicio;
    private LocalDateTime fechaFin;
    private LocalDateTime fechaCreacion;
    private Boolean disponibilidad;


    public Agenda(Long id, LocalDateTime fechaInicio, LocalDateTime fechaFin, LocalDateTime fechaCreacion, Boolean disponibilidad) {
        validarObligatorio(fechaInicio, SE_DEBE_INGRESAR_LA_FECHA_INICIAL);
        validarObligatorio(fechaFin, SE_DEBE_INGRESAR_LA_FECHA_FINAL);
        validarMenor(fechaInicio, fechaFin, NO_PUEDE_SER_MAYOR_A_LA_FECHA_FINAL);
        this.id = id;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.fechaCreacion = fechaCreacion;
        this.disponibilidad = disponibilidad;
    }

    public static List<Agenda> agendas(LocalDate fechaRangoInicial, LocalDate fechaRangoFinal){
        List<Agenda> agendaLista = new ArrayList<>();
        int horaInicio = HORA_INICIO;
        while ( fechaRangoInicial.isBefore(fechaRangoFinal.plusDays(1))) {

            while (horaInicio <= HORA_FIN) {
                LocalDateTime fechaInicioPorDia =
                        agendaPorHora(fechaRangoInicial, LocalTime.of(horaInicio, 0));
                LocalDateTime fechaFinPorDia = fechaInicioPorDia.plusHours(1);
                agendaLista.add(new Agenda(0L,fechaInicioPorDia,fechaFinPorDia,LocalDateTime.now(),true));
                horaInicio += 1;
            }
            horaInicio = HORA_INICIO;
            fechaRangoInicial = fechaRangoInicial.plusDays(1);

        }

        return agendaLista;

    }

    private static LocalDateTime agendaPorHora(LocalDate fecha, LocalTime hora){
        return LocalDateTime.of(fecha,hora);
    }

    public static Agenda actualizarDisponibilidad(Agenda agenda){
        return new Agenda(agenda.getId(),agenda.getFechaInicio(),agenda.getFechaFin(),agenda.getFechaCreacion(), false);
    }

    public static boolean isDayWeek(LocalDateTime fechaInicio) {
        return !(fechaInicio.getDayOfWeek() == DayOfWeek.SATURDAY
                || fechaInicio.getDayOfWeek() == DayOfWeek.SUNDAY);
    }

    public static boolean validarSiEsLunes(LocalDateTime fechaInicio) {
        return fechaInicio.getDayOfWeek().equals(DayOfWeek.MONDAY);
    }
}
