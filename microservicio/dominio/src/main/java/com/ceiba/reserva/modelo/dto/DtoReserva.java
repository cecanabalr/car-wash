package com.ceiba.reserva.modelo.dto;

import com.ceiba.agenda.modelo.dto.DtoAgenda;
import com.ceiba.servicio.modelo.dto.DtoServicio;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class DtoReserva {

    private Long id;
    private String nombre;
    private String placa;
    private LocalDateTime fechaCreacion;
    private DtoAgenda agenda;
    private DtoServicio servicio;
    private int total;
}
