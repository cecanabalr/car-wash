package com.ceiba.servicio.puerto.dao;

import com.ceiba.servicio.modelo.dto.DtoServicio;

import java.util.List;

public interface DaoServicio {

    /**
     * Permite listar servicios
     * @return los servicios
     */
    List<DtoServicio> listar();
}
