package com.ceiba.agenda.adaptador.repositorio;

import com.ceiba.agenda.modelo.entidad.Agenda;
import com.ceiba.infraestructura.jdbc.MapperResult;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class MapeoAgenda implements RowMapper<Agenda>, MapperResult {

    @Override
    public Agenda mapRow(ResultSet rs, int rowNum) throws SQLException {
        Long id = rs.getLong("id");
        LocalDateTime fecha_inicio = extraerLocalDateTime(rs, "fecha_inicio");
        LocalDateTime fecha_fin = extraerLocalDateTime(rs, "fecha_fin");
        LocalDateTime fecha_creacion = extraerLocalDateTime(rs, "fecha_creacion");
        Boolean disponibilidad = rs.getBoolean("id");
        return new Agenda(id, fecha_inicio, fecha_fin,fecha_creacion,disponibilidad);
    }

}
