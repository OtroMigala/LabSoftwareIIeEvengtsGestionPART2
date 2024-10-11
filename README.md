# Sistema de Gestión de Eventos Académicos

Este proyecto es una API REST para gestionar eventos académicos, incluyendo la asignación de chairs y comités de programa.

## Requisitos

- Java 21
- Maven 3.8+
- Spring Boot 3.1.5

## Configuración

1. Clonar el repositorio:

   git clone [https://github.com/OtroMigala/LabSoftwareIIeEvengtsGestionPART2](https://github.com/OtroMigala/LabSoftwareIIeEvengtsGestionPART2)
   
3. Navegar al directorio del proyecto:
   
  cd eventos-academicos

3. Compilar el proyecto:
   
   mvn clean install

## Ejecución

Para iniciar la aplicación, ejecuta:

mvn spring-boot:run

La aplicación estará disponible en `http://localhost:8090`.

## Endpoints principales

- Crear un evento: `POST /events`
- Obtener un evento: `GET /events/{id}`
- Obtener el comité de un evento: `GET /events/{id}/committee`

## Pruebas

Para ejecutar las pruebas unitarias:  

mvn test

## Estructura del proyecto

- `src/main/java/co/edu/unicauca/events`: Código fuente principal
  - `domain`: Entidades de dominio
  - `dao`: Interfaces de repositorio
  - `services`: Lógica de negocio
  - `presentation`: Controladores REST
- `src/test/java`: Pruebas unitarias

## Diagramas

Los diagramas de arquitectura, clases y secuencia se encuentran en la carpeta `Docs&Captures`.

##Pruebas Unitarias exitosas:

Aquí las pruebas unitarias exitosas del proyecto `Docs&Captures`


## Contribuir

Si deseas contribuir al proyecto, por favor crea un fork y envía un pull request con tus cambios.

## Licencia

Este proyecto está bajo la licencia MIT. Ver el archivo `LICENSE` para más detalles.
