# Documentación de Endpoints de Curso
## Índice

- [Crear Curso](#crear-curso)
- [Obtener Cursos](#obtener-cursos)
- [Obtener Curso por ID](#obtener-curso-por-id)
- [Buscar Cursos por Nombre](#buscar-cursos-por-nombre)
- [Actualizar Curso](#actualizar-curso)
- [Eliminar Curso](#eliminar-curso)

## Crear Curso
### POST /api/cursos

Crea un nuevo curso.

**Cuerpo de la Petición:**
```json
{
    "nombreCurso": "string",
    "fechaInicio": "YYYY-MM-DD",
    "fechaFin": "YYYY-MM-DD"
}
```

**Respuesta:**
- Código: 201 CREATED
- Cuerpo: Objeto del curso creado

## Obtener Cursos
### GET /api/cursos

Obtiene todos los cursos registrados.

**Respuesta:**
- Código: 200 OK
- Cuerpo: Array de cursos

## Obtener Curso por ID
### GET /api/cursos/{id}

Obtiene un curso específico por su ID.

**Parámetros de Ruta:**
- id: ID del curso (Long)

**Respuesta:**
- Código: 200 OK
- Cuerpo: Objeto del curso
- Código: 404 NOT FOUND (si el curso no existe)

## Buscar Cursos por Nombre
### GET /api/cursos/nombre/{nombre}

Busca cursos que contengan el nombre especificado (búsqueda no sensible a mayúsculas/minúsculas).

**Parámetros de Ruta:**
- nombre: Nombre del curso a buscar (String)

**Respuesta:**
- Código: 200 OK
- Cuerpo: Array de cursos que coinciden con el criterio de búsqueda
- Código: 404 NOT FOUND (si no se encuentran cursos)

## Actualizar Curso
### PUT /api/cursos/{id}

Actualiza la información de un curso existente.

**Parámetros de Ruta:**
- id: ID del curso a actualizar (Long)

**Cuerpo de la Petición:**
```json
{
    "nombreCurso": "string",
    "fechaInicio": "YYYY-MM-DD",
    "fechaFin": "YYYY-MM-DD"
}
```

**Respuesta:**
- Código: 200 OK
- Cuerpo: Objeto del curso actualizado
- Código: 404 NOT FOUND (si el curso no existe)

## Eliminar Curso
### DELETE /api/cursos/{id}

Elimina un curso existente.

**Parámetros de Ruta:**
- id: ID del curso a eliminar (Long)

**Respuesta:**
- Código: 204 NO CONTENT
- Código: 404 NOT FOUND (si el curso no existe)