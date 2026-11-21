# Contributing to Linear Platform

This guide outlines the architectural standards, coding guidelines, branch strategy, and commit conventions of the **Linear Platform**.

---

## 1. Architecture & Design Principles

The platform is designed as a **Modular Monolith** using **Layered Domain-Driven Design (DDD)**:

- **Bounded Contexts**: All business features reside in dedicated context packages (`planning` or `shared`).
- **Layer Isolation**:
  - `domain`: Contains pure aggregates, value objects, commands, queries, and repository interfaces. Must not depend on Spring or JPA annotations.
  - `application`: Coordinates use cases via Command Services and Query Services.
  - `infrastructure`: Implements persistence adapters (`*RepositoryImpl`), JPA entities (`*PersistenceEntity`), converters, and configurations. Packaging follows `infrastructure.<technology-type>.<manufacturer-technology-name>.configuration`.
  - `interfaces`: REST controllers, resources, and assemblers following `[Target]From[Source]Assembler` naming.
- **Aggregate Encapsulation**: Do NOT use Lombok `@Setter` on aggregates. Provide `reconstitute(...)` static factories for persistence rehydration.
- **Identity Referencing**: Aggregates reference concepts of other bounded contexts by strongly-typed identity value objects (e.g., `TeamId`).
- **Error Handling**: Use `Result<T, ApplicationError>` in the application layer and `ResponseEntityAssembler` in REST controllers to return RFC 9457 `ProblemDetail` responses.

---

## 2. Branch Strategy (Git Flow)

| Branch | Purpose |
|---|---|
| `main` | Production-ready releases. Every merge is tagged with a semantic version (`vX.Y.Z`). |
| `develop` | Integration branch for the next release. |
| `feature/<name>` | New features. Created from `develop` and merged back into `develop` with `--no-ff`. |
| `bugfix/<name>` | Fixes for `develop`. Created from `develop` and merged back into `develop`. |
| `release/<version>` | Release preparation (version bump, changelog). Merged into `main` and `develop`. |
| `hotfix/<version>` | Urgent fixes for `main`. Merged into `main` and `develop`. |

---

## 3. Development Workflow

1. Create a branch from `develop`:
   ```bash
   git checkout -b feature/your-feature-name develop
   ```
2. Build locally:
   ```bash
   mvn clean package
   ```
3. Merge the branch back into `develop` with `--no-ff` and delete it.

---

## 4. Conventional Commits Standard

We adhere to the [Conventional Commits](https://www.conventionalcommits.org/) specification (v1.0.0).

### Commit Format
```text
<type>(<scope>): <short summary>

[optional body]

[optional footer(s)]
```

### Allowed Types
- **`feat`**: A new feature or capability.
- **`fix`**: A bug fix.
- **`refactor`**: A code change that neither fixes a bug nor adds a feature.
- **`docs`**: Documentation only changes.
- **`build`**: Changes to the build system or dependencies.
- **`chore`**: Maintenance tasks.

### Allowed Scopes
- `planning`, `shared`, `config`, `build`

### Examples
- `feat(planning): add roadmap cycle aggregate root and repository port`
- `feat(shared): add cycle window and capacity budget value objects with persistence embeddables`
- `docs: add README with project overview, endpoint, business rules and author`

---

## 5. Versioning

The project follows [Semantic Versioning](https://semver.org/spec/v2.0.0.html) (`MAJOR.MINOR.PATCH`). Changes are documented in [CHANGELOG.md](CHANGELOG.md) following [Keep a Changelog](https://keepachangelog.com/en/1.1.0/).
