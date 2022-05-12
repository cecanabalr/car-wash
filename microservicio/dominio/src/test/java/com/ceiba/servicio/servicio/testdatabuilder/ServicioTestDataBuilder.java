package com.ceiba.servicio.servicio.testdatabuilder;

import com.ceiba.servicio.modelo.entidad.Servicio;

public class ServicioTestDataBuilder {
    private long id;
    private String nombre;
    private Integer valor;

    public ServicioTestDataBuilder() {
        this.nombre = "lavado";
        this.valor = 30000;
    }

    public ServicioTestDataBuilder conId(Long id) {
        this.id = id;
        return this;
    }

    public ServicioTestDataBuilder conNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public ServicioTestDataBuilder conValor(Integer valor) {
        this.valor = valor;
        return this;
    }

    public Servicio build(){
        return new Servicio(id,nombre,valor);
    }
}
