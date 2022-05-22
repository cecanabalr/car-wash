package com.ceiba.reserva.consulta;

import com.ceiba.reserva.modelo.dto.DtoReserva;
import com.ceiba.reserva.puerto.dao.DaoReserva;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorListarReserva {

    private final DaoReserva daoReserva;

    public ManejadorListarReserva(DaoReserva daoReserva) {
        this.daoReserva = daoReserva;
    }

    public List<DtoReserva> ejecutar(String placa){
        return this.daoReserva.listarPorPlaca(placa);
    }

    public List<DtoReserva> ejecutar(){
        return this.daoReserva.listar();
    }
}
