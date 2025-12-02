package com.soa.alumnos.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "alumnosGrupo5")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Alumno {

    @Id
    @Column(name = "cedula", length = 10)
    private String cedula;

    @Column(name = "nombre", nullable = false, length = 20)
    private String nombre;

    @Column(name = "apellido", nullable = false, length = 20)
    private String apellido;

    @Column(name = "direccion", nullable = false, length = 50)
    private String direccion;

    @Column(name = "telefono", nullable = false, length = 10)
    private String telefono;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "curso_id")
    @JsonBackReference
    private Curso curso;
}
