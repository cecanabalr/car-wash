package com.ceiba.reserva.comando;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoReserva {
    private String nombre;
    private String placa;
    private ComandoServicioReserva servicio;
    private ComandoAgendaReserva agenda;
}
