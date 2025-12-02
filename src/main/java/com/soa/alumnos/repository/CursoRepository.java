package com.soa.alumnos.repository;

import com.soa.alumnos.entity.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CursoRepository extends JpaRepository<Curso, Long> {
    boolean existsByCodigo(String codigo);

    Optional<Curso> findByCodigo(String codigo);
}
