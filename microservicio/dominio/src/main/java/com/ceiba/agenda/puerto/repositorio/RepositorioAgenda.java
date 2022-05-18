package com.ceiba.agenda.puerto.repositorio;

import com.ceiba.agenda.modelo.entidad.Agenda;

public interface RepositorioAgenda {

    void crear(Agenda agenda);

    void actualizar(Agenda agenda);

    Agenda existePorId(Long id);
}
