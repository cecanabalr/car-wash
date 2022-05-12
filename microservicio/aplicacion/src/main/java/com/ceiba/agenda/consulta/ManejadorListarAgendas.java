package com.ceiba.agenda.consulta;

import com.ceiba.agenda.modelo.dto.DtoAgenda;
import com.ceiba.agenda.puerto.dao.DaoAgenda;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Component
public class ManejadorListarAgendas {

    private final DaoAgenda daoAgenda;

    public ManejadorListarAgendas(DaoAgenda daoAgenda) {
        this.daoAgenda = daoAgenda;
    }

    public List<DtoAgenda> ejecutar(){
        return this.daoAgenda.listar();
    }

    public List<DtoAgenda> ejecutar(LocalDate fechaInicial){
        return this.daoAgenda.listarPorFechaInicio(fechaInicial);
    }
}
