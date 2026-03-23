package com.brian.turnos_api.repositorio;

import com.brian.turnos_api.domain.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepositorio extends JpaRepository<Paciente, Integer> {
}
