# Sistema de Gestión de Asistencia Estudiantil

## Descripción General
Este sistema está diseñado para gestionar la asistencia de estudiantes en diferentes cursos. Permite registrar y hacer seguimiento de la asistencia de los estudiantes, gestionar información de cursos y mantener un registro detallado de las asistencias.

## Estructura del Proyecto

### Modelos de Datos

#### 1. Estudiante
- **Clase**: `Estudiante`
- **Ubicación**: `com.example.pi1.model.Estudiante`
- **Atributos**:
  - `id`: Identificador único (Long)
  - `nombre`: Nombre del estudiante (String)
  - `apellido`: Apellido del estudiante (String)
  - `email`: Correo electrónico único (String)
  - `asistencias`: Lista de asistencias del estudiante

#### 2. Curso
- **Clase**: `Curso`
- **Ubicación**: `com.example.pi1.model.Curso`
- **Atributos**:
  - `id`: Identificador único (Long)
  - `nombreCurso`: Nombre del curso (String)
  - `descripcion`: Descripción del curso (Text)
  - `fechaInicio`: Fecha de inicio del curso (LocalDate)
  - `fechaFin`: Fecha de finalización del curso (LocalDate)
  - `asistencias`: Lista de asistencias relacionadas al curso

#### 3. Asistencia
- **Clase**: `Asistencia`
- **Ubicación**: `com.example.pi1.model.Asistencia`
- **Atributos**:
  - `id`: Identificador único (Long)
  - `estudiante`: Referencia al estudiante
  - `curso`: Referencia al curso
  - `fechaAsistencia`: Fecha de la asistencia (LocalDate)
  - `estadoAsistencia`: Estado de la asistencia (Presente, Ausente, Tarde)

### Relaciones entre Entidades

1. **Estudiante - Asistencia**:
   - Relación One-to-Many (Un estudiante puede tener múltiples asistencias)
   - Configurada con `@OneToMany` en Estudiante y `@ManyToOne` en Asistencia
   - Cascade Type ALL para operaciones en cascada

2. **Curso - Asistencia**:
   - Relación One-to-Many (Un curso puede tener múltiples asistencias)
   - Configurada con `@OneToMany` en Curso y `@ManyToOne` en Asistencia
   - Cascade Type ALL para operaciones en cascada

### Anotaciones Importantes

- `@JsonManagedReference` y `@JsonBackReference`: Utilizadas para manejar referencias circulares en la serialización JSON
- `@Entity`: Marca las clases como entidades JPA
- `@Table`: Especifica el nombre de la tabla en la base de datos
- `@Column`: Define propiedades específicas de las columnas (nullable, unique, etc.)

## Funcionalidades Principales

### Gestión de Estudiantes
- Registro de nuevos estudiantes
- Actualización de información de estudiantes
- Consulta de estudiantes y sus asistencias
- Eliminación de estudiantes

### Gestión de Cursos
- Creación de nuevos cursos
- Actualización de información de cursos
- Consulta de cursos y sus asistencias
- Eliminación de cursos

### Gestión de Asistencias
- Registro de asistencias
- Actualización de estados de asistencia
- Consulta de asistencias por estudiante o curso
- Generación de reportes de asistencia

## Endpoints de la API

Para información detallada sobre los endpoints disponibles, consulte los siguientes documentos:
- [Endpoints de Estudiante](endpoints-estudiante.md)
- [Endpoints de Curso](endpoints-curso.md)
- [Endpoints de Asistencia](endpoints-asistencia.md)

## Tecnologías Utilizadas

- **Spring Boot**: Framework principal para el desarrollo
- **JPA/Hibernate**: Para la persistencia de datos
- **Lombok**: Para reducir código boilerplate
- **Jackson**: Para el manejo de JSON
- **Maven**: Para la gestión de dependencias

## Consideraciones de Seguridad

- Los emails de los estudiantes son únicos en el sistema
- Las relaciones entre entidades están protegidas contra eliminaciones en cascada no deseadas
- Se utilizan validaciones para garantizar la integridad de los datos

## Conclusión

Este sistema proporciona una solución robusta y escalable para la gestión de asistencias estudiantiles, permitiendo un seguimiento efectivo de la asistencia en diferentes cursos. La arquitectura está diseñada para ser mantenible y extensible, facilitando futuras mejoras y adaptaciones según las necesidades.