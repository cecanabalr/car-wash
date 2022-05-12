package com.ceiba.cantidad.entidad;

import com.ceiba.BasePrueba;
import com.ceiba.cantidad.modelo.entidad.Cantidad;
import com.ceiba.cantidad.servicio.testdatabuilder.CantidadTestDataBuilder;
import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CantidadTest {

    @Test
    @DisplayName("Deberia crear correctamente la cantidad")
    void deberiaCrearCorrectamenteLaCantidad(){
        Cantidad cantidad = new CantidadTestDataBuilder().conId(1L).build();

        assertEquals(1, cantidad.getId());
        assertEquals("ZXC123", cantidad.getPlaca());
        assertEquals(1, cantidad.getCantidad());
        assertEquals(LocalDateTime.of(2022,5,13,1,0), cantidad.getFechaActualizacion());
    }

    @Test
    @DisplayName("Deberia fallar sin la placa")
    void deberiaFallarSinPlacaDeCantidad() {

        //Arrange
        CantidadTestDataBuilder cantidadTestDataBuilder = new CantidadTestDataBuilder().conPlaca(null).conId(1L);
        //act-assert
        BasePrueba.assertThrows(() -> {
                    cantidadTestDataBuilder.build();
                },
                ExcepcionValorObligatorio.class, "Se debe ingresar la placa");
    }

}
