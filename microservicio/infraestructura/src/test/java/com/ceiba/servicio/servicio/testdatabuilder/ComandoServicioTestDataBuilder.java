package com.ceiba.servicio.servicio.testdatabuilder;

import com.ceiba.servicio.comando.ComandoServicio;

public class ComandoServicioTestDataBuilder {


    private Long id;
    private String nombre;
    private Integer valor;

    public ComandoServicioTestDataBuilder() {
        this.id = 1L;
        this.nombre = "lavado";
        this.valor = 30000;
    }

    public ComandoServicio build(){
        return new ComandoServicio(id,nombre,valor);
    }
}
