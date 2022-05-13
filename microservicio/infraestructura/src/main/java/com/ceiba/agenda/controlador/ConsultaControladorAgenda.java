package com.ceiba.agenda.controlador;

import com.ceiba.agenda.consulta.ManejadorListarAgendas;
import com.ceiba.agenda.modelo.dto.DtoAgenda;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/agendas")
@Api(tags={"Controlador consulta agenda"})
public class ConsultaControladorAgenda  {

    private final ManejadorListarAgendas manejadorListarAgendas;


    public ConsultaControladorAgenda(ManejadorListarAgendas manejadorListarAgendas) {
        this.manejadorListarAgendas = manejadorListarAgendas;
    }

    @GetMapping
    @ApiOperation("Listar Agendas")
    public List<DtoAgenda> listar() {
        return this.manejadorListarAgendas.ejecutar();
    }

    @GetMapping(value="/{fechaInicial}")
    @ApiOperation("Listar Agendas Por Fecha Inicial")
    public List<DtoAgenda> listarPorFechaInicial(@PathVariable String fechaInicial) {
        return this.manejadorListarAgendas.ejecutar(LocalDate.parse(fechaInicial));
    }
}
