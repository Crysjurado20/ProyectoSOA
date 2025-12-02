package com.soa.alumnos.dto;

import jakarta.validation.constraints.NotBlank;

public record CursoUpdateDto(
        @NotBlank(message = "El nombre es obligatorio") String nombre,

        String descripcion) {
}
