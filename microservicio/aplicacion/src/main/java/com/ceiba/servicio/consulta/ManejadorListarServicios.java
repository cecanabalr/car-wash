package com.ceiba.servicio.consulta;

import com.ceiba.servicio.modelo.dto.DtoServicio;
import com.ceiba.servicio.puerto.dao.DaoServicio;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorListarServicios {
    private final DaoServicio daoServicio;


    public ManejadorListarServicios(DaoServicio daoServicio) {
        this.daoServicio = daoServicio;
    }

    public List<DtoServicio> ejecutar(){
        return this.daoServicio.listar();
    }
}
