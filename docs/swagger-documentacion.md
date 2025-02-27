# Guía de Documentación con Swagger/OpenAPI

## Configuración de Swagger/OpenAPI

### Dependencias Requeridas
Para habilitar Swagger/OpenAPI en el proyecto Spring Boot, agrega la siguiente dependencia en el archivo `pom.xml`:

```xml
<dependency>
    <groupId>org.springdoc</groupId>
    <artifactId>springdoc-openapi-starter-webmvc-ui</artifactId>
    <version>2.3.0</version>
</dependency>
```

### Configuración Básica
El proyecto utiliza una clase de configuración personalizada para OpenAPI ubicada en `src/main/java/com/example/pi1/config/OpenApiConfig.java`:

```java
@Configuration
public class OpenApiConfig {
    @Bean
    public OpenAPI openAPI() {
        Server localServer = new Server()
                .url("http://localhost:8080")
                .description("Local Development Server");

        Server productionServer = new Server()
                .url("https://apidocker-pr0d.onrender.com")
                .description("Production Server");

        Contact contact = new Contact()
                .name("Jhon Fredy Guzmán")
                .email("jguzman@cesde.edu.co")
                .url("https://github.com/jhonfre1994");

        License license = new License()
                .name("MIT License")
                .url("https://opensource.org/licenses/MIT");

        Info info = new Info()
                .title("Sistema de Control de Asistencia - CESDE")
                .version("1.0.0")
                .description("API para gestionar la asistencia de estudiantes")
                .contact(contact)
                .license(license);

        return new OpenAPI()
                .info(info)
                .servers(List.of(productionServer, localServer));
    }
}
```

## Documentación de Endpoints

### Anotaciones Básicas
Para documentar los endpoints, utiliza las siguientes anotaciones:

```java
@Operation(summary = "Crear nuevo estudiante", description = "Crea un nuevo registro de estudiante")
@ApiResponses(value = {
    @ApiResponse(responseCode = "201", description = "Estudiante creado exitosamente"),
    @ApiResponse(responseCode = "400", description = "Datos inválidos")
})
@PostMapping("/estudiantes")
public ResponseEntity<Estudiante> crearEstudiante(@RequestBody Estudiante estudiante) {
    // Implementación
}
```

### Documentación de Modelos
Para documentar los modelos de datos:

```java
@Schema(description = "Modelo de Estudiante")
public class Estudiante {
    @Schema(description = "ID único del estudiante", example = "1")
    private Long id;

    @Schema(description = "Nombre completo del estudiante", example = "Juan Pérez")
    private String nombre;
}
```

## Acceso a la Documentación

### Entorno Local
1. Inicia la aplicación Spring Boot
2. Accede a la documentación en:
   - Swagger UI: `http://localhost:8080/swagger-ui.html`
   - OpenAPI JSON: `http://localhost:8080/v3/api-docs`

### Entorno de Producción
1. La documentación está disponible en:
   - Swagger UI: `https://apidocker-pr0d.onrender.com/swagger-ui.html`
   - OpenAPI JSON: `https://apidocker-pr0d.onrender.com/v3/api-docs`

## Personalización Adicional

### Configuración en application.properties
Puedes personalizar la configuración de Swagger/OpenAPI:

```properties
# Habilitar/deshabilitar Swagger UI
springdoc.swagger-ui.enabled=true

# Personalizar path de Swagger UI
springdoc.swagger-ui.path=/swagger-ui.html

# Ordenar endpoints por HTTP method
springdoc.swagger-ui.operationsSorter=method
```

### Seguridad y Autenticación
Para documentar endpoints protegidos:

```java
@SecurityScheme(
    name = "bearerAuth",
    type = SecuritySchemeType.HTTP,
    scheme = "bearer",
    bearerFormat = "JWT"
)
@SecurityRequirement(name = "bearerAuth")
@RestController
public class SecuredController {
    // Endpoints protegidos
}
```

## Mejores Prácticas

1. **Documentación Clara**:
   - Usa descripciones concisas y claras
   - Incluye ejemplos relevantes
   - Documenta todos los posibles códigos de respuesta

2. **Versionado**:
   - Mantén la documentación actualizada con cada cambio en la API
   - Indica claramente la versión de la API

3. **Ejemplos**:
   - Proporciona ejemplos de request/response
   - Incluye casos de éxito y error

4. **Seguridad**:
   - Documenta los requisitos de autenticación
   - No expongas información sensible

## Solución de Problemas

1. **Swagger UI no carga**:
   - Verifica la dependencia en pom.xml
   - Confirma que la configuración está correcta
   - Revisa los logs de la aplicación

2. **Documentación incompleta**:
   - Asegúrate de usar las anotaciones correctamente
   - Verifica que todos los endpoints estén documentados
   - Comprueba que los modelos tengan sus descripciones

## Recursos Adicionales
- [Documentación oficial de springdoc-openapi](https://springdoc.org/)
- [Especificación OpenAPI](https://swagger.io/specification/)
- [Guía de anotaciones de Swagger](https://swagger.io/docs/specification/annotation-overview/)