package com.ceiba.servicio.puerto.repositorio;

import com.ceiba.servicio.modelo.entidad.Servicio;

public interface RepositorioServicio {

    Long crear(Servicio servicio);

    Servicio existePorId(Long id);
}
