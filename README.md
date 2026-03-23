# API REST - Sistema de Turnos Médicos

Este proyecto es una API REST desarrollada con Spring Boot que permite gestionar doctores, pacientes y turnos médicos.

---

## Funcionalidades

- CRUD de Doctores
- CRUD de Pacientes
- Gestión de Turnos
- Relación entre entidades (Doctor y Paciente con Turno)

---

## Tecnologías utilizadas

- Java 21
- Spring Boot
- Spring Data JPA
- H2 Database
- Maven

---

## Estructura del proyecto

- Controller → Manejo de peticiones HTTP
- Service → Lógica de negocio
- Repository → Acceso a datos
- Entity → Modelado de la base de datos

---

##  Endpoints principales

### Doctores
- GET /api/doctores
- POST /api/doctores
- PUT /api/doctores/{id}
- DELETE /api/doctores/{id}

### Pacientes
- GET /api/pacientes
- POST /api/pacientes
- PUT /api/pacientes/{id}
- DELETE /api/pacientes/{id}

### Turnos
- GET /api/turnos
- POST /api/turnos
- DELETE /api/turnos/{id}

---

## Ejemplo de request (crear turno)

```json
{
  "fecha": "2026-03-20T10:00:00",
  "doctor": { "id": 1 },
  "paciente": { "id": 1 }
}
  "doctor"
  "paciente": { "id": 1 }
}
