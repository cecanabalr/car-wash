package com.ceiba.reserva.modelo.entidad;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;

@Getter
@Setter
public class Reserva {

    private static final String SE_DEBE_INGRESAR_EL_NOMBRE = "Se debe ingresar el nombre";
    private static final String SE_DEBE_INGRESAR_LA_PLACA = "Se debe ingresar la placa";
    private static final String SE_DEBE_INGRESAR_LA_AGENDA = "Se debe ingresar la agenda";
    private static final String SE_DEBE_INGRESAR_EL_SERVICIO = "Se debe ingresar el servicio";

    private Long id;
    private String nombre;
    private String placa;
    private LocalDateTime fechaCreacion;
    private Long idAgenda;
    private Long idServicio;

    private int total;

    public Reserva(Long id, String nombre, String placa, LocalDateTime fechaCreacion, Long idAgenda, Long idServicio, int total) {

        validarObligatorio(nombre, SE_DEBE_INGRESAR_EL_NOMBRE);
        validarObligatorio(placa, SE_DEBE_INGRESAR_LA_PLACA);
        validarObligatorio(idAgenda, SE_DEBE_INGRESAR_LA_AGENDA);
        validarObligatorio(idServicio, SE_DEBE_INGRESAR_EL_SERVICIO);

        this.id = id;
        this.nombre = nombre;
        this.placa = placa;
        this.fechaCreacion = fechaCreacion;
        this.idAgenda = idAgenda;
        this.idServicio = idServicio;
        this.total = total;
    }
}
