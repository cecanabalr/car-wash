package com.ceiba.servicio.modelo.entidad;

import lombok.Getter;

import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;

@Getter
public class Servicio {

    private static final String SE_DEBE_INGRESAR_EL_VALOR_DEL_SERVICIO = "Se debe ingresar el valor del servicio";
    private static final String SE_DEBE_INGRESAR_EL_NOMBRE_DEL_SERVICIO = "Se debe ingresar el nombre del servicio";


    private long id;
    private String nombre;
    private Integer valor;

    public Servicio(long id, String nombre, Integer valor) {
        validarObligatorio(nombre, SE_DEBE_INGRESAR_EL_NOMBRE_DEL_SERVICIO);
        validarObligatorio(valor, SE_DEBE_INGRESAR_EL_VALOR_DEL_SERVICIO);

        this.id = id;
        this.nombre = nombre;
        this.valor = valor;
    }
}
