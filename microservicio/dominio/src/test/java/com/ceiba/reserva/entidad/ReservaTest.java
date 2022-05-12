package com.ceiba.reserva.entidad;

import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;
import com.ceiba.reserva.modelo.entidad.Reserva;
import com.ceiba.reserva.servicio.testdatabuilder.ReservaTestDataBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.ceiba.BasePrueba.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReservaTest {
    @Test
    @DisplayName("Deberia crear correctamente la reserva")
    void deberiaCrearCorrectamenteLaReserva() {
        Reserva agenda = new ReservaTestDataBuilder().conId(1L).conTotal(20000).build();

        assertEquals(1, agenda.getId());
        assertEquals("carlos", agenda.getNombre());
        assertEquals("ZXC123", agenda.getPlaca());
        assertEquals(60L, agenda.getIdAgenda());
        assertEquals(2L, agenda.getIdServicio());
        assertEquals(20000, agenda.getTotal());
    }

    @Test
    @DisplayName("Deberia fallar sin el nombre de la reserva")
    void deberiaFallarSinNombreDeReserva() {

        //Arrange
        ReservaTestDataBuilder reservaTestDataBuilder = new ReservaTestDataBuilder().conNombre(null).conId(1L);
        //act-assert
        assertThrows(() -> {
                    reservaTestDataBuilder.build();
                },
                ExcepcionValorObligatorio.class, "Se debe ingresar el nombre");
    }
    @Test
    @DisplayName("Deberia fallar sin la placa de la reserva")
    void deberiaFallarSinPlacaDeReserva() {

        //Arrange
        ReservaTestDataBuilder reservaTestDataBuilder = new ReservaTestDataBuilder().conPlaca(null).conId(1L);
        //act-assert
        assertThrows(() -> {
                    reservaTestDataBuilder.build();
                },
                ExcepcionValorObligatorio.class, "Se debe ingresar la placa");
    }
    @Test
    @DisplayName("Deberia fallar sin el id del servicio de la reserva")
    void deberiaFallarSinIdServicioDeReserva() {

        //Arrange
        ReservaTestDataBuilder reservaTestDataBuilder = new ReservaTestDataBuilder().conIdServicio(null).conId(1L);
        //act-assert
        assertThrows(() -> {
                    reservaTestDataBuilder.build();
                },
                ExcepcionValorObligatorio.class, "Se debe ingresar el servicio");
    }
    @Test
    @DisplayName("Deberia fallar sin el id de la reserva de la reserva")
    void deberiaFallarSinIdAgendaDeReserva() {

        //Arrange
        ReservaTestDataBuilder reservaTestDataBuilder = new ReservaTestDataBuilder().conIdAgenda(null).conId(1L);
        //act-assert
        assertThrows(() -> {
                    reservaTestDataBuilder.build();
                },
                ExcepcionValorObligatorio.class, "Se debe ingresar la agenda");
    }
}
