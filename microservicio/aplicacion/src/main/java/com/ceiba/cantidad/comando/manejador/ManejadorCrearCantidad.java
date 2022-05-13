package com.ceiba.cantidad.comando.manejador;

import com.ceiba.cantidad.comando.fabrica.FabricaCantidad;
import com.ceiba.cantidad.modelo.entidad.Cantidad;
import com.ceiba.cantidad.servicio.ServicioCrearCantidad;
import org.springframework.stereotype.Component;

@Component
public class ManejadorCrearCantidad {


    private final FabricaCantidad fabricaCantidad;
    private final ServicioCrearCantidad servicioCrearCantidad;

    public ManejadorCrearCantidad(FabricaCantidad fabricaCantidad, ServicioCrearCantidad servicioCrearCantidad) {
        this.fabricaCantidad = fabricaCantidad;
        this.servicioCrearCantidad = servicioCrearCantidad;
    }

    public void ejecutar(String placa){
        Cantidad cantidad = this.fabricaCantidad.crear(placa);
        this.servicioCrearCantidad.ejecutar(cantidad);
    }
}
