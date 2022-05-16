package com.ceiba.cantidad.adaptador.repositorio;


import com.ceiba.cantidad.adaptador.dao.MapeoCantidad;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.cantidad.modelo.entidad.Cantidad;
import com.ceiba.cantidad.puerto.repositorio.RepositorioCantidad;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class RepositoryCantidadMysql implements RepositorioCantidad {

    private static final Logger LOG = LoggerFactory.getLogger(RepositoryCantidadMysql.class);
    private static final String MENSAJE_ERROR = "Error existePorId: {} ";

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="cantidad", value="crear")
    private static String sqlCrear;

    @SqlStatement(namespace="cantidad", value="actualizar")
    private static String sqlActualizar;

    @SqlStatement(namespace="cantidad", value="existePorId")
    private static String sqlExistePorId;

    public RepositoryCantidadMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    public void crear(Cantidad cantidad){
        this.customNamedParameterJdbcTemplate.crear(cantidad, sqlCrear);
    }

    @Override
    public void actualizar(Cantidad cantidad) {
        this.customNamedParameterJdbcTemplate.actualizar(cantidad, sqlActualizar);
    }

    @Override
    public Cantidad existePorId(String placa) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("placa", placa);
        Cantidad cantidad = null;
        try {
            cantidad = this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExistePorId,paramSource, new MapeoCantidad());
        }catch (EmptyResultDataAccessException e){
            LOG.error(MENSAJE_ERROR, e.getMessage());
        }
        return cantidad;
    }


}
