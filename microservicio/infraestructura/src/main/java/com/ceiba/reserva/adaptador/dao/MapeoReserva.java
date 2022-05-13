package com.ceiba.reserva.adaptador.dao;

import com.ceiba.agenda.modelo.dto.DtoAgenda;
import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.reserva.modelo.dto.DtoReserva;
import com.ceiba.servicio.modelo.dto.DtoServicio;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class MapeoReserva implements RowMapper<DtoReserva>, MapperResult {

    @Override
    public DtoReserva mapRow(ResultSet rs, int rowNum) throws SQLException {
        Long id = rs.getLong("id");
        String nombre = rs.getString("nombre");
        String placa = rs.getString("placa");
        LocalDateTime fechaCreacion = extraerLocalDateTime(rs, "fecha_creacion");
        int total = rs.getInt("total");


        Long idAgenda = rs.getLong("id_agenda");
        LocalDateTime fechaInicio = extraerLocalDateTime(rs, "agenda.fecha_inicio");
        LocalDateTime fechaFin = extraerLocalDateTime(rs, "agenda.fecha_fin");
        Boolean disponibilidad = rs.getBoolean("agenda.disponibilidad");

        Long idServicio = rs.getLong("id_servicio");
        String nombreServicio = rs.getString("servicio.nombre");
        Integer valor = rs.getInt("servicio.valor");

        DtoAgenda agenda = new DtoAgenda(idAgenda,fechaInicio,fechaFin,null,disponibilidad);

        DtoServicio servicio = new DtoServicio(idServicio,nombreServicio,valor);

        return new DtoReserva(id,nombre,placa,fechaCreacion,agenda,servicio,total);
    }
}