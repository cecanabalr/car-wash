package com.ceiba.reserva.servicio;

import com.ceiba.agenda.modelo.entidad.Agenda;
import com.ceiba.agenda.puerto.repositorio.RepositorioAgenda;
import com.ceiba.cantidad.modelo.entidad.Cantidad;
import com.ceiba.cantidad.puerto.repositorio.RepositorioCantidad;
import com.ceiba.dominio.excepcion.ExcepcionRegistroNoDisponible;
import com.ceiba.reserva.modelo.entidad.Reserva;
import com.ceiba.reserva.puerto.repositorio.RepositorioReserva;
import com.ceiba.reserva.puerto.util.Festivo;
import com.ceiba.servicio.modelo.entidad.Servicio;
import com.ceiba.servicio.puerto.repositorio.RepositorioServicio;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class ServicioCrearReserva {

    public static final String AGENDA_SELECCIONADA_NO_ESTA_DISPONIBLE = "La agenda seleccionada no esta disponible";
    public static final String SERVICIO_SELECCIONADO_NO_EXISTE = "El servicio seleccionado no existe";
    public static final int LAVADA_GRATIS = 0;
    public static final double INCREMENTO_DIA_FESTIVO = 0.1;
    public static final double DESCUENTO_LUNES = 0.05;
    public static final int NUMERO_LAVADAS_MAXIMO = 7;
    private final RepositorioReserva repositorioReserva;
    private final RepositorioAgenda repositorioAgenda;
    private final RepositorioCantidad repositorioCantidad;
    private final RepositorioServicio repositorioServicio;
    private final Festivo isFestivo;

    public ServicioCrearReserva(RepositorioReserva repositorioReserva,
                                RepositorioAgenda repositorioAgenda,
                                RepositorioCantidad repositorioCantidad,
                                RepositorioServicio repositorioServicio,
                                Festivo isFestivo) {
        this.repositorioReserva = repositorioReserva;
        this.repositorioAgenda = repositorioAgenda;
        this.repositorioCantidad = repositorioCantidad;
        this.repositorioServicio = repositorioServicio;
        this.isFestivo = isFestivo;
    }

    public Long ejecutar(Reserva reserva){
        Cantidad cantidad = this.repositorioCantidad.existePorId(reserva.getPlaca());
        Agenda agenda = this.repositorioAgenda.existePorId(reserva.getIdAgenda());
        Servicio servicio = this.repositorioServicio.existePorId(reserva.getIdServicio());

        if(actualizarDisponibilidad(agenda)){

            if(validarCantidadLavadas(cantidad)){
                reserva.setTotal(LAVADA_GRATIS);
            } else if (validarDiaFestivo(agenda.getFecha_inicio())) {
                reserva.setTotal(calcularIncrementoDiaFestivo(servicio));
            } else if (validarSiEsLunes(agenda)){
                reserva.setTotal(calcularDescuentoLunes(servicio));
            }

        }else {
            throw  new ExcepcionRegistroNoDisponible(AGENDA_SELECCIONADA_NO_ESTA_DISPONIBLE);
        }
        return this.repositorioReserva.crear(reserva);
    }

    private int calcularIncrementoDiaFestivo( Servicio valor){
        int incremento;
        if(valor != null){
            int porcentaje = (int) (valor.getValor()* INCREMENTO_DIA_FESTIVO);
            incremento = porcentaje + valor.getValor();
        }else{
            throw  new ExcepcionRegistroNoDisponible(SERVICIO_SELECCIONADO_NO_EXISTE);
        }
        return incremento ;
    }

    private boolean validarDiaFestivo(LocalDateTime fecha){
        return isFestivo.getFestivos(LocalDate.from(fecha).toString());
    }
    private int  calcularDescuentoLunes(Servicio servicio) {
        int descuento;
        if(servicio != null){
            int porcentaje = (int) (DESCUENTO_LUNES * servicio.getValor());
            descuento = servicio.getValor()-porcentaje;
        }else{
            throw  new ExcepcionRegistroNoDisponible(SERVICIO_SELECCIONADO_NO_EXISTE);
        }

       return descuento;
    }

    private boolean validarSiEsLunes(Agenda agenda) {
        return agenda != null && agenda.getFecha_inicio().getDayOfWeek().equals(DayOfWeek.MONDAY);
    }

    private boolean validarCantidadLavadas(Cantidad cantidad) {
        return cantidad != null && cantidad.getContador() >= NUMERO_LAVADAS_MAXIMO;
    }

    private boolean actualizarDisponibilidad(Agenda agenda) {
        if(agenda != null && agenda.getDisponibilidad()){
            agenda.setDisponibilidad(false);
            this.repositorioAgenda.actualizar(agenda);
            return true;
        }
         return false;
    }
}
