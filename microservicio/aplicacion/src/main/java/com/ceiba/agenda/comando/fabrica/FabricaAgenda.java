package com.ceiba.agenda.comando.fabrica;

import com.ceiba.agenda.modelo.entidad.Agenda;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class FabricaAgenda {

    public Agenda crear(LocalDateTime fechaInicio,LocalDateTime fechaFin){
        return new Agenda(
                0L,
                fechaInicio,
                fechaFin,
                LocalDateTime.now(),
                true
        );
    }

}
