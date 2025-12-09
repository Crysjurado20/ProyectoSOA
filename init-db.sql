-- Inicialización de la base de datos
-- Este script se ejecuta automáticamente al crear el contenedor MySQL

USE railway;

-- Crear la tabla 'usuarios' si no existe
CREATE TABLE IF NOT EXISTS usuarios (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    nombre VARCHAR(100) NOT NULL,
    rol VARCHAR(20) NOT NULL DEFAULT 'SECRETARIA',
    activo BOOLEAN DEFAULT TRUE
);

-- Crear tabla cursos si no existe
CREATE TABLE IF NOT EXISTS cursos (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    descripcion VARCHAR(255),
    codigo VARCHAR(20) NOT NULL UNIQUE
);

-- Crear tabla alumnos si no existe
CREATE TABLE IF NOT EXISTS alumnosGrupo5 (
    cedula VARCHAR(10) PRIMARY KEY,
    nombre VARCHAR(20) NOT NULL,
    apellido VARCHAR(20) NOT NULL,
    direccion VARCHAR(50) NOT NULL,
    telefono VARCHAR(10) NOT NULL,
    curso_id BIGINT,
    FOREIGN KEY (curso_id) REFERENCES cursos(id) ON DELETE SET NULL
);

-- NOTA: El primer usuario que se registre será ADMIN automáticamente.
-- Los usuarios siguientes serán SECRETARIA por defecto.
