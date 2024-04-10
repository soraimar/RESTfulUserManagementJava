# RESTfulUserManagementJava

This is a simple REST API that allows users to create users. The API is built using Java with Spring Boot, and uses an in-memory database (H2) to store the user data.

## Requirements
- Java 17
- Spring Boot 3.2.4
- Gradle

## Database
in-memory database (H2) to store the user data. The database schema is created automatically when the application starts. The schema is defined in the file:
```
src/main/resources/schema.sql
```

## Running the API
To run the API, execute the following command in the root directory of the project:

Limpiar el proyecto (opcional):
```
./gradlew clean
```
Construir el proyecto: Este paso compila tu proyecto y crea el JAR ejecutable.
```
./gradlew build
```
Ejecutar la aplicación: Para iniciar la aplicación Spring Boot, se utilizar el comando bootRun que ejecuta el proyecto como una aplicación.
```
gradle bootRun
```

Ejecutar test:
```
./gradlew test
```

## Diagram

![Diagrama de Flujo](http://www.plantuml.com/plantuml/dpng/ZP4_ImD14CNx-nIFgxImiKmXyOzei0bYx8VT5rYpjnDtve9-UozdWY68fZcEdT-RWT-RcalrlikDhL9PIvKEvf-PmxUcC4x64QeQcwQzpOd5sUBY2kqppN4zdxKJt9TD4aHnDKIYjrvgKcmtmbWHAYLg8y7JHfm7sURdztZf0mkhOB6OtM7-T2BueYkMFzXNoIaAbbexSGKxIVb__BtdDmgZe2yfw77eHafGHEuid3rUdW_vEQibSu9vRwNv5Jq-lDWfbDn9ODdQYpp1txwX2ORtjPP8B7F_fk17ShNjsR6DaBGSLXMqm4TtKvOu5Fy5)

<details>
<summary>Código PlantUML (Haz clic para expandir)</summary>

```plantuml
@startuml
skinparam style strictuml

skin rose

"Cliente" -> "Rest API": Envia datos de usuario para ser creado
activate "Rest API"
"Rest API" -> "Rest API": Genera UUID PK
"Rest API" -> "Rest API": Genera UUID Token
"Rest API" -> "Rest API": Valida formato email
"Rest API" -> "Rest API": Valida que email sea unico
"Rest API" -> "Banco de datos (H2)": Persiste el usuario
"Banco de datos (H2)" -> "Rest API": Usuario almacenado
deactivate "Rest API"
"Rest API" -> "Cliente": Responde flujo exitoso de creacion de usuario con token
@enduml
```
</details>

