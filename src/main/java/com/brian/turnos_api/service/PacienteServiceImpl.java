package com.brian.turnos_api.service;

import com.brian.turnos_api.domain.Paciente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.brian.turnos_api.repositorio.PacienteRepositorio;

import java.util.List;

@Service
public class PacienteServiceImpl implements PacienteService{
    @Autowired
    private PacienteRepositorio pacienteRepositorio;

    @Override
    public List<Paciente> listarPacientes() {
        return pacienteRepositorio.findAll();
    }

    @Override
    public Paciente buscarPacientePorId(Integer id) {
        Paciente paciente = pacienteRepositorio.findById(id).orElse(null);
        return paciente;
    }

    @Override
    public Paciente guardarPaciente(Paciente paciente) {
        pacienteRepositorio.save(paciente);
        return paciente;
    }

    @Override
    public void eliminarPaciente(Integer id) {
        Paciente paciente = pacienteRepositorio.findById(id).orElse(null);
        if (paciente!= null)
            pacienteRepositorio.delete(paciente);
    }
}
