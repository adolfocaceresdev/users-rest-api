Users REST API

API REST para gestión de usuarios desarrollada con Spring Boot, JPA, PostgreSQL, Spring Security, ModelMapper y documentación con OpenAPI/Swagger.

Características:

- CRUD de usuarios
- Validación con Jakarta Validation
- Manejo global de excepciones
- Seguridad básica (Basic Auth)
- Documentación automática con Springdoc OpenAPI
- Script SQL incluido para inicializar la base de datos

Tecnologías:

-  Java 25
- Spring Boot 4
- Spring Data JPA
- Spring Security
- PostgreSQL
- ModelMapper
- Springdoc OpenAPI 3
- Maven
  
Base de datos:

El script SQL se encuentra en:
src/DB/database.sql
Incluye la creación de la tabla y datos de prueba.

Documentación:

- Swagger UI: /swa:gger-ui.html
- OpenAPI JSON: /v3/api-docs
