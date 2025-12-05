-- Inicialización de la base de datos
-- Este script se ejecuta automáticamente al crear el contenedor MySQL

USE soa;

-- Crear la tabla 'usuarios' si no existe (compatible con la entidad `Usuario`)
CREATE TABLE IF NOT EXISTS usuarios (
	id BIGINT AUTO_INCREMENT PRIMARY KEY,
	username VARCHAR(50) NOT NULL UNIQUE,
	password VARCHAR(255) NOT NULL,
	email VARCHAR(100) NOT NULL UNIQUE,
	nombre VARCHAR(100) NOT NULL,
	rol VARCHAR(20) NOT NULL DEFAULT 'SECRETARIA',
	activo BOOLEAN DEFAULT TRUE
);

-- Crear usuario administrador por defecto (password: admin123)
-- El password está encriptado con BCrypt
INSERT INTO usuarios (username, password, email, nombre, rol, activo) 
VALUES ('admin', '$2a$10$N.zmdr9k7uOCQb376NoUnuTJ8iAt6Z5EHsM8lE9lBOsl7iAt6Z5EH', 'admin@sistema.com', 'Administrador', 'ADMIN', true)
ON DUPLICATE KEY UPDATE username=username;

-- Crear usuario secretaria de ejemplo (password: secretaria123)
INSERT INTO usuarios (username, password, email, nombre, rol, activo) 
VALUES ('secretaria', '$2a$10$N.zmdr9k7uOCQb376NoUnuTJ8iAt6Z5EHsM8lE9lBOsl7iAt6Z5EH', 'secretaria@sistema.com', 'Secretaria', 'SECRETARIA', true)
ON DUPLICATE KEY UPDATE username=username;

-- Nota: Las contraseñas están encriptadas con BCrypt
-- admin123 para admin, secretaria usa la misma contraseña de ejemplo
-- Para generar nuevos hashes, puedes usar: https://bcrypt-generator.com/
