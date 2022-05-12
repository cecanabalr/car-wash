package com.ceiba.cantidad.adaptador.repositorio;


import com.ceiba.cantidad.adaptador.dao.MapeoCantidad;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.cantidad.modelo.entidad.Cantidad;
import com.ceiba.cantidad.puerto.repositorio.RepositorioCantidad;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class RepositoryCantidadMysql implements RepositorioCantidad {

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

        try {
            return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExistePorId,paramSource, new MapeoCantidad());
        }catch (EmptyResultDataAccessException e){
            return null;
        }
    }


}
