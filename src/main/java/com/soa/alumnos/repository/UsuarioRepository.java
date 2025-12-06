package com.soa.alumnos.repository;

import com.soa.alumnos.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByUsername(String username);

    Optional<Usuario> findByEmail(String email);

    boolean existsByUsername(String username);

    boolean existsByEmail(String email);

    @Query("SELECT u FROM Usuario u WHERE u.username = :usernameOrEmail OR u.email = :usernameOrEmail")
    Optional<Usuario> findByUsernameOrEmail(@Param("usernameOrEmail") String usernameOrEmail);
}
