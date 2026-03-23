package com.brian.turnos_api.repositorio;

import com.brian.turnos_api.domain.Turno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TurnoRepositorio extends JpaRepository<Turno, Integer> {
}
