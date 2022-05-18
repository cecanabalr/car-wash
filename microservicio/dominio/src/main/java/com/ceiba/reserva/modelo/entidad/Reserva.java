package com.ceiba.reserva.modelo.entidad;

import com.ceiba.agenda.modelo.entidad.Agenda;
import com.ceiba.cantidad.modelo.entidad.Cantidad;
import com.ceiba.servicio.modelo.entidad.Servicio;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

import static com.ceiba.dominio.ValidadorArgumento.validarExistenciaRegistro;
import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;

@Getter
@Setter
public class Reserva {

    private static final String SE_DEBE_INGRESAR_EL_NOMBRE = "Se debe ingresar el nombre";
    private static final String SE_DEBE_INGRESAR_LA_PLACA = "Se debe ingresar la placa";
    private static final String SE_DEBE_INGRESAR_LA_AGENDA = "Se debe ingresar la agenda";
    private static final String SE_DEBE_INGRESAR_EL_SERVICIO = "Se debe ingresar el servicio";
    private static final int LAVADA_GRATIS = 0;
    public static final String LA_AGENDA_SELECCIONADA_NO_EXISTE = "La agenda seleccionada no existe";
    public static final String EL_SERVICIO_SELECCIONADA_NO_EXISTE = "El servicio seleccionada no existe";

    private Long id;
    private String nombre;
    private String placa;
    private LocalDateTime fechaCreacion;
    private Agenda agenda;
    private Servicio servicio;
    private Cantidad cantidad;
    private int total;

    public Reserva(Long id, String nombre, String placa, LocalDateTime fechaCreacion, Agenda agenda, Servicio servicio, Cantidad cantidad, int total) {

        validarObligatorio(nombre, SE_DEBE_INGRESAR_EL_NOMBRE);
        validarObligatorio(placa, SE_DEBE_INGRESAR_LA_PLACA);
        validarExistenciaRegistro(agenda, LA_AGENDA_SELECCIONADA_NO_EXISTE);
        validarExistenciaRegistro(servicio, EL_SERVICIO_SELECCIONADA_NO_EXISTE);

        this.id = id;
        this.nombre = nombre;
        this.placa = placa;
        this.fechaCreacion = fechaCreacion;
        this.agenda = agenda;
        this.servicio = servicio;
        this.cantidad = cantidad;
        this.total = total;
    }

    public static Reserva crearReserva(Reserva reserva) {

        validarObligatorio(reserva.getNombre(), SE_DEBE_INGRESAR_EL_NOMBRE);
        validarObligatorio(reserva.getPlaca(), SE_DEBE_INGRESAR_LA_PLACA);
        validarExistenciaRegistro(reserva.getAgenda(), LA_AGENDA_SELECCIONADA_NO_EXISTE);
        validarExistenciaRegistro(reserva.getServicio(), EL_SERVICIO_SELECCIONADA_NO_EXISTE);

        String fechaReserva = reserva.getAgenda().getFechaInicio().toLocalDate().toString();
        Cantidad actualizarCantidad = Cantidad.actualizarCantidad(reserva);

        int total = LAVADA_GRATIS;
        if(actualizarCantidad.getId()== 0){
            total = reserva.getServicio().getValor();
        }else if (DiasFestivos.getDias().contains(fechaReserva)) {
            total = reserva.getServicio()
                    .calcularIncrementoDiaFestivo(reserva.getServicio().getValor());
        }else if (Agenda.validarSiEsLunes(reserva.getAgenda().getFechaInicio())){
            total = reserva.getServicio()
                    .calcularDescuentoLunes(reserva.getServicio().getValor());
        }

        Agenda actualizarAgenda = Agenda.actualizarDisponibilidad(reserva.getAgenda());

        return new Reserva(reserva.getId(), reserva.getNombre(), reserva.getPlaca(), reserva.getFechaCreacion(),actualizarAgenda, reserva.getServicio(),actualizarCantidad, total );
    }

}
