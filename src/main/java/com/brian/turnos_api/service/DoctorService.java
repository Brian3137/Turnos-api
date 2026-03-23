package com.brian.turnos_api.service;

import com.brian.turnos_api.domain.Doctor;

import java.util.List;

public interface DoctorService {

    public List<Doctor> listarDoctores();

    public Doctor buscarDoctorPorId(Integer id);

    public Doctor guardarDoctor(Doctor doctor);

    public  void eliminarDoctor(Integer id);

}
