package com.ceiba.agenda.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.agenda.modelo.entidad.Agenda;
import com.ceiba.agenda.puerto.repositorio.RepositorioAgenda;
import com.ceiba.agenda.servicio.testdatabuilder.AgendaTestDataBuilder;
import com.ceiba.dominio.excepcion.ExcepcionRangoFechaNoValido;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ServicioCrearAgendaTest {

    @Test
    @DisplayName("Deberia lanzar una exepcion cuando la lista de agenda sea vacia")
    void deberiaLanzarUnaExepcionCuandoSeValideLaExistenciaDeAgendas() {
        // arrange
        List<Agenda> agenda = new ArrayList<>();
        RepositorioAgenda repositorioAgenda = Mockito.mock(RepositorioAgenda.class);
        ServicioCrearAgenda servicioCrearAgenda = new ServicioCrearAgenda(repositorioAgenda);
        // act - assert
        BasePrueba.assertThrows(() -> servicioCrearAgenda.ejecutar(agenda), ExcepcionRangoFechaNoValido.class,"El rango de fecha seleccionado no es valido");
    }

    @Test
    @DisplayName("Deberia crear las agendas de manera correcta")
    void deberiaCrearLasAgendasDeManeraCorrecta() {
        // arrange
        List<Agenda> agendas = new ArrayList<>();
        Agenda agenda = new AgendaTestDataBuilder().build();
        Agenda agenda2 = new AgendaTestDataBuilder()
                .conFechaInicio(LocalDateTime.of(2022,5,15,7,0))
                .conFechaFin(LocalDateTime.of(2022,5,15,8,0)).build();
        agendas.add(agenda);
        agendas.add(agenda2);
        RepositorioAgenda repositorioAgenda = Mockito.mock(RepositorioAgenda.class);

        ServicioCrearAgenda servicioCrearAgenda = new ServicioCrearAgenda(repositorioAgenda);
        // act
        String respuesta = servicioCrearAgenda.ejecutar(agendas);
        // assert
        assertEquals("Agenda creada", respuesta);
        Mockito.verify(repositorioAgenda, Mockito.times(1)).crear(agenda);
    }
}
