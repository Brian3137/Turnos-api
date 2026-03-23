package com.brian.turnos_api.controlador;

import com.brian.turnos_api.domain.Doctor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.brian.turnos_api.service.DoctorService;

import java.util.List;

@RestController
@RequestMapping("/api/doctores")
public class DoctorControlador {

    private static final Logger logger = LoggerFactory.getLogger(DoctorControlador.class);

    @Autowired
    private DoctorService doctorService;

    // LISTAR
    @GetMapping
    public List<Doctor> listarDoctores(){
        var doctores = doctorService.listarDoctores();
        doctores.forEach(d -> logger.info(d.toString()));
        return doctores;
    }

    // BUSCAR POR ID
    @GetMapping("/{id}")
    public ResponseEntity<Doctor> buscarDoctorPorId(@PathVariable Integer id){
        Doctor doctor = doctorService.buscarDoctorPorId(id);
        if (doctor == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(doctor);
    }

    // CREAR
    @PostMapping
    public Doctor agregarDoctor(@RequestBody Doctor doctor){
        logger.info("Doctor a agregar: " + doctor);
        return doctorService.guardarDoctor(doctor);
    }

    // ACTUALIZAR
    @PutMapping("/{id}")
    public ResponseEntity<Doctor> actualizarDoctor(@PathVariable Integer id, @RequestBody Doctor doctorRecibido){
        Doctor doctor = doctorService.buscarDoctorPorId(id);
        if (doctor == null)
            return ResponseEntity.notFound().build();

        doctor.setNombre(doctorRecibido.getNombre());
        doctor.setEspecialidad(doctorRecibido.getEspecialidad());

        doctorService.guardarDoctor(doctor);

        return ResponseEntity.ok(doctor);
    }

    // ELIMINAR
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarDoctor(@PathVariable Integer id){
        Doctor doctor = doctorService.buscarDoctorPorId(id);
        if (doctor == null)
            return ResponseEntity.notFound().build();

        doctorService.eliminarDoctor(id);

        return ResponseEntity.noContent().build();
    }
}