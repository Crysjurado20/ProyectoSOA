package com.soa.alumnos.controller;

import com.soa.alumnos.dto.RegistroUsuarioDto;
import com.soa.alumnos.entity.Usuario;
import com.soa.alumnos.services.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("api/auth")
@CrossOrigin(origins = { "*" })
public class AuthController {

    private final UsuarioService usuarioService;

    public AuthController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping("/registro")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> registrar(@Valid @RequestBody RegistroUsuarioDto dto) {
        try {
            Usuario usuario = usuarioService.registrar(dto);
            return ResponseEntity.status(HttpStatus.CREATED).body(Map.of(
                    "mensaje", "Usuario registrado exitosamente",
                    "username", usuario.getUsername()));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(Map.of("error", e.getMessage()));
        }
    }
}
