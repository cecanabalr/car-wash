package com.ceiba.cantidad.modelo.entidad;

import com.ceiba.reserva.modelo.entidad.Reserva;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;

@Getter
@Setter
public class Cantidad {


    private static final int NUMERO_LAVADAS_MAXIMO = 7;
    private static final String SE_DEBE_INGRESAR_LA_PLACA = "Se debe ingresar la placa";
    private static final String SE_DEBE_INGRESAR_LA_CANTIDAD = "Se debe ingresar la cantidad";

    private Long id;
    private String placa;
    private int contador;
    private LocalDateTime fechaActualizacion;

    public Cantidad(Long id, String placa, int contador, LocalDateTime fechaActualizacion) {
        validarObligatorio(placa, SE_DEBE_INGRESAR_LA_PLACA);
        validarObligatorio(contador, SE_DEBE_INGRESAR_LA_CANTIDAD);
        this.id = id;
        this.placa = placa;
        this.contador = contador;
        this.fechaActualizacion = fechaActualizacion;
    }

    private static Cantidad crear(String placa, int contador){
        return new Cantidad(0L,placa,contador,LocalDateTime.now());
    }

    public static boolean tieneMaximoLavadas(int contador) {
        return  contador >= NUMERO_LAVADAS_MAXIMO;
    }

    public static Cantidad actualizarCantidad(Reserva reserva){
        if(reserva.getCantidad() == null){
            return crear(reserva.getPlaca(), 1);
        }
        int contador = 0;
        if(reserva.getCantidad().getContador()<NUMERO_LAVADAS_MAXIMO){
            contador = reserva.getCantidad().getContador() + 1;
        }
        return new Cantidad(reserva.getCantidad().getId(), reserva.getPlaca(),contador, LocalDateTime.now() );
    }
}
