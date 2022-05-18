package com.ceiba.reserva.modelo.entidad;

import java.util.Arrays;
import java.util.List;

public class DiasFestivos {

    private DiasFestivos(){}

    public static List<String> getDias() {
        return Arrays.asList(
                "2022-05-01",
                "2022-05-30",
                "2022-06-20",
                "2022-06-27",
                "2022-07-04",
                "2022-07-20",
                "2022-08-07",
                "2022-08-15",
                "2022-10-17",
                "2022-11-07",
                "2022-11-14",
                "2022-12-08",
                "2022-12-25"
        );
    }
}
