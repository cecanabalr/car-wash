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
    private LocalDateTime fecha_inicio;
    private LocalDateTime fecha_fin;
    private LocalDateTime fecha_creacion;
    private Boolean disponibilidad;


    public Agenda(Long id, LocalDateTime fecha_inicio, LocalDateTime fecha_fin, LocalDateTime fecha_creacion, Boolean disponibilidad) {
        validarObligatorio(fecha_inicio, SE_DEBE_INGRESAR_LA_FECHA_INICIAL);
        validarObligatorio(fecha_fin, SE_DEBE_INGRESAR_LA_FECHA_FINAL);
        validarMenor(fecha_inicio, fecha_fin, NO_PUEDE_SER_MAYOR_A_LA_FECHA_FINAL);
        this.id = id;
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
        this.fecha_creacion = fecha_creacion;
        this.disponibilidad = disponibilidad;
    }
}
