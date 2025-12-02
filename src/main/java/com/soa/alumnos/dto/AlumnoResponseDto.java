package com.soa.alumnos.dto;

import com.soa.alumnos.entity.Alumno;

public record AlumnoResponseDto(
        String cedula,
        String nombre,
        String apellido,
        String direccion,
        String telefono,
        CursoSimpleDto curso) {
    public static AlumnoResponseDto fromEntity(Alumno alumno) {
        CursoSimpleDto cursoDto = alumno.getCurso() != null
                ? new CursoSimpleDto(
                        alumno.getCurso().getId(),
                        alumno.getCurso().getNombre(),
                        alumno.getCurso().getCodigo())
                : null;

        return new AlumnoResponseDto(
                alumno.getCedula(),
                alumno.getNombre(),
                alumno.getApellido(),
                alumno.getDireccion(),
                alumno.getTelefono(),
                cursoDto);
    }

    public record CursoSimpleDto(
            Long id,
            String nombre,
            String codigo) {
    }
}
