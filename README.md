# Sistema de Gestión de Alumnos y Cursos

Sistema desarrollado con Spring Boot para la gestión de alumnos y cursos, con autenticación mediante Spring Security y vistas con Thymeleaf.

## Características

- ✅ CRUD completo de Alumnos
- ✅ CRUD completo de Cursos
- ✅ Relación: Un Curso puede tener muchos Alumnos, pero cada Alumno pertenece a un solo Curso
- ✅ Asignar/desasignar alumnos a cursos
- ✅ Consultar alumnos por curso
- ✅ Consultar curso de un alumno
- ✅ Autenticación con Spring Security (Login/Registro)
- ✅ Vistas con Thymeleaf
- ✅ Docker y Docker Compose para despliegue

## Tecnologías

- Java 21
- Spring Boot 3.2.0
- Spring Security
- Spring Data JPA
- Thymeleaf
- MySQL 8.0
- Docker & Docker Compose
- Bootstrap 5

## Endpoints API REST

### Alumnos
| Método | Endpoint | Descripción |
|--------|----------|-------------|
| GET | `/api/alumnos` | Listar todos los alumnos |
| GET | `/api/alumnos/{cedula}` | Obtener alumno por cédula |
| POST | `/api/alumnos` | Crear nuevo alumno |
| PUT | `/api/alumnos/{cedula}` | Actualizar alumno |
| DELETE | `/api/alumnos/{cedula}` | Eliminar alumno |
| GET | `/api/alumnos/{cedula}/curso` | Obtener curso del alumno |
| PUT | `/api/alumnos/{cedula}/curso/{cursoId}` | Asignar curso al alumno |
| DELETE | `/api/alumnos/{cedula}/curso` | Desasignar curso del alumno |

### Cursos
| Método | Endpoint | Descripción |
|--------|----------|-------------|
| GET | `/api/cursos` | Listar todos los cursos |
| GET | `/api/cursos/{id}` | Obtener curso por ID |
| POST | `/api/cursos` | Crear nuevo curso |
| PUT | `/api/cursos/{id}` | Actualizar curso |
| DELETE | `/api/cursos/{id}` | Eliminar curso |
| GET | `/api/cursos/{id}/alumnos` | Obtener alumnos del curso |
| POST | `/api/cursos/{id}/alumnos/{cedula}` | Asignar alumno al curso |
| DELETE | `/api/cursos/alumnos/{cedula}` | Desasignar alumno |

### Autenticación
| Método | Endpoint | Descripción |
|--------|----------|-------------|
| POST | `/api/auth/registro` | Registrar nuevo usuario |

## Vistas Web

- `/login` - Página de inicio de sesión
- `/registro` - Página de registro
- `/dashboard` - Panel principal
- `/alumnos` - Gestión de alumnos
- `/cursos` - Gestión de cursos

## Instalación y Ejecución

### Opción 1: Docker (Recomendado)

```bash
# Construir y ejecutar con Docker Compose
docker-compose up -d --build

# Ver logs
docker-compose logs -f

# Detener
docker-compose down
```

La aplicación estará disponible en: http://localhost:8080

### Opción 2: Desarrollo Local

1. Requisitos:
   - Java 21
   - Maven
   - MySQL 8.0

2. Configurar base de datos MySQL:
```sql
CREATE DATABASE soa;
```

3. Ejecutar la aplicación:
```bash
./mvnw spring-boot:run
```

## Credenciales por Defecto

Para el primer uso, registra un nuevo usuario desde la página de registro (`/registro`).

## Estructura del Proyecto

```
src/main/java/com/soa/alumnos/
├── config/          # Configuraciones (Security)
├── controller/      # Controladores REST y Web
├── dto/             # Data Transfer Objects
├── entity/          # Entidades JPA
├── repository/      # Repositorios JPA
└── services/        # Servicios de negocio

src/main/resources/
├── templates/       # Plantillas Thymeleaf
│   ├── alumnos/
│   ├── cursos/
│   ├── dashboard.html
│   ├── login.html
│   └── registro.html
└── application.properties
```

## Variables de Entorno

| Variable | Descripción | Valor por defecto |
|----------|-------------|-------------------|
| DATABASE_URL | URL de conexión a MySQL | jdbc:mysql://localhost:3306/soa |
| DATABASE_USER | Usuario de base de datos | root |
| DATABASE_PASSWORD | Contraseña de base de datos | (vacío) |
| SERVER_PORT | Puerto del servidor | 8080 |

## Licencia

Este proyecto es de uso educativo.
