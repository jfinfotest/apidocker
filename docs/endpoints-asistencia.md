# Documentación de Endpoints de Asistencia

## Índice
- [Crear Asistencia](#crear-asistencia)
- [Obtener Asistencias](#obtener-asistencias)
- [Obtener Asistencia por ID](#obtener-asistencia-por-id)
- [Buscar Asistencias por Estudiante](#buscar-asistencias-por-estudiante)
- [Buscar Asistencias por Curso](#buscar-asistencias-por-curso)
- [Buscar Asistencias por Fecha](#buscar-asistencias-por-fecha)
- [Buscar Asistencias por Estudiante y Curso](#buscar-asistencias-por-estudiante-y-curso)
- [Buscar Asistencias por Estudiante y Fecha](#buscar-asistencias-por-estudiante-y-fecha)
- [Buscar Asistencias por Curso y Fecha](#buscar-asistencias-por-curso-y-fecha)
- [Actualizar Asistencia](#actualizar-asistencia)
- [Eliminar Asistencia](#eliminar-asistencia)

## Crear Asistencia
### POST /api/asistencias

Crea un nuevo registro de asistencia.

**Cuerpo de la Petición:**
```json
{
    "estudiante": {
        "id": "long"
    },
    "curso": {
        "id": "long"
    },
    "fechaAsistencia": "YYYY-MM-DD",
    "estadoAsistencia": "PRESENTE|AUSENTE|TARDANZA"
}
```

**Respuesta:**
- Código: 200 OK
- Cuerpo: Objeto de asistencia creado

## Obtener Asistencias
### GET /api/asistencias

Obtiene todas las asistencias registradas.

**Respuesta:**
- Código: 200 OK
- Cuerpo: Array de asistencias

## Obtener Asistencia por ID
### GET /api/asistencias/{id}

Obtiene una asistencia específica por su ID.

**Parámetros de Ruta:**
- id: ID de la asistencia (Long)

**Respuesta:**
- Código: 200 OK
- Cuerpo: Objeto de asistencia
- Código: 404 NOT FOUND (si no existe)

## Buscar Asistencias por Estudiante
### GET /api/asistencias/estudiante/{estudianteId}

Obtiene todas las asistencias de un estudiante específico.

**Parámetros de Ruta:**
- estudianteId: ID del estudiante (Long)

**Respuesta:**
- Código: 200 OK
- Cuerpo: Array de asistencias
- Código: 404 NOT FOUND (si el estudiante no existe)

## Buscar Asistencias por Curso
### GET /api/asistencias/curso/{cursoId}

Obtiene todas las asistencias de un curso específico.

**Parámetros de Ruta:**
- cursoId: ID del curso (Long)

**Respuesta:**
- Código: 200 OK
- Cuerpo: Array de asistencias
- Código: 404 NOT FOUND (si el curso no existe)

## Buscar Asistencias por Fecha
### GET /api/asistencias/fecha/{fecha}

Obtiene todas las asistencias de una fecha específica.

**Parámetros de Ruta:**
- fecha: Fecha en formato YYYY-MM-DD

**Respuesta:**
- Código: 200 OK
- Cuerpo: Array de asistencias

## Buscar Asistencias por Estudiante y Curso
### GET /api/asistencias/estudiante/{estudianteId}/curso/{cursoId}

Obtiene todas las asistencias de un estudiante en un curso específico.

**Parámetros de Ruta:**
- estudianteId: ID del estudiante (Long)
- cursoId: ID del curso (Long)

**Respuesta:**
- Código: 200 OK
- Cuerpo: Array de asistencias
- Código: 404 NOT FOUND (si el estudiante o curso no existe)

## Buscar Asistencias por Estudiante y Fecha
### GET /api/asistencias/estudiante/{estudianteId}/fecha

Obtiene todas las asistencias de un estudiante en un rango de fechas.

**Parámetros de Ruta:**
- estudianteId: ID del estudiante (Long)

**Parámetros de Consulta:**
- fechaInicio: Fecha inicial del rango (YYYY-MM-DD)
- fechaFin: Fecha final del rango (YYYY-MM-DD)

**Respuesta:**
- Código: 200 OK
- Cuerpo: Array de asistencias
- Código: 404 NOT FOUND (si el estudiante no existe)

## Buscar Asistencias por Curso y Fecha
### GET /api/asistencias/curso/{cursoId}/fecha

Obtiene todas las asistencias de un curso en un rango de fechas.

**Parámetros de Ruta:**
- cursoId: ID del curso (Long)

**Parámetros de Consulta:**
- fechaInicio: Fecha inicial del rango (YYYY-MM-DD)
- fechaFin: Fecha final del rango (YYYY-MM-DD)

**Respuesta:**
- Código: 200 OK
- Cuerpo: Array de asistencias
- Código: 404 NOT FOUND (si el curso no existe)

## Actualizar Asistencia
### PUT /api/asistencias/{id}

Actualiza un registro de asistencia existente.

**Parámetros de Ruta:**
- id: ID de la asistencia a actualizar (Long)

**Cuerpo de la Petición:**
```json
{
    "estudiante": {
        "id": "long"
    },
    "curso": {
        "id": "long"
    },
    "fechaAsistencia": "YYYY-MM-DD",
    "estadoAsistencia": "PRESENTE|AUSENTE|TARDANZA"
}
```

**Respuesta:**
- Código: 200 OK
- Cuerpo: Objeto de asistencia actualizado
- Código: 404 NOT FOUND (si la asistencia no existe)

## Eliminar Asistencia
### DELETE /api/asistencias/{id}

Elimina un registro de asistencia existente.

**Parámetros de Ruta:**
- id: ID de la asistencia a eliminar (Long)

**Respuesta:**
- Código: 204 NO CONTENT
- Código: 404 NOT FOUND (si la asistencia no existe)