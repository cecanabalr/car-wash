package com.ceiba.servicio.modelo.entidad;

import com.ceiba.dominio.excepcion.ExcepcionRegistroNoDisponible;
import lombok.Getter;

import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;

@Getter
public class Servicio {

    private static final double INCREMENTO_DIA_FESTIVO = 0.1;
    public static final double DESCUENTO_LUNES = 0.05;
    private static final String SE_DEBE_INGRESAR_EL_VALOR_DEL_SERVICIO = "Se debe ingresar el valor del servicio";
    private static final String SE_DEBE_INGRESAR_EL_NOMBRE_DEL_SERVICIO = "Se debe ingresar el nombre del servicio";

    private Long id;
    private String nombre;
    private Integer valor;

    public Servicio(Long id, String nombre, Integer valor) {
        validarObligatorio(nombre, SE_DEBE_INGRESAR_EL_NOMBRE_DEL_SERVICIO);
        validarObligatorio(valor, SE_DEBE_INGRESAR_EL_VALOR_DEL_SERVICIO);
        this.id = id;
        this.nombre = nombre;
        this.valor = valor;
    }
    public int calcularIncrementoDiaFestivo( int valor){
       int porcentaje = (int) (valor* INCREMENTO_DIA_FESTIVO);
       return porcentaje + valor;
    }
    public int  calcularDescuentoLunes(int valor) {
        int porcentaje = (int) (DESCUENTO_LUNES * valor);
        return  valor - porcentaje;
    }
}
