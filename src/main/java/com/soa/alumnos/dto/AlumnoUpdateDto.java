package com.soa.alumnos.dto;

import jakarta.validation.constraints.NotBlank;

public record AlumnoUpdateDto (

        @NotBlank String nombre,

        @NotBlank String apellido,

        @NotBlank String direccion,

        @NotBlank String telefono
){

}