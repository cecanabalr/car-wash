package com.ceiba.agenda.modelo.entidad;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

import static com.ceiba.dominio.ValidadorArgumento.validarMenor;
import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;

@Getter
@Setter
public class Agenda {


    public static final String NO_PUEDE_SER_MAYOR_A_LA_FECHA_FINAL = "Fecha Inicial no puede ser mayor a la fecha final";
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
}
