package com.brian.turnos_api.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import com.brian.turnos_api.repositorio.DoctorRepositorio;
import com.brian.turnos_api.repositorio.PacienteRepositorio;
import com.brian.turnos_api.repositorio.TurnoRepositorio;
import com.brian.turnos_api.domain.Doctor;
import com.brian.turnos_api.domain.Paciente;
import com.brian.turnos_api.domain.Turno;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;



public class TurnoServiceTest {


    @Mock
    private TurnoRepositorio turnoRepositorio;

    @Mock
    private DoctorRepositorio doctorRepositorio;

    @Mock
    private PacienteRepositorio pacienteRepositorio;

    @InjectMocks
    private TurnoServiceImpl turnoService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testInicial() {
        System.out.println("Test listo");
    }
    @Test
    void guardarTurno_ok() {

        // 1. Crear datos
        Doctor doctor = new Doctor(1, "Juan", "Cardio");
        Paciente paciente = new Paciente(1, "Maria", "mail@gmail.com");

        Turno turno = new Turno(null, LocalDateTime.now(), doctor, paciente);

        // 2. Simular repositorios
        when(doctorRepositorio.findById(1)).thenReturn(Optional.of(doctor));
        when(pacienteRepositorio.findById(1)).thenReturn(Optional.of(paciente));
        when(turnoRepositorio.save(any(Turno.class))).thenReturn(turno);

        // 3. Ejecutar método real
        Turno resultado = turnoService.guardarTurno(turno);

        // 4. Verificar
        assertNotNull(resultado);
        verify(turnoRepositorio).save(turno);
    }
    @Test
    void guardarTurno_sinDoctor() {

        // 1. Crear turno con doctor
        Doctor doctor = new Doctor(1, "Juan", "Cardio");
        Paciente paciente = new Paciente(1, "Maria", "mail@gmail.com");

        Turno turno = new Turno(null, LocalDateTime.now(), doctor, paciente);

        // 2. Simular que NO existe doctor
        when(doctorRepositorio.findById(1)).thenReturn(Optional.empty());

        // 3. Ejecutar
        Turno resultado = turnoService.guardarTurno(turno);

        // 4. Verificar
        assertNull(resultado);
        verify(turnoRepositorio, never()).save(any());
    }
}