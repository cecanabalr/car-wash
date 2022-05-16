package com.ceiba.servicio.adaptador.repositorio;


import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.servicio.modelo.entidad.Servicio;
import com.ceiba.servicio.puerto.repositorio.RepositorioServicio;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;



@Repository
public class RepositorioServiceMysql implements RepositorioServicio {

    private static final Logger LOGGER_ERROR = LoggerFactory.getLogger(RepositorioServiceMysql.class);
    private static final String MENSAJE_ERROR = "Error existePorId: {} ";

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="servicio", value="crear")
    private static String sqlCrear;

    @SqlStatement(namespace="servicio", value="existePorId")
    private static String sqlExistePorId;

    public RepositorioServiceMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public Long crear(Servicio servicio) {
        return this.customNamedParameterJdbcTemplate.crear(servicio, sqlCrear);
    }

    @Override
    public Servicio existePorId(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);
        Servicio servicio = null;
        try {
            servicio = this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExistePorId,paramSource, new MapeoServicio());
        }catch (EmptyResultDataAccessException e){
            LOGGER_ERROR.error(MENSAJE_ERROR, e.getMessage());
        }
        return  servicio;
    }
}
