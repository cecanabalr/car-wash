package com.ceiba.cantidad.servicio.testdatabuilder;

import com.ceiba.cantidad.modelo.entidad.Cantidad;

import java.time.LocalDateTime;

public class CantidadTestDataBuilder {
    private Long id;
    private String placa;
    private int cantidad;
    private LocalDateTime fechaActualizacion;

    public CantidadTestDataBuilder() {
        this.placa = "ZXC123";
        this.cantidad = 1;
        this.fechaActualizacion = LocalDateTime.of(2022,5,13,1,0);
    }

    public CantidadTestDataBuilder conId(Long id) {
        this.id = id;
        return this;
    }
    public CantidadTestDataBuilder conPlaca(String placa) {
        this.placa = placa;
        return this;
    }
    public CantidadTestDataBuilder conCantidad(int cantidad) {
        this.cantidad = cantidad;
        return this;
    }
    public CantidadTestDataBuilder conFechaActualizacion(LocalDateTime fechaActualizacion) {
        this.fechaActualizacion = fechaActualizacion;
        return this;
    }

    public Cantidad build(){
        return new Cantidad(id,placa,cantidad,fechaActualizacion);
    }
}
