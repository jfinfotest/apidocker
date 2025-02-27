package com.example.pi1.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI openAPI() {
        Server localServer = new Server()
                .url("http://localhost:8080")
                .description("Local Development Server");

        Server productionServer = new Server()
                .url("https://tu-app.onrender.com")
                .description("Production Server");

        Contact contact = new Contact()
                .name("Jhon Fredy Valencia Gómez")
                .email("jvalenciago@cesde.net");                

        License license = new License()
                .name("MIT License")
                .url("https://opensource.org/licenses/MIT");

        Info info = new Info()
                .title("Sistema de Control de Asistencia - CESDE")
                .version("1.0.0")
                .description("API desarrollada por Jhon Fredy Valencia Gómez para gestionar la asistencia de estudiantes, cursos y registros de asistencia en CESDE")
                .contact(contact)
                .license(license);

        return new OpenAPI()
                .info(info)
                .servers(List.of(productionServer, localServer));
    }
}