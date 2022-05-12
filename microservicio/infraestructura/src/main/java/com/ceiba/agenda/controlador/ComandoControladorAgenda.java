package com.ceiba.agenda.controlador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.agenda.comando.ComandoAgenda;
import com.ceiba.agenda.comando.manejador.ManejadorCrearAgenda;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/agenda")
@Api(tags = { "Controlador comando agenda"})
public class ComandoControladorAgenda {

    private final ManejadorCrearAgenda manejadorCrearAgenda;

    public ComandoControladorAgenda(ManejadorCrearAgenda manejadorCrearAgenda) {
        this.manejadorCrearAgenda = manejadorCrearAgenda;
    }

    @PostMapping
    @ApiOperation("Crear Agenda")
    public ComandoRespuesta<String> crear(@RequestBody ComandoAgenda comandoAgenda) {
        return manejadorCrearAgenda.ejecutar(comandoAgenda);
    }
}
