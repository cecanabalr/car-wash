package com.ceiba.reserva.adaptador.util;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
@ConfigurationProperties(prefix = "festivo")
public class ObtenerFestivoUtil {

    private List<String> dias;

    public List<String> getDias() {
        return new ArrayList<>(dias);
    }

    public void setDias(List<String> dias) {
        this.dias = new ArrayList<>(dias);
    }
}
