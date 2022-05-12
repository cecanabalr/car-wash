package com.ceiba.cantidad.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;
@Getter
@AllArgsConstructor
public class DtoCantidad {
    private Long id;
    private String placa;
    private int cantidad;
    private LocalDateTime fechaActualizacion;
}
