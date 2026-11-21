# Changelog

All notable changes to the **Linear Platform** will be documented in this file.

The format is based on [Keep a Changelog](https://keepachangelog.com/en/1.1.0/),
and this project adheres to [Semantic Versioning](https://semver.org/spec/v2.0.0.html) and [Conventional Commits](https://www.conventionalcommits.org/).

---

## [Unreleased]

### Added
- **Project Setup**: Maven project with Spring Boot 4.1.2, Spring Data JPA, MySQL (`linear` schema), Lombok and SpringDoc OpenAPI, with `dev` and `prod` profiles.
- **Shared Kernel**:
  - `Result` / `ApplicationError` functional error handling and `AbstractDomainAggregateRoot`.
  - `SnakeCaseWithPluralizedTablePhysicalNamingStrategy` and `AuditableAbstractPersistenceEntity` (`created_at`, `updated_at`).
  - `DomainEventPublisher`, virtual threads, i18n (English by default and Spanish) and OpenAPI configuration.
  - RFC 9457 `GlobalExceptionHandler` with localized messages, including malformed request handling.
  - `CycleWindow` and `CapacityBudget` value objects with their persistence embeddables.
- **Planning Bounded Context**:
  - `RoadmapCycle` aggregate root with `CycleCode`, `TeamId` and `CycleStatus` value objects.
  - `CreateRoadmapCycleCommand`, `GetRoadmapCycleByIdQuery`, command and query services with the unique cycle code rule.
  - JPA persistence (`roadmap_cycles` table) with converters, embeddables, assembler and repository adapter.
  - `POST /api/v1/roadmap-cycles` endpoint with OpenAPI documentation.
- **Documentation**: `README.md`, `CONTRIBUTING.md` and `CHANGELOG.md`.
