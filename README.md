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

## Patrón

POM Utilizando la anotación de @FindBy de Page Factory

## Reglas generales

- Están prohibidos los comentarios en el código

- se debe generar código limpio

- Se debe usar Gherkin para la generación de escenario, el escenario se escribir en lenguaje Gherkin usando las palabras claves en Inglés: Feature', 'Scenario', 'Given', 'When', 'Then', 'And', 'But'.

## Estructura de carpetas

Crea el arquetipo de automatizadas utilizando el patrón POM implementando la anotación de @FindBy de Page Factory

La estructura de carpetas es la siguiente
src/test
└── java
└── com
└── banco
├── hooks        → crear .gitkeep
├── questions    → crear .gitkeep
├── runners      → crear .gitkeep
├── stepdefinitions → crear .gitkeep
├── tasks        → crear .gitkeep
├── ui           → crear .gitkeep ← Page Objects aquí
└── util         → crear .gitkeep
└── resources
└── features
└── registro.feature → crear este archivo con un ejemplo básico en Gherkin
