package com.ceiba.agenda.comando.manejador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.agenda.comando.ComandoAgenda;
import com.ceiba.agenda.comando.fabrica.FabricaAgenda;
import com.ceiba.agenda.modelo.entidad.Agenda;
import com.ceiba.agenda.servicio.ServicioCrearAgenda;
import com.ceiba.manejador.ManejadorComandoRespuesta;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Component
public class ManejadorCrearAgenda implements ManejadorComandoRespuesta<ComandoAgenda, ComandoRespuesta<String>> {

    private final FabricaAgenda fabricaAgenda;
    private final ServicioCrearAgenda servicioCrearAgenda;

    public ManejadorCrearAgenda(FabricaAgenda fabricaAgenda,
                                ServicioCrearAgenda servicioCrearAgenda) {
        this.fabricaAgenda = fabricaAgenda;
        this.servicioCrearAgenda = servicioCrearAgenda;
    }

    public ComandoRespuesta<String> ejecutar(ComandoAgenda comandoAgenda){
        List<Agenda> agendas = this.fabricaAgenda.crear(comandoAgenda.getFechaInicio(), comandoAgenda.getFechaFin());
        return new ComandoRespuesta<>(this.servicioCrearAgenda
                .ejecutar(agendas));
    }

}
