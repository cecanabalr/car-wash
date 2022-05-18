package com.ceiba.reserva.adaptador.repositorio;

import com.ceiba.agenda.puerto.repositorio.RepositorioAgenda;
import com.ceiba.cantidad.puerto.repositorio.RepositorioCantidad;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.reserva.modelo.entidad.Reserva;
import com.ceiba.reserva.puerto.repositorio.RepositorioReserva;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioReservaMysql implements RepositorioReserva {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    private final RepositorioCantidad repositorioCantidad;
    private final RepositorioAgenda repositorioAgenda;

    @SqlStatement(namespace="reserva", value="crear")
    private static String sqlCrear;

    public RepositorioReservaMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate, RepositorioCantidad repositorioCantidad, RepositorioAgenda repositorioAgenda) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
        this.repositorioCantidad = repositorioCantidad;
        this.repositorioAgenda = repositorioAgenda;
    }

    public Long crear(Reserva reserva){
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("nombre", reserva.getNombre());
        paramSource.addValue("placa", reserva.getPlaca());
        paramSource.addValue("fecha_creacion", reserva.getFechaCreacion());
        paramSource.addValue("id_agenda", reserva.getAgenda().getId());
        paramSource.addValue("id_servicio", reserva.getServicio().getId());
        paramSource.addValue("total", reserva.getTotal());
        if(reserva.getCantidad().getId() ==0L){
            repositorioCantidad.crear(reserva.getCantidad());
        }else{
            repositorioCantidad.actualizar(reserva.getCantidad());
        }
        repositorioAgenda.actualizar(reserva.getAgenda());
        return this.customNamedParameterJdbcTemplate.crear(paramSource,sqlCrear);
    }
}
