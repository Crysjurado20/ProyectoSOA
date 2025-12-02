package com.soa.alumnos.dto;

import jakarta.validation.constraints.NotBlank;

public record AsignarCursoDto(
        @NotBlank(message = "La cédula del alumno es obligatoria") String cedulaAlumno,

        Long cursoId) {
}
