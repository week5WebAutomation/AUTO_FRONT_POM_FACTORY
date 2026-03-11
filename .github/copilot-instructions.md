# Copilot Workspace Instructions

## Project Overview
This project is a frontend test automation suite using the POM (Page Object Model) pattern with Page Factory annotations, built on Serenity BDD and Gradle. Test scenarios are written in Gherkin and executed with Cucumber.

## Key Conventions
- **No comments** are allowed in code.
- Code must be clean and maintainable.
- Gherkin scenarios must use English keywords: `Feature`, `Scenario`, `Given`, `When`, `Then`, `And`, `But`.
- Folder structure follows POM with Page Factory, see README for details.

## Build & Test Commands
- **Build:** `./gradlew build` (or `gradlew.bat build` on Windows)
- **Run tests:** `./gradlew test` (or `gradlew.bat test` on Windows)
- **Serenity reports:** Output in `target/site/serenity/`

## Patterns & Architecture
- Page Objects go in `src/test/java/com/banco/ui`.
- Step definitions in `src/test/java/com/banco/stepdefinitions`.
- Features in `src/test/resources/features`.
- Use `@FindBy` for element location in Page Objects.

## Pitfalls & Environment
- Ensure Java and Gradle are installed and on PATH.
- Serenity and Gradle properties must be configured for your environment.
- Reports are generated after test execution; check `target/site/serenity/`.

## Example Prompts
- "Add a new Page Object for the login page."
- "Generate a Gherkin scenario for user registration."
- "Show the command to run all tests."

---
For advanced customization, see `/create-instruction` or `/create-skill` prompts.