package com.soa.alumnos.dto;

import jakarta.validation.constraints.NotBlank;

public record LoginDto(
        @NotBlank(message = "El nombre de usuario es obligatorio") String username,

        @NotBlank(message = "La contraseña es obligatoria") String password) {
}
