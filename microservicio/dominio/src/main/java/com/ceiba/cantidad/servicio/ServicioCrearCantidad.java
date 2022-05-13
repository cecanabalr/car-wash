package com.ceiba.cantidad.servicio;

import com.ceiba.cantidad.modelo.entidad.Cantidad;
import com.ceiba.cantidad.puerto.dao.DaoCantidad;
import com.ceiba.cantidad.puerto.repositorio.RepositorioCantidad;

public class ServicioCrearCantidad {

    public static final int NUMERO_LAVADAS_MAXIMO = 7;
    public static final int REINICIAR_NUMERO_LAVADAS = 0;
    private final RepositorioCantidad repositorioCantidad;

    private final DaoCantidad daoCantidad;

    public ServicioCrearCantidad(RepositorioCantidad repositorioCantidad, DaoCantidad daoCantidad) {
        this.repositorioCantidad = repositorioCantidad;
        this.daoCantidad = daoCantidad;
    }


    public void ejecutar(Cantidad cantidad){
        Cantidad existeCantidad = this.daoCantidad.existe(cantidad.getPlaca());
        if(existeCantidad != null){
            if(existeCantidad.getContador() >= NUMERO_LAVADAS_MAXIMO){
                existeCantidad.setContador(REINICIAR_NUMERO_LAVADAS);
            }else {
                existeCantidad.setContador(existeCantidad.getContador()+1);
            }
            this.repositorioCantidad.actualizar(existeCantidad);
        }else {
            this.repositorioCantidad.crear(cantidad);
        }
    }
}
