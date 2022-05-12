package com.ceiba.dominio.excepcion;

public class ExcepcionRegistroNoDisponible extends RuntimeException{

    public ExcepcionRegistroNoDisponible(String mensaje) {
        super(mensaje);
    }
}
