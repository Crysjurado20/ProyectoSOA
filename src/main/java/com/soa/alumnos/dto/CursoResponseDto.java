package com.soa.alumnos.dto;

import com.soa.alumnos.entity.Alumno;
import com.soa.alumnos.entity.Curso;

import java.util.List;

public record CursoResponseDto(
        Long id,
        String nombre,
        String descripcion,
        String codigo,
        int totalAlumnos,
        List<AlumnoSimpleDto> alumnos) {
    public static CursoResponseDto fromEntity(Curso curso) {
        List<AlumnoSimpleDto> alumnosDto = curso.getAlumnos() != null
                ? curso.getAlumnos().stream()
                        .map(AlumnoSimpleDto::fromEntity)
                        .toList()
                : List.of();

        return new CursoResponseDto(
                curso.getId(),
                curso.getNombre(),
                curso.getDescripcion(),
                curso.getCodigo(),
                alumnosDto.size(),
                alumnosDto);
    }

    public record AlumnoSimpleDto(
            String cedula,
            String nombre,
            String apellido) {
        public static AlumnoSimpleDto fromEntity(Alumno alumno) {
            return new AlumnoSimpleDto(
                    alumno.getCedula(),
                    alumno.getNombre(),
                    alumno.getApellido());
        }
    }
}
