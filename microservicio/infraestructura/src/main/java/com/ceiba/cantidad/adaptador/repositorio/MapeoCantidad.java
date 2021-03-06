package com.ceiba.cantidad.adaptador.repositorio;

import com.ceiba.cantidad.modelo.entidad.Cantidad;
import com.ceiba.infraestructura.jdbc.MapperResult;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class MapeoCantidad implements RowMapper<Cantidad>, MapperResult {

    @Override
    public Cantidad mapRow(ResultSet rs, int rowNum) throws SQLException {
        Long id = rs.getLong("id");
        String placa = rs.getString("placa");
        int cantidad = rs.getInt("contador");
        LocalDateTime fechaActualizacion = extraerLocalDateTime(rs, "fecha_actualizacion");
        return new Cantidad(id, placa, cantidad,fechaActualizacion);
    }
}
