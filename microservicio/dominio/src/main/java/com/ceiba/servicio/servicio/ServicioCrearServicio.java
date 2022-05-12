package com.ceiba.servicio.servicio;

import com.ceiba.servicio.modelo.entidad.Servicio;
import com.ceiba.servicio.puerto.repositorio.RepositorioServicio;

public class ServicioCrearServicio {

    private final RepositorioServicio repositorioServicio;

    public ServicioCrearServicio(RepositorioServicio repositorioServicio) {
        this.repositorioServicio = repositorioServicio;
    }

    public Long ejecutar(Servicio servicio){
        return this.repositorioServicio.crear(servicio);
    }
}
