package org.example.turnos_micro.repository;

import org.example.turnos_micro.entity.Turno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITurnoRepository extends
        JpaRepository<Turno, Long> {
}
