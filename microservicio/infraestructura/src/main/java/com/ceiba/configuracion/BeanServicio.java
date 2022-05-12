package com.ceiba.configuracion;

import com.ceiba.agenda.puerto.repositorio.RepositorioAgenda;
import com.ceiba.agenda.servicio.ServicioCrearAgenda;
import com.ceiba.cantidad.puerto.dao.DaoCantidad;
import com.ceiba.cantidad.puerto.repositorio.RepositorioCantidad;
import com.ceiba.cantidad.servicio.ServicioCrearCantidad;
import com.ceiba.reserva.puerto.repositorio.RepositorioReserva;
import com.ceiba.reserva.puerto.util.Festivo;
import com.ceiba.reserva.servicio.ServicioCrearReserva;
import com.ceiba.servicio.puerto.repositorio.RepositorioServicio;
import com.ceiba.servicio.servicio.ServicioCrearServicio;
import com.ceiba.usuario.puerto.repositorio.*;
import com.ceiba.usuario.servicio.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanServicio {

    @Bean
    public ServicioCrearUsuario servicioCrearUsuario(RepositorioUsuario repositorioUsuario) {
        return new ServicioCrearUsuario(repositorioUsuario);
    }

    @Bean
    public ServicioEliminarUsuario servicioEliminarUsuario(RepositorioUsuario repositorioUsuario) {
        return new ServicioEliminarUsuario(repositorioUsuario);
    }

    @Bean
    public ServicioActualizarUsuario servicioActualizarUsuario(RepositorioUsuario repositorioUsuario) {
        return new ServicioActualizarUsuario(repositorioUsuario);
    }

    @Bean
    public ServicioCrearServicio servicioCrearServicio(RepositorioServicio repositorioServicio) {
        return new ServicioCrearServicio(repositorioServicio);
    }

    @Bean
    public ServicioCrearAgenda servicioCrearAgenda(RepositorioAgenda repositorioAgenda) {
        return new ServicioCrearAgenda(repositorioAgenda);
    }

    @Bean
    public ServicioCrearReserva servicioCrearReserva(RepositorioReserva repositorioReserva,
                                                     RepositorioAgenda repositorioAgenda,
                                                     RepositorioCantidad repositorioCantidad,
                                                     RepositorioServicio repositorioServicio,
                                                     Festivo isFestivo) {
        return new ServicioCrearReserva(repositorioReserva, repositorioAgenda, repositorioCantidad, repositorioServicio, isFestivo);
    }

    @Bean
    public ServicioCrearCantidad servicioCrearCantidad(RepositorioCantidad repositorioCantidad, DaoCantidad daoCantidad) {
        return new ServicioCrearCantidad(repositorioCantidad, daoCantidad);
    }
}
