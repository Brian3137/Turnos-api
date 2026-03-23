package com.brian.turnos_api.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Turno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    Integer id;
    LocalDateTime fecha;
    @ManyToOne
    Doctor doctor;
    @ManyToOne
    Paciente paciente;
}
