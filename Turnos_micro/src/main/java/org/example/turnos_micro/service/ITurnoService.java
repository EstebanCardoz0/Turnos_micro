package org.example.turnos_micro.service;

import org.example.turnos_micro.entity.Turno;

import java.time.LocalDate;
import java.util.List;

public interface ITurnoService {



    void saveTurno(LocalDate fecha,
                   String tratamiento,
                   String dniPaciente);

    List<Turno> getTurnos();

    Turno findTurno(Long id);

    void deleteTurno(Long id);

    void editTurno(Turno tur, Long id);
}

