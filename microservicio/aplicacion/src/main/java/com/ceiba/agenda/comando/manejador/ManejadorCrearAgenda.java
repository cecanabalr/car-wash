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


    private static final int HORA_FIN = 22;
    public static final int HORA_INICIO = 7;

    private final FabricaAgenda fabricaAgenda;
    private final ServicioCrearAgenda servicioCrearAgenda;

    public ManejadorCrearAgenda(FabricaAgenda fabricaAgenda,
                                ServicioCrearAgenda servicioCrearAgenda) {
        this.fabricaAgenda = fabricaAgenda;
        this.servicioCrearAgenda = servicioCrearAgenda;
    }

    public ComandoRespuesta<String> ejecutar(ComandoAgenda comandoAgenda){
        return new ComandoRespuesta<>(this.servicioCrearAgenda
                .ejecutar(agendas(comandoAgenda)));
    }

    private List<Agenda> agendas(ComandoAgenda comandoAgenda){
        List<Agenda> agendaLista = new ArrayList<>();
        int horaInicio = HORA_INICIO;
        LocalDate fechaRangoInicial = comandoAgenda.getFechaInicio();
        LocalDate fechaRangoFinal = comandoAgenda.getFechaFin();

        while ( fechaRangoInicial.isBefore(fechaRangoFinal.plusDays(1))) {

            while (horaInicio <= HORA_FIN) {
               LocalDateTime fechaInicioPorDia =
                      agendaPorHora(fechaRangoInicial, LocalTime.of(horaInicio, 0));
               LocalDateTime fechaFinPorDia = fechaInicioPorDia.plusHours(1);
               agendaLista.add(this.fabricaAgenda.crear(fechaInicioPorDia, fechaFinPorDia));
               horaInicio += 1;
            }
            horaInicio = HORA_INICIO;
            fechaRangoInicial = fechaRangoInicial.plusDays(1);

        }

        return agendaLista;

    }

    private LocalDateTime agendaPorHora(LocalDate fecha, LocalTime hora){
        return LocalDateTime.of(fecha,hora);
    }
}
