package com.ceiba.agenda.adaptador.dao;

import com.ceiba.agenda.modelo.dto.DtoAgenda;
import com.ceiba.infraestructura.jdbc.MapperResult;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class MapeoAgenda implements RowMapper<DtoAgenda>, MapperResult {

    @Override
    public DtoAgenda mapRow(ResultSet rs, int rowNum) throws SQLException {
        Long id = rs.getLong("id");
        LocalDateTime fecha_inicio = extraerLocalDateTime(rs, "fecha_inicio");
        LocalDateTime fecha_fin = extraerLocalDateTime(rs, "fecha_fin");
        LocalDateTime fecha_creacion = extraerLocalDateTime(rs, "fecha_creacion");
        Boolean disponibilidad = rs.getBoolean("disponibilidad");
        return new DtoAgenda(id, fecha_inicio, fecha_fin,fecha_creacion,disponibilidad);
    }

}
