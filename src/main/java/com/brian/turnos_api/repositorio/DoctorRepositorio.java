package com.brian.turnos_api.repositorio;

import com.brian.turnos_api.domain.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepositorio extends JpaRepository<Doctor, Integer> {
}
