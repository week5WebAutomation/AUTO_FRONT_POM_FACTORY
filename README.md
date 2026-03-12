# AUTO_FRONT_POM_FACTORY
Automatizacion Front: Patrón POM + Page Factory

# Automatización de pruebas automatizadas para Frontend: Patrón POM + Page Factory

- **IDE** VSCode + Git Hub Copilot
- **Patron** POM 
- **Framework de automatización** Serenity BDD
- **Gestion de dependencias** Gradle
- Test runner para cucumber

## Misión 

Construir un test de pruebas automatizadas para el frontend, asegurando que el proyecto sea limpio, los reportes sean legibles y la arquietectura soprte cambios sin romperse

## Objetivo

Implementar un flujo end to end de automatización de pruebas sobre una aplicación web
**ejecucion de un proceso de reservar la orden en un restaurante**

## Patrón

POM Utilizando la anotación de @FindBy de Page Factory

## Reglas generales

- Están prohibidos los comentarios en el código

- se debe generar código limpio

- Se debe usar Gherkin para la generación de escenario, el escenario se escribir en lenguaje Gherkin usando las palabras claves en Inglés: Feature', 'Scenario', 'Given', 'When', 'Then', 'And', 'But'.

#  ¿Cómo ejecutar este test?

## 1. Descargar el proyecto
Para ejecutar este test, puedes descargar el archivo comprimido ubicada en la raiz de este proyecto

[Sistemas-de-pedidos-restaurante.zip](Sistemas-de-pedidos-restaurante.zip)

Y descomprimirlo en tu entorno local para obtener el proyecto.

*(opcional)*

También tienes la opción de descargarlos directamente de nuestro repositorio

- [Sistema de Pedidos de Restaurante - Frontend](https://github.com/week4Selenium/Restaurant-FrontEnd.git)

- [Sistema de Pedidos de Restaurante - Backend](https://github.com/week4Selenium/Restaurant-Backend.git)

En el enlace [Sistema de Pedidos de Restaurante -Frontend](https://github.com/week4Selenium/Restaurant-FrontEnd.git) encontrarás las descripciones para armar el dockerizado y levantar el proyecto, pero para más practicidad se deja el archivo comprimido.

## 2. Ejecutar el proyecto en tu entorno local

Una vez descargas el proyecto,puedes ejecutar los siguientes pasos segun tu sistema operativo

**Windows (WSL2 + Docker Engine)**

1. Abre PowerShell y ejecuta:
   ```bash
   wsl --install
   ```
2. Dentro de tu distribución WSL (por ejemplo, Ubuntu), instala Docker:
   ```bash
   sudo apt install docker.io docker-compose-v2
   sudo service docker start
   ```

**macOS (Colima)**
Instala Colima y Docker:
   ```bash
   brew install colima docker docker-compose
   colima start
   ```
**Linux (Docker Engine nativo)**
Instala Docker Engine:
   ```bash
   sudo apt install docker-ce docker-ce-cli containerd.io docker-compose-plugin
   ```
Luego, puedes usar los mismos comandos:
```bash
docker compose up --build
```

Para detener stack:

```bash
docker compose down
```

Para detener y limpiar (eliminar volumenes):

```bash
docker compose down -v
```

**url's del stack**
Tras ejecutar `docker compose up`:

- **Frontend cliente**: http://localhost:5173
- **Frontend cocina**: http://localhost:5173/kitchen
- **API Order Service**: http://localhost:8080
- **API Swagger**: http://localhost:8080/swagger-ui.html
- **RabbitMQ UI**: http://localhost:15672 (guest/guest)
- **Kitchen Worker**: http://localhost:8081
- **Report Service**: http://localhost:8082

Para corroborar que en efecto el proyecto está corriendo puedes verificar en el puerto del cliente, debería aparecer el frontend del resturante

## 3. Ejecutar la prueba*

Para ejecutar las pruebas automatizadas con Gradle, sigue las instrucciones según tu sistema operativo:

**Windows**

Abre una terminal (cmd o PowerShell) en la raíz del proyecto y ejecuta:

```
gradlew.bat clean test
```

**macOS / Linux**

Abre una terminal en la raíz del proyecto y ejecuta:

```
./gradlew clean test
```

**Comandos útiles adicionales:**

- Para compilar el proyecto sin ejecutar los tests:
   - Windows: `gradlew.bat build`
   - macOS/Linux: `./gradlew build`

- Para limpiar los archivos generados por Gradle:
   - Windows: `gradlew.bat clean`
   - macOS/Linux: `./gradlew clean`

Al finalizar, los reportes de Serenity estarán disponibles en la carpeta `target/site/serenity/`.

