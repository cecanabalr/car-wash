package com.ceiba.dominio.excepcion;

public class ExcepcionRangoFechaNoValido extends RuntimeException{


    public ExcepcionRangoFechaNoValido(String mensaje) {
        super(mensaje);
    }
}
