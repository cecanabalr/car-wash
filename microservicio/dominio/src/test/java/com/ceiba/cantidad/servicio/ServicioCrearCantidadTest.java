package com.ceiba.cantidad.servicio;

import com.ceiba.cantidad.modelo.entidad.Cantidad;
import com.ceiba.cantidad.puerto.dao.DaoCantidad;
import com.ceiba.cantidad.puerto.repositorio.RepositorioCantidad;
import com.ceiba.cantidad.servicio.testdatabuilder.CantidadTestDataBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;


public class ServicioCrearCantidadTest {

    @Test
    @DisplayName("Deberia Crear la cantidad de manera correcta")
    void deberiaCrearElCantidadDeManeraCorrecta() {

        Cantidad cantidad = new CantidadTestDataBuilder().build();
        RepositorioCantidad repositorioCantidad = Mockito.mock(RepositorioCantidad.class);
        DaoCantidad daoCantidad = Mockito.mock(DaoCantidad.class);

        ServicioCrearCantidad servicioCrearCantidad = new ServicioCrearCantidad(repositorioCantidad, daoCantidad);

        servicioCrearCantidad.ejecutar(cantidad);

        Mockito.verify(repositorioCantidad, Mockito.times(1)).crear(cantidad);
        Mockito.verify(repositorioCantidad, Mockito.times(0)).actualizar(cantidad);

    }

    @Test
    @DisplayName("Deberia Actualizar la cantidad de manera correcta")
    void deberiaActualizarElCantidadDeManeraCorrecta() {

        Cantidad cantidad = new CantidadTestDataBuilder().conCantidad(7).build();
        RepositorioCantidad repositorioCantidad = Mockito.mock(RepositorioCantidad.class);
        DaoCantidad daoCantidad = Mockito.mock(DaoCantidad.class);
        Mockito.when(daoCantidad.existe("ZXC123")).thenReturn(cantidad);
        ServicioCrearCantidad servicioCrearCantidad = new ServicioCrearCantidad(repositorioCantidad, daoCantidad);

        servicioCrearCantidad.ejecutar(cantidad);

        Mockito.verify(repositorioCantidad, Mockito.times(1)).actualizar(cantidad);

    }
}
