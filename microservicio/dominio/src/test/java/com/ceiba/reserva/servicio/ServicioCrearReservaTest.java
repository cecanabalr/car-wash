package com.ceiba.reserva.servicio;

import com.ceiba.agenda.modelo.entidad.Agenda;
import com.ceiba.agenda.servicio.testdatabuilder.AgendaTestDataBuilder;
import com.ceiba.cantidad.modelo.entidad.Cantidad;
import com.ceiba.cantidad.servicio.testdatabuilder.CantidadTestDataBuilder;
import com.ceiba.reserva.modelo.entidad.Reserva;
import com.ceiba.reserva.puerto.repositorio.RepositorioReserva;
import com.ceiba.reserva.servicio.testdatabuilder.ReservaTestDataBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class ServicioCrearReservaTest {


    @Test
    @DisplayName("Deberia crear una reserva con descuento de lunes correctamente")
    void deberiaCrearunaReservaConDescuentoPorSerLunes() {

        Agenda agenda = new AgendaTestDataBuilder()
                .conFechaInicio(LocalDateTime.of(2022,5,16,7,0))
                .conFechaFin(LocalDateTime.of(2022,5,16,8,0))
                .build();
        Reserva reserva = new ReservaTestDataBuilder()
                .conIdAgenda(agenda).build();
        RepositorioReserva repositorioReserva = Mockito.mock(RepositorioReserva.class);
        Mockito.when(repositorioReserva.crear(Mockito.any())).thenReturn(1L);

        ServicioCrearReserva servicioCrearReserva = new ServicioCrearReserva(repositorioReserva);
        Long idReserva = servicioCrearReserva.ejecutar(reserva);

        ArgumentCaptor<Reserva> captorReserva = ArgumentCaptor.forClass(Reserva.class);
        Mockito.verify(repositorioReserva, Mockito.times(1)).crear(captorReserva.capture());
        assertEquals(1L,idReserva);
    }


    @Test
    @DisplayName("Deberia crear una reserva con incremento por ser festivo correctamente")
    void deberiaCrearUnaReservaConIncrementoPorSerFestivo() {

        Agenda agenda = new AgendaTestDataBuilder()
                .conFechaInicio(LocalDateTime.of(2022,5,30,7,0))
                .conFechaFin(LocalDateTime.of(2022,5,30,8,0))
                .build();
        Reserva reserva = new ReservaTestDataBuilder()
                .conIdAgenda(agenda).build();

        RepositorioReserva repositorioReserva = Mockito.mock(RepositorioReserva.class);
        Mockito.when(repositorioReserva.crear(Mockito.any())).thenReturn(1L);

        ServicioCrearReserva servicioCrearReserva = new ServicioCrearReserva(repositorioReserva);
        Long idReserva = servicioCrearReserva.ejecutar(reserva);

        ArgumentCaptor<Reserva> captorReserva = ArgumentCaptor.forClass(Reserva.class);
        Mockito.verify(repositorioReserva, Mockito.times(1)).crear(captorReserva.capture());
        assertEquals(1L,idReserva);
    }

    @Test
    @DisplayName("Deberia crear una reserva con valor gratis correctamente")
    void deberiaCrearUnaReservaConValorTotalCero() {

        Cantidad cantidad = new CantidadTestDataBuilder().conId(1L).conCantidad(7).build();
        Reserva reserva = new ReservaTestDataBuilder()
                .conCantidad(cantidad).build();
        RepositorioReserva repositorioReserva = Mockito.mock(RepositorioReserva.class);
        Mockito.when(repositorioReserva.crear(Mockito.any())).thenReturn(1L);

        ServicioCrearReserva servicioCrearReserva = new ServicioCrearReserva(repositorioReserva);
        Long idReserva = servicioCrearReserva.ejecutar(reserva);

        ArgumentCaptor<Reserva> captorReserva = ArgumentCaptor.forClass(Reserva.class);
        Mockito.verify(repositorioReserva, Mockito.times(1)).crear(captorReserva.capture());
        assertEquals(1L,idReserva);

    }
    @Test
    @DisplayName("Deberia crear una reserva con valor normal del servicio correctamente")
    void deberiaCrearUnaReservaConValorNormalDelServicio() {

        Reserva reserva = new ReservaTestDataBuilder()
                .conCantidad(null).build();
        RepositorioReserva repositorioReserva = Mockito.mock(RepositorioReserva.class);
        Mockito.when(repositorioReserva.crear(Mockito.any())).thenReturn(1L);

        ServicioCrearReserva servicioCrearReserva = new ServicioCrearReserva(repositorioReserva);
        Long idReserva = servicioCrearReserva.ejecutar(reserva);

        ArgumentCaptor<Reserva> captorReserva = ArgumentCaptor.forClass(Reserva.class);
        Mockito.verify(repositorioReserva, Mockito.times(1)).crear(captorReserva.capture());
        assertEquals(1L,idReserva);

    }
}
