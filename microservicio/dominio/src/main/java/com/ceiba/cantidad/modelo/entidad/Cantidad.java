package com.ceiba.cantidad.modelo.entidad;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;

@Getter
@Setter
public class Cantidad {

    private static  final String SE_DEBE_INGRESAR_LA_PLACA = "Se debe ingresar la placa";
    private static  final String SE_DEBE_INGRESAR_LA_CANTIDAD = "Se debe ingresar la cantidad";

    private Long id;
    private String placa;
    private int contador;
    private LocalDateTime fechaActualizacion;

    public Cantidad(Long id, String placa, int contador, LocalDateTime fechaActualizacion) {

        validarObligatorio(placa, SE_DEBE_INGRESAR_LA_PLACA);

        this.id = id;
        this.placa = placa;
        this.contador = contador;
        this.fechaActualizacion = fechaActualizacion;
    }
}
