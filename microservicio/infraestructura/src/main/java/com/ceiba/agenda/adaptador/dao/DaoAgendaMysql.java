package com.ceiba.agenda.adaptador.dao;

import com.ceiba.agenda.modelo.dto.DtoAgenda;
import com.ceiba.agenda.puerto.dao.DaoAgenda;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Component
public class DaoAgendaMysql implements DaoAgenda {
    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="agenda", value="listar")
    private static  String sqlListar;

    @SqlStatement(namespace="agenda", value="listarPorFecha")
    private static  String sqlListarPorFechaInicio;

    public DaoAgendaMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public List<DtoAgenda> listar() {
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListar, new MapeoAgenda());
    }

    @Override
    public List<DtoAgenda> listarPorFechaInicio(LocalDate fechaInicial) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("fechaInicio", fechaInicial);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListarPorFechaInicio,paramSource, new MapeoAgenda());

    }
}
