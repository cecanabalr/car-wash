package com.ceiba.reserva.adaptador.util;

import com.ceiba.reserva.puerto.util.Festivo;
import org.springframework.stereotype.Component;


@Component
public class festivoUtil implements Festivo {

    private final ObtenerFestivoUtil obtenerFestivoUtil;

    public festivoUtil(ObtenerFestivoUtil obtenerFestivoUtil) {
        this.obtenerFestivoUtil = obtenerFestivoUtil;
    }

    @Override
    public boolean getFestivos(String fecha) {
        return obtenerFestivoUtil.getDias().contains(fecha);
    }
}
