package com.ceiba.cantidad.puerto.repositorio;

import com.ceiba.cantidad.modelo.entidad.Cantidad;

public interface RepositorioCantidad {

    void crear(Cantidad cantidad);

    void actualizar(Cantidad cantidad);

    Cantidad existePorId(String placa);

}
