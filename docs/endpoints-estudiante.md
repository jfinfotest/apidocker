# Documentación de Endpoints de Estudiante

## Índice

- [Crear Estudiante](#crear-estudiante)
- [Obtener Estudiantes](#obtener-estudiantes)
- [Obtener Estudiante por ID](#obtener-estudiante-por-id)
- [Buscar Estudiante por Email](#buscar-estudiante-por-email)
- [Actualizar Estudiante](#actualizar-estudiante)
- [Eliminar Estudiante](#eliminar-estudiante)

## Crear Estudiante
### POST /api/estudiantes

Crea un nuevo estudiante en el sistema.

**Cuerpo de la Petición:**
```json
{
    "nombre": "string",
    "apellido": "string",
    "email": "string"
}
```

**Respuesta:**
- Código: 201 CREATED
- Cuerpo: Objeto del estudiante creado
- Código: 409 CONFLICT (si el email ya existe)

## Obtener Estudiantes
### GET /api/estudiantes

Obtiene todos los estudiantes registrados.

**Respuesta:**
- Código: 200 OK
- Cuerpo: Array de estudiantes

## Obtener Estudiante por ID
### GET /api/estudiantes/{id}

Obtiene un estudiante específico por su ID.

**Parámetros de Ruta:**
- id: ID del estudiante (Long)

**Respuesta:**
- Código: 200 OK
- Cuerpo: Objeto del estudiante
- Código: 404 NOT FOUND (si el estudiante no existe)

## Buscar Estudiante por Email
### GET /api/estudiantes/email/{email}

Busca un estudiante por su dirección de email.

**Parámetros de Ruta:**
- email: Email del estudiante (String)

**Respuesta:**
- Código: 200 OK
- Cuerpo: Objeto del estudiante
- Código: 404 NOT FOUND (si no se encuentra el estudiante)

## Actualizar Estudiante
### PUT /api/estudiantes/{id}

Actualiza la información de un estudiante existente.

**Parámetros de Ruta:**
- id: ID del estudiante a actualizar (Long)

**Cuerpo de la Petición:**
```json
{
    "nombre": "string",
    "apellido": "string",
    "email": "string"
}
```

**Respuesta:**
- Código: 200 OK
- Cuerpo: Objeto del estudiante actualizado
- Código: 404 NOT FOUND (si el estudiante no existe)

## Eliminar Estudiante
### DELETE /api/estudiantes/{id}

Elimina un estudiante existente.

**Parámetros de Ruta:**
- id: ID del estudiante a eliminar (Long)

**Respuesta:**
- Código: 204 NO CONTENT
- Código: 404 NOT FOUND (si el estudiante no existe)