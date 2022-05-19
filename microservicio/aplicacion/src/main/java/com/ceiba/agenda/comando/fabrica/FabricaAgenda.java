package com.ceiba.agenda.comando.fabrica;

import com.ceiba.agenda.modelo.entidad.Agenda;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
public class FabricaAgenda {

    public List<Agenda> crear(LocalDate fechaInicio, LocalDate fechaFin){
        return new Agenda().agendas(fechaInicio,fechaFin);
    }

}
