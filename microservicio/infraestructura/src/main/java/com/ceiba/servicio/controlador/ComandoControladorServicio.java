package com.ceiba.servicio.controlador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.servicio.comando.ComandoServicio;
import com.ceiba.servicio.comando.manejador.ManejadorCrearServicio;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/servicio")
@Api(tags = { "Controlador comando servicio"})
public class ComandoControladorServicio {

    private final ManejadorCrearServicio manejadorCrearServicio;

    public ComandoControladorServicio(ManejadorCrearServicio manejadorCrearServicio) {
        this.manejadorCrearServicio = manejadorCrearServicio;
    }

    @PostMapping
    @ApiOperation("Crear Servicio")
    public ComandoRespuesta<Long> crear(@RequestBody ComandoServicio comandoServicio) {
        return manejadorCrearServicio.ejecutar(comandoServicio);
    }
}
