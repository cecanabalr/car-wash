package com.ceiba.agenda.entidad;


import com.ceiba.agenda.modelo.entidad.Agenda;
import com.ceiba.agenda.servicio.testdatabuilder.AgendaTestDataBuilder;
import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;

import static com.ceiba.BasePrueba.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AgendaTest {

    @Test
    @DisplayName("Deberia crear correctamente la Agenda")
    void deberiaCrearCorrectamenteLaAgenda(){
        Agenda agenda = new AgendaTestDataBuilder().conId(1L).build();

        assertEquals(1, agenda.getId());
        assertEquals( LocalDateTime.of(2022,5,13,7,0), agenda.getFechaInicio());
        assertEquals( LocalDateTime.of(2022,5,13,8,0), agenda.getFechaFin());
        assertEquals( LocalDateTime.of(2022,5,13,6,0), agenda.getFechaCreacion());
        assertEquals(true, agenda.getDisponibilidad());
    }

    @Test
    @DisplayName("Deberia fallar sin fecha inicio de agenda")
    void deberiaFallarSinFechaInicioDeAgenda() {

        //Arrange
        AgendaTestDataBuilder agendaTestDataBuilder = new AgendaTestDataBuilder().conFechaInicio(null).conId(1L);
        //act-assert
        assertThrows(() -> {
                    agendaTestDataBuilder.build();
                },
                ExcepcionValorObligatorio.class, "Se debe ingresar la fecha inicial");
    }

    @Test
    @DisplayName("Deberia fallar sin fecha fin de agenda")
    void deberiaFallarSinFechaFinDeAgenda() {

        //Arrange
        AgendaTestDataBuilder agendaTestDataBuilder = new AgendaTestDataBuilder().conFechaFin(null).conId(1L);
        //act-assert
        assertThrows(() -> {
                    agendaTestDataBuilder.build();
                },
                ExcepcionValorObligatorio.class, "Se debe ingresar la fecha final");
    }
}

