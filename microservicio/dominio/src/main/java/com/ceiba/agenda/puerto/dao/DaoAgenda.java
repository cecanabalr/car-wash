package com.ceiba.agenda.puerto.dao;

import com.ceiba.agenda.modelo.dto.DtoAgenda;

import java.time.LocalDate;
import java.util.List;

public interface DaoAgenda {

    List<DtoAgenda> listar();

    List<DtoAgenda> listarPorFechaInicio(LocalDate fechaInicial);
}
