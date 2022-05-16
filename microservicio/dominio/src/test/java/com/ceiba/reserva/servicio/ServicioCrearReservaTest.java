package com.ceiba.reserva.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.agenda.modelo.entidad.Agenda;
import com.ceiba.agenda.puerto.repositorio.RepositorioAgenda;
import com.ceiba.agenda.servicio.testdatabuilder.AgendaTestDataBuilder;
import com.ceiba.cantidad.modelo.entidad.Cantidad;
import com.ceiba.cantidad.puerto.repositorio.RepositorioCantidad;
import com.ceiba.cantidad.servicio.testdatabuilder.CantidadTestDataBuilder;
import com.ceiba.dominio.excepcion.ExcepcionRegistroNoDisponible;
import com.ceiba.reserva.modelo.entidad.Reserva;
import com.ceiba.reserva.puerto.repositorio.RepositorioReserva;
import com.ceiba.reserva.puerto.util.Festivo;
import com.ceiba.reserva.servicio.testdatabuilder.ReservaTestDataBuilder;
import com.ceiba.servicio.modelo.entidad.Servicio;
import com.ceiba.servicio.puerto.repositorio.RepositorioServicio;
import com.ceiba.servicio.servicio.testdatabuilder.ServicioTestDataBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class ServicioCrearReservaTest {

    @Test
    @DisplayName("Deberia lanzar una exepcion cuando la agenda no esta disponible")
    void deberiaLanzarUnaExepcionCuandoSeValideSiLaAgendaEstaDisponible() {

        Reserva reserva = new ReservaTestDataBuilder().build();

        RepositorioAgenda repositorioAgenda = Mockito.mock(RepositorioAgenda.class);
        RepositorioCantidad repositorioCantidad = Mockito.mock(RepositorioCantidad.class);
        RepositorioServicio repositorioServicio = Mockito.mock(RepositorioServicio.class);
        RepositorioReserva repositorioReserva = Mockito.mock(RepositorioReserva.class);
        Festivo festivo = Mockito.mock(Festivo.class);

        Mockito.when(repositorioAgenda.existePorId(60L)).thenReturn(null);


        ServicioCrearReserva servicioCrearReserva = new ServicioCrearReserva(repositorioReserva,repositorioAgenda,repositorioCantidad,repositorioServicio,festivo);

        BasePrueba.assertThrows(() -> servicioCrearReserva.ejecutar(reserva), ExcepcionRegistroNoDisponible.class, "La agenda seleccionada no esta disponible");
    }

    @Test
    @DisplayName("Deberia lanzar una exepcion cuando el servicio no esta disponible y no es festivo")
    void deberiaLanzarUnaExcepcionCuandoServicioEsNullYNoEsFestivo() {

        Reserva reserva = new ReservaTestDataBuilder().build();
        Agenda agenda = new AgendaTestDataBuilder()
                .conFechaInicio(LocalDateTime.of(2022,5,23,7,0))
                .conFechaFin(LocalDateTime.of(2022,5,23,8,0)).conId(60L).build();

        RepositorioAgenda repositorioAgenda = Mockito.mock(RepositorioAgenda.class);
        RepositorioCantidad repositorioCantidad = Mockito.mock(RepositorioCantidad.class);
        RepositorioServicio repositorioServicio = Mockito.mock(RepositorioServicio.class);
        RepositorioReserva repositorioReserva = Mockito.mock(RepositorioReserva.class);
        Festivo festivo = Mockito.mock(Festivo.class);

        Mockito.when(repositorioAgenda.existePorId(60L)).thenReturn(agenda);
        Mockito.when(festivo.getFestivos(LocalDate.from(agenda.getFechaInicio()).toString())).thenReturn(false);
        Mockito.when(repositorioServicio.existePorId(1L)).thenReturn(null);


        ServicioCrearReserva servicioCrearReserva = new ServicioCrearReserva(repositorioReserva,repositorioAgenda,repositorioCantidad,repositorioServicio,festivo);

        BasePrueba.assertThrows(() -> servicioCrearReserva.ejecutar(reserva), ExcepcionRegistroNoDisponible.class, "El servicio seleccionado no existe");
    }

    @Test
    @DisplayName("Deberia crear una reserva con descuento de lunes correctamente")
    void deberiaCrearunaReservaConDescuentoPorSerLunes() {

        Reserva reserva = new ReservaTestDataBuilder().build();
        Agenda agenda = new AgendaTestDataBuilder()
                .conFechaInicio(LocalDateTime.of(2022,5,23,7,0))
                .conFechaFin(LocalDateTime.of(2022,5,23,8,0)).conId(60L).build();
        Servicio servicio = new ServicioTestDataBuilder().conId(2L).build();

        RepositorioAgenda repositorioAgenda = Mockito.mock(RepositorioAgenda.class);
        RepositorioCantidad repositorioCantidad = Mockito.mock(RepositorioCantidad.class);
        RepositorioServicio repositorioServicio = Mockito.mock(RepositorioServicio.class);
        RepositorioReserva repositorioReserva = Mockito.mock(RepositorioReserva.class);
        Festivo festivo = Mockito.mock(Festivo.class);

        Mockito.when(repositorioAgenda.existePorId(60L)).thenReturn(agenda);
        Mockito.when(festivo.getFestivos(LocalDate.from(agenda.getFechaInicio()).toString())).thenReturn(false);
        Mockito.when(repositorioServicio.existePorId(2L)).thenReturn(servicio);
        Mockito.when(repositorioReserva.crear(reserva)).thenReturn(2L);


        ServicioCrearReserva servicioCrearReserva = new ServicioCrearReserva(repositorioReserva,repositorioAgenda,repositorioCantidad,repositorioServicio,festivo);

        Long idReserva = servicioCrearReserva.ejecutar(reserva);
        assertEquals(2L,idReserva);
    }
    @Test
    @DisplayName("Deberia lanzar una exepcion cuando el servicio no esta disponible y es festivo")
    void deberiaLanzarUnaExcepcionCuandoServicioEsNullYEsFestivo() {

        Reserva reserva = new ReservaTestDataBuilder().build();
        Agenda agenda = new AgendaTestDataBuilder()
                .conFechaInicio(LocalDateTime.of(2022,5,30,7,0))
                .conFechaFin(LocalDateTime.of(2022,5,30,8,0)).conId(60L).build();

        RepositorioAgenda repositorioAgenda = Mockito.mock(RepositorioAgenda.class);
        RepositorioCantidad repositorioCantidad = Mockito.mock(RepositorioCantidad.class);
        RepositorioServicio repositorioServicio = Mockito.mock(RepositorioServicio.class);
        RepositorioReserva repositorioReserva = Mockito.mock(RepositorioReserva.class);
        Festivo festivo = Mockito.mock(Festivo.class);

        Mockito.when(repositorioAgenda.existePorId(60L)).thenReturn(agenda);
        Mockito.when(repositorioServicio.existePorId(1L)).thenReturn(null);
        Mockito.when(festivo.getFestivos(LocalDate.from(agenda.getFechaInicio()).toString())).thenReturn(true);

        ServicioCrearReserva servicioCrearReserva = new ServicioCrearReserva(repositorioReserva,repositorioAgenda,repositorioCantidad,repositorioServicio,festivo);

        BasePrueba.assertThrows(() -> servicioCrearReserva.ejecutar(reserva), ExcepcionRegistroNoDisponible.class, "El servicio seleccionado no existe");
    }

    @Test
    @DisplayName("Deberia crear una reserva con incremento por ser festivo correctamente")
    void deberiaCrearUnaReservaConIncrementoPorSerFestivo() {

        Reserva reserva = new ReservaTestDataBuilder().build();
        Agenda agenda = new AgendaTestDataBuilder()
                .conFechaInicio(LocalDateTime.of(2022,5,30,7,0))
                .conFechaFin(LocalDateTime.of(2022,5,30,8,0)).conId(60L).build();
        Servicio servicio = new ServicioTestDataBuilder().conId(2L).build();

        RepositorioAgenda repositorioAgenda = Mockito.mock(RepositorioAgenda.class);
        RepositorioCantidad repositorioCantidad = Mockito.mock(RepositorioCantidad.class);
        RepositorioServicio repositorioServicio = Mockito.mock(RepositorioServicio.class);
        RepositorioReserva repositorioReserva = Mockito.mock(RepositorioReserva.class);
        Festivo festivo = Mockito.mock(Festivo.class);

        Mockito.when(repositorioAgenda.existePorId(60L)).thenReturn(agenda);
        Mockito.when(festivo.getFestivos(LocalDate.from(agenda.getFechaInicio()).toString())).thenReturn(true);
        Mockito.when(repositorioServicio.existePorId(2L)).thenReturn(servicio);
        Mockito.when(repositorioReserva.crear(reserva)).thenReturn(2L);

        ServicioCrearReserva servicioCrearReserva = new ServicioCrearReserva(repositorioReserva,repositorioAgenda,repositorioCantidad,repositorioServicio,festivo);
        Long idReserva = servicioCrearReserva.ejecutar(reserva);
        assertEquals(2L,idReserva);

    }

    @Test
    @DisplayName("Deberia crear una reserva con valor gratis correctamente")
    void deberiaCrearUnaReservaConValorTotalCero() {

        Reserva reserva = new ReservaTestDataBuilder().build();
        Agenda agenda = new AgendaTestDataBuilder()
                .conFechaInicio(LocalDateTime.of(2022,5,30,7,0))
                .conFechaFin(LocalDateTime.of(2022,5,30,8,0)).conId(60L).build();
        Servicio servicio = new ServicioTestDataBuilder().conId(2L).build();
        Cantidad cantidad = new CantidadTestDataBuilder().conCantidad(7).conPlaca("ZXC123").build();

        RepositorioAgenda repositorioAgenda = Mockito.mock(RepositorioAgenda.class);
        RepositorioCantidad repositorioCantidad = Mockito.mock(RepositorioCantidad.class);
        RepositorioServicio repositorioServicio = Mockito.mock(RepositorioServicio.class);
        RepositorioReserva repositorioReserva = Mockito.mock(RepositorioReserva.class);
        Festivo festivo = Mockito.mock(Festivo.class);

        Mockito.when(repositorioAgenda.existePorId(60L)).thenReturn(agenda);
        Mockito.when(festivo.getFestivos(LocalDate.from(agenda.getFechaInicio()).toString())).thenReturn(true);
        Mockito.when(repositorioServicio.existePorId(2L)).thenReturn(servicio);
        Mockito.when(repositorioReserva.crear(reserva)).thenReturn(2L);
        Mockito.when(repositorioCantidad.existePorId("ZXC123")).thenReturn(cantidad);

        ServicioCrearReserva servicioCrearReserva = new ServicioCrearReserva(repositorioReserva,repositorioAgenda,repositorioCantidad,repositorioServicio,festivo);
        Long idReserva = servicioCrearReserva.ejecutar(reserva);
        assertEquals(2L,idReserva);

    }
}
