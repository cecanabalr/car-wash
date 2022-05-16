package com.ceiba.cantidad.adaptador.dao;

import com.ceiba.cantidad.modelo.entidad.Cantidad;
import com.ceiba.cantidad.puerto.dao.DaoCantidad;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Component;

@Component
public class DaoCantidadMysql implements DaoCantidad {

    private static final Logger LOGGER_ERROR = LoggerFactory.getLogger(DaoCantidadMysql.class);
    private static final String MENSAJE_ERROR = "Error existePorId: {} ";


    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="cantidad", value="existe")
    private static String sqlExiste;

    public DaoCantidadMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public Cantidad existe(String placa) {
        Cantidad cantidad = null;
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("placa", placa);
        try {
            cantidad = this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExiste,paramSource, new MapeoCantidad() );
        }catch (EmptyResultDataAccessException e){
            LOGGER_ERROR.error(MENSAJE_ERROR, e.getMessage());
        }
        return cantidad;
    }
}
