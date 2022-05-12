package com.ceiba.reserva.comando;

import com.ceiba.servicio.comando.ComandoServicio;
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
    private ComandoServicio servicio;
    private Long idAgenda;
}
