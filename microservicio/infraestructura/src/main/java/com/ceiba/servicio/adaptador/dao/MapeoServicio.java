package com.ceiba.servicio.adaptador.dao;

import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.servicio.modelo.dto.DtoServicio;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MapeoServicio implements RowMapper<DtoServicio>, MapperResult {

    @Override
    public DtoServicio mapRow(ResultSet rs, int rowNum) throws SQLException {
        Long id = rs.getLong("id");
        String nombre = rs.getString("nombre");
        Integer valor = rs.getInt("valor");
        return new DtoServicio(id, nombre, valor);
    }
}