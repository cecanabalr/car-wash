package com.ceiba.servicio.servicio;

import com.ceiba.servicio.modelo.entidad.Servicio;
import com.ceiba.servicio.puerto.repositorio.RepositorioServicio;
import com.ceiba.servicio.servicio.testdatabuilder.ServicioTestDataBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ServicioCrearServicioTest {

    @Test
    @DisplayName("Deberia Crear el servicio de manera correcta")
    void deberiaCrearServicioDeManeraCorrecta() {

        Servicio servicio = new ServicioTestDataBuilder().build();
        RepositorioServicio repositorioServicio = Mockito.mock(RepositorioServicio.class);
        Mockito.when(repositorioServicio.crear(servicio)).thenReturn(10L);
        ServicioCrearServicio servicioCrearServicio = new ServicioCrearServicio(repositorioServicio);

        Long idServicio = servicioCrearServicio.ejecutar(servicio);

        assertEquals(10L, idServicio);
        Mockito.verify(repositorioServicio, Mockito.times(1)).crear(servicio);

    }


}
