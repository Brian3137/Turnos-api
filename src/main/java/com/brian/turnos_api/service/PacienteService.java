package com.brian.turnos_api.service;

import com.brian.turnos_api.domain.Paciente;
import java.util.List;

public interface PacienteService {

    public List<Paciente> listarPacientes();

    public Paciente buscarPacientePorId(Integer id);

    public Paciente guardarPaciente(Paciente paciente);

    public void eliminarPaciente(Integer id);
}
