package com.ceiba.agenda.comando;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoAgenda {
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
}
