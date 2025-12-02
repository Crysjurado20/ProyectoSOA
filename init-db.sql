-- Inicialización de la base de datos
-- Este script se ejecuta automáticamente al crear el contenedor MySQL

USE soa;

-- Crear usuario administrador por defecto (password: admin123)
-- El password está encriptado con BCrypt
INSERT INTO usuarios (username, password, email, nombre, rol, activo) 
VALUES ('admin', '$2a$10$N.zmdr9k7uOCQb376NoUnuTJ8iAt6Z5EHsM8lE9lBOsl7iAt6Z5EH', 'admin@sistema.com', 'Administrador', 'ADMIN', true)
ON DUPLICATE KEY UPDATE username=username;

-- Nota: La contraseña 'admin123' está encriptada con BCrypt
-- Para generar nuevos hashes, puedes usar: https://bcrypt-generator.com/
