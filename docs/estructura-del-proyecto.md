# Estructura del Proyecto - Sistema de Control de Asistencia CESDE

## Índice
1. [Visión General](#visión-general)
2. [Estructura de Directorios](#estructura-de-directorios)
3. [Componentes Principales](#componentes-principales)
4. [Configuración](#configuración)
5. [Base de Datos](#base-de-datos)

## Visión General
Este proyecto es una API REST desarrollada con Spring Boot para gestionar la asistencia de estudiantes en CESDE. El sistema permite el registro y control de asistencias, gestión de cursos y estudiantes.

## Estructura de Directorios
```
src/
├── main/
│   ├── java/
│   │   └── com/
│   │       └── example/
│   │           └── pi1/
│   │               ├── config/      # Configuraciones de la aplicación
│   │               ├── controller/  # Controladores REST
│   │               ├── model/       # Entidades y modelos
│   │               ├── repository/  # Repositorios JPA
│   │               └── service/     # Lógica de negocio
│   └── resources/   # Archivos de configuración
└── test/           # Pruebas unitarias e integración
```

## Componentes Principales

### Controladores (controllers/)
Gestionan las peticiones HTTP y definen los endpoints de la API.

- **AsistenciaController**: Maneja operaciones CRUD para registros de asistencia
  - GET /api/asistencias
  - POST /api/asistencias
  - GET /api/asistencias/{id}
  - PUT /api/asistencias/{id}
  - DELETE /api/asistencias/{id}

- **CursoController**: Gestiona operaciones relacionadas con cursos
  - Endpoints para crear, listar, actualizar y eliminar cursos
  - Funcionalidad para asignar estudiantes a cursos

- **EstudianteController**: Administra información de estudiantes
  - CRUD completo para gestión de estudiantes
  - Consultas de asistencia por estudiante

### Modelos (model/)
Definen las entidades principales del sistema:

- **Asistencia**: Registro de asistencia individual
  - ID
  - Fecha
  - Estado (presente/ausente)
  - Referencias a Estudiante y Curso

- **Curso**: Información del curso
  - ID
  - Nombre
  - Descripción
  - Lista de estudiantes

- **Estudiante**: Datos del estudiante
  - ID
  - Nombre
  - Email
  - Información académica

### Servicios (service/)
Implementan la lógica de negocio:

- **AsistenciaService**: 
  - Registro de asistencias
  - Consultas por fecha, estudiante y curso
  - Generación de reportes

- **CursoService**:
  - Gestión de cursos
  - Asignación de estudiantes
  - Consultas de asistencia por curso

- **EstudianteService**:
  - Gestión de estudiantes
  - Consultas de asistencia individual
  - Reportes por estudiante

## Configuración

### OpenAPI/Swagger (config/OpenApiConfig)
Configura la documentación automática de la API:
- Información del proyecto
- Endpoints disponibles
- Modelos de datos
- Servidores de desarrollo y producción

### Base de Datos
Utiliza JPA/Hibernate para la persistencia de datos:
- Configuración en application.properties
- Mapeo objeto-relacional
- Repositorios para acceso a datos

## Seguridad
- Implementación de CORS
- Validación de datos
- Manejo de errores y excepciones

## Despliegue
El proyecto incluye:
- Dockerfile para containerización
- Scripts de construcción y despliegue
- Configuración para entornos de desarrollo y producción

## Documentación Adicional
Para más detalles, consultar:
- /docs/swagger-documentacion.md - Documentación de la API
- /docs/docker-y-despliegue.md - Guía de despliegue
- /docs/endpoints-*.md - Documentación detallada de endpoints