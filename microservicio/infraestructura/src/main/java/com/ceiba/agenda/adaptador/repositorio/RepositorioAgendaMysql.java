package com.ceiba.agenda.adaptador.repositorio;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.agenda.modelo.entidad.Agenda;
import com.ceiba.agenda.puerto.repositorio.RepositorioAgenda;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioAgendaMysql implements RepositorioAgenda {

    private static final Logger LOGGER_ERROR = LoggerFactory.getLogger(RepositorioAgendaMysql.class);
    private static final String MENSAJE_ERROR = "Error existePorId: {} ";

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="agenda", value="crear")
    private static String sqlCrear;

    @SqlStatement(namespace="agenda", value="actualizar")
    private static String sqlActualizar;

    @SqlStatement(namespace="agenda", value="existePorId")
    private static String sqlExistePorId;

    public RepositorioAgendaMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public Long crear(Agenda agenda) {
        return this.customNamedParameterJdbcTemplate.crear(agenda, sqlCrear);
    }

    @Override
    public void actualizar(Agenda agenda) {
        this.customNamedParameterJdbcTemplate.actualizar(agenda, sqlActualizar);
    }

    @Override
    public Agenda existePorId(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);
        Agenda agenda = null;
         try{
             agenda = this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExistePorId,paramSource, new MapeoAgenda());
         }catch (EmptyResultDataAccessException e){
             LOGGER_ERROR.error(MENSAJE_ERROR, e.getMessage());
         }

        return  agenda;
    }
}
