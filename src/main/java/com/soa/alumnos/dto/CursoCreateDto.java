package com.soa.alumnos.dto;

import jakarta.validation.constraints.NotBlank;

public record CursoCreateDto(
        @NotBlank(message = "El nombre es obligatorio") String nombre,

        String descripcion,

        @NotBlank(message = "El código es obligatorio") String codigo) {
}
