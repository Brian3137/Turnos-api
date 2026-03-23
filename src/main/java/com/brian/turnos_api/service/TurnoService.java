package com.brian.turnos_api.service;

import com.brian.turnos_api.domain.Turno;
import java.util.List;

public interface TurnoService {

    public List<Turno> listarTurnos();

    public Turno buscarTurnoPorId(Integer id);

    public Turno guardarTurno(Turno turno);

    public void eliminarTurno(Integer id);
}
