package com.ceiba.servicio.entidad;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;
import com.ceiba.servicio.modelo.entidad.Servicio;
import com.ceiba.servicio.servicio.testdatabuilder.ServicioTestDataBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ServicioTest {

    @Test
    @DisplayName("Deberia crear correctamente el servicio")
    void deberiaCrearCorrectamenteElServicio(){
        Servicio servicio = new ServicioTestDataBuilder().conId(1L).build();

        assertEquals(1, servicio.getId());
        assertEquals("lavado", servicio.getNombre());
        assertEquals(30000, servicio.getValor());
    }

    @Test
    @DisplayName("Deberia fallar sin el nombre del servicio")
    void deberiaFallarSinNombreDeServicio() {

        //Arrange
        ServicioTestDataBuilder servicioTestDataBuilder = new ServicioTestDataBuilder().conNombre(null).conId(1L);
        //act-assert
        BasePrueba.assertThrows(() -> {
                    servicioTestDataBuilder.build();
                },
                ExcepcionValorObligatorio.class, "Se debe ingresar el nombre del servicio");
    }

    @Test
    @DisplayName("Deberia fallar sin el valor del servicio")
    void deberiaFallarSinValorDeServicio() {

        //Arrange
        ServicioTestDataBuilder servicioTestDataBuilder = new ServicioTestDataBuilder().conValor(null).conId(1L);
        //act-assert
        BasePrueba.assertThrows(() -> {
                    servicioTestDataBuilder.build();
                },
                ExcepcionValorObligatorio.class, "Se debe ingresar el valor del servicio");
    }
}
