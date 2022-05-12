package com.ceiba.servicio.adaptador.repositorio;


import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.servicio.modelo.entidad.Servicio;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class MapeoServicio implements RowMapper<Servicio>, MapperResult {

    @Override
    public Servicio mapRow(ResultSet rs, int rowNum) throws SQLException {
        Long id = rs.getLong("id");
        String nombre = rs.getString("nombre");
        int valor = rs.getInt("valor");
        return new Servicio(id, nombre, valor);
    }
}