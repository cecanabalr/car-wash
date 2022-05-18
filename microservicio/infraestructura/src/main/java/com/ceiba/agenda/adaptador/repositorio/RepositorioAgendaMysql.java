package com.ceiba.agenda.adaptador.repositorio;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.EjecucionBaseDeDatos;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.agenda.modelo.entidad.Agenda;
import com.ceiba.agenda.puerto.repositorio.RepositorioAgenda;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioAgendaMysql implements RepositorioAgenda {
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
    public void crear(Agenda agenda) {
         this.customNamedParameterJdbcTemplate.crear(agenda, sqlCrear);
    }

    @Override
    public void actualizar(Agenda agenda) {
        this.customNamedParameterJdbcTemplate.actualizar(agenda, sqlActualizar);
    }

    @Override
    public Agenda existePorId(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);

        return EjecucionBaseDeDatos.obtenerUnObjetoONull(()->
                this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExistePorId,paramSource, new MapeoAgenda()));
    }
}
