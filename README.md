# Linear Platform

## Summary

Linear Platform is a RESTful API that supports the operations of [Linear](https://linear.app/), a platform for issue tracking, development cycles and product roadmaps designed for high-performance software teams. It allows teams to plan work cycles with bounded dates, measurable capacity budgets and traceability per initiative.

## Description

The API is built on Domain-Driven Design (DDD) as a modular monolith with a layered architecture (`domain`, `application`, `infrastructure`, `interfaces`) and the CQRS pattern.

### Bounded Contexts

| Bounded context | Responsibility |
|---|---|
| `planning` | Roadmap cycles planned by teams (`RoadmapCycle` aggregate root). |
| `shared` | Shared kernel: base aggregate root, auditable persistence entity, `Result` / `ApplicationError`, RFC 9457 error handling, i18n, OpenAPI, snake case pluralized naming strategy and the `CycleWindow` and `CapacityBudget` value objects. |

### Endpoint

| Method | Path | Description |
|---|---|---|
| `POST` | `/api/v1/roadmap-cycles` | Adds a roadmap cycle. Returns `201 Created` with the created resource, including its generated `id`. |

Request body example:

```json
{
  "cycleCode": "CYCLE-2026-Q4-01",
  "teamId": "123e4567-e89b-12d3-a456-426614174000",
  "cycleWindowStartDate": "2026-11-23",
  "cycleWindowEndDate": "2026-12-07",
  "capacityBudgetAmount": 120.5,
  "capacityBudgetUnit": "story points",
  "targetVelocity": 40,
  "status": "PLANNED",
  "releaseNotes": "Initial roadmap cycle for the Q4 release"
}
```

Error responses follow RFC 9457 (`ProblemDetail`) and are localized in English (default) or Spanish according to the `Accept-Language` header:

- `400 Bad Request`: invalid input data or business rule validation failure.
- `409 Conflict`: a roadmap cycle with the same cycle code already exists.

### Business Rules

- Two roadmap cycles with the same `cycleCode` cannot be registered.
- `cycleCode` is a `CycleCode` value object: a code that cannot be null or blank.
- `teamId` is a `TeamId` value object: a UUID from another bounded context that cannot be null.
- `CycleWindow` (shared kernel) holds `startDate` and `endDate`; the end date must be after the start date. `isActiveOn(targetDate)` returns `true` when the target date is within the window.
- `CapacityBudget` (shared kernel) holds `amount` (greater than zero) and `unit` (not blank). `scaleBy(factor)` multiplies the amount by a factor greater than zero, keeping the unit.
- `targetVelocity` must be a positive integer greater than `0`.
- `status` is one of `PLANNED` (default), `ACTIVE`, `COMPLETED`, `CANCELLED`.
- `releaseNotes` is optional.
- Roadmap cycles are auditable (`created_at`, `updated_at`).

## Technologies

- Java 27
- Spring Boot 4.1.2 (Spring Web, Spring Data JPA, Bean Validation)
- MySQL (schema `linear`)
- Lombok
- SpringDoc OpenAPI (Swagger UI)
- Maven

## Running the Application

1. Start a MySQL server. The `linear` schema is created automatically.
2. Set the database credentials (defaults: `root` / `password`, host `localhost`, port `3306`):

   ```bash
   export DATABASE_USER=root
   export DATABASE_PASSWORD=your-password
   ```

3. Run the application:

   ```bash
   mvn spring-boot:run
   ```

4. Open the API documentation at `http://localhost:8080/swagger-ui/index.html`.

## Author

- **Name:** Gustavo Alonso Olivares Lao
- **Student code:** u202216448
