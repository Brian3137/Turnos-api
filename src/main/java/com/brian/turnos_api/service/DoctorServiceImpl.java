package com.brian.turnos_api.service;

import com.brian.turnos_api.domain.Doctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.brian.turnos_api.repositorio.DoctorRepositorio;
import java.util.List;

@Service
public class DoctorServiceImpl implements DoctorService{
    @Autowired
    private DoctorRepositorio doctorRepositorio;

    @Override
    public List<Doctor> listarDoctores() {
        return doctorRepositorio.findAll();
    }

    @Override
    public Doctor buscarDoctorPorId(Integer id) {
        Doctor doctor = doctorRepositorio.findById(id).orElse(null);
        return doctor;
    }

    @Override
    public Doctor guardarDoctor(Doctor doctor) {
        doctorRepositorio.save(doctor);
        return doctor;
    }

    @Override
    public void eliminarDoctor(Integer id) {
        Doctor doctor = doctorRepositorio.findById(id).orElse(null);
        if (doctor != null) {
            doctorRepositorio.delete(doctor);
        }
    }
}
