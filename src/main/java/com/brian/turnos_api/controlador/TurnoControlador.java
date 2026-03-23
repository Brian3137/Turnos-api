package com.brian.turnos_api.controlador;

import com.brian.turnos_api.domain.Turno;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.brian.turnos_api.service.TurnoService;

import java.util.List;

@RestController
@RequestMapping("/api/turnos")
public class TurnoControlador {
    @Autowired
    private TurnoService turnoService;
    private static final Logger logger = LoggerFactory.getLogger(TurnoControlador.class);

    @GetMapping
    public List<Turno> listarTurnos(){
    var turnos = turnoService.listarTurnos();
    turnos.forEach(t -> logger.info(t.toString()));
    return turnos;
    }

    @PostMapping
    public Turno agregarTurno(@RequestBody Turno turno){
        logger.info("Turno a agregar: " + turno );
        return turnoService.guardarTurno(turno);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Turno> buscarTurnoPorId(@PathVariable Integer id){
        Turno turno = turnoService.buscarTurnoPorId(id);
        if (turno == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(turno);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarTurno(@PathVariable Integer id){
        Turno turno = turnoService.buscarTurnoPorId(id);
        if (turno == null)
            return ResponseEntity.notFound().build();
        turnoService.eliminarTurno(id);
        return ResponseEntity.noContent().build();
    }
}
