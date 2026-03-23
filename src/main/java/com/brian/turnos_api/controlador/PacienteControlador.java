package com.brian.turnos_api.controlador;

import com.brian.turnos_api.domain.Paciente;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.brian.turnos_api.service.PacienteService;

import java.util.List;

@RestController
@RequestMapping("/api/pacientes")
public class PacienteControlador {

    private static final Logger logger = LoggerFactory.getLogger(PacienteControlador.class);

    @Autowired
    private PacienteService pacienteService;

    // LISTAR
    @GetMapping
    public List<Paciente> listarPacientes(){
        var pacientes = pacienteService.listarPacientes();
        pacientes.forEach(p -> logger.info(p.toString()));
        return pacientes;
    }

    // BUSCAR POR ID
    @GetMapping("/{id}")
    public ResponseEntity<Paciente> buscarPacientePorId(@PathVariable Integer id){
        Paciente paciente = pacienteService.buscarPacientePorId(id);
        if (paciente == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(paciente);
    }

    // CREAR
    @PostMapping
    public Paciente agregarPaciente(@RequestBody Paciente paciente){
        logger.info("Paciente a agregar: " + paciente);
        return pacienteService.guardarPaciente(paciente);
    }

    // ACTUALIZAR
    @PutMapping("/{id}")
    public ResponseEntity<Paciente> actualizarPaciente(@PathVariable Integer id, @RequestBody Paciente pacienteRecibido){
        Paciente paciente = pacienteService.buscarPacientePorId(id);
        if (paciente == null)
            return ResponseEntity.notFound().build();

        paciente.setNombre(pacienteRecibido.getNombre());
        paciente.setEmail(pacienteRecibido.getEmail());

        pacienteService.guardarPaciente(paciente);

        return ResponseEntity.ok(paciente);
    }

    // ELIMINAR
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarPaciente(@PathVariable Integer id){
        Paciente paciente = pacienteService.buscarPacientePorId(id);
        if (paciente == null)
            return ResponseEntity.notFound().build();

        pacienteService.eliminarPaciente(id);

        return ResponseEntity.noContent().build();
    }
}