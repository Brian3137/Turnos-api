package com.brian.turnos_api.service;

import com.brian.turnos_api.domain.Doctor;
import com.brian.turnos_api.domain.Paciente;
import com.brian.turnos_api.domain.Turno;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.brian.turnos_api.repositorio.DoctorRepositorio;
import com.brian.turnos_api.repositorio.PacienteRepositorio;
import com.brian.turnos_api.repositorio.TurnoRepositorio;

import java.util.List;

@Service
public class TurnoServiceImpl implements  TurnoService{
    @Autowired
    private TurnoRepositorio turnoRepositorio;
    @Autowired
    private DoctorRepositorio doctorRepositorio;
    @Autowired
    private PacienteRepositorio pacienteRepositorio;


    @Override
    public List<Turno> listarTurnos() {
        return turnoRepositorio.findAll();
    }

    @Override
    public Turno buscarTurnoPorId(Integer id) {
        Turno turno = turnoRepositorio.findById(id).orElse(null);
        return turno;
    }

    @Override
    public Turno guardarTurno(Turno turno) {
        Doctor doctor = doctorRepositorio.findById(turno.getDoctor().getId()).orElse(null);
        Paciente paciente = pacienteRepositorio.findById(turno.getPaciente().getId()).orElse(null);
        if (doctor == null || paciente == null) {
            return null;
        }
        turno.setDoctor(doctor);
        turno.setPaciente(paciente);
        return turnoRepositorio.save(turno);
    }

    @Override
    public void eliminarTurno(Integer id) {
        Turno turno = turnoRepositorio.findById(id).orElse(null);
        if (turno != null)
            turnoRepositorio.delete(turno);
    }
}
