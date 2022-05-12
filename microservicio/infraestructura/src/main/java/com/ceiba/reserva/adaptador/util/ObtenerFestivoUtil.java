package com.ceiba.reserva.adaptador.util;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;


@Component
@ConfigurationProperties(prefix = "festivo")
public class ObtenerFestivoUtil {
    private ArrayList<String> dias;

    public ArrayList<String> getDias() {
        return dias;
    }

    public void setDias(ArrayList<String> dias) {
        this.dias = dias;
    }

    public ObtenerFestivoUtil(ArrayList<String> dias) {
        this.dias = dias;
    }

    public ObtenerFestivoUtil() {
    }
}
