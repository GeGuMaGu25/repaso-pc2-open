package app.linear.platform.u202216448.planning.interfaces.rest.resources;

import io.swagger.v3.oas.annotations.media.Schema;

import java.math.BigDecimal;

/**
 * Roadmap cycle resource.
 *
 * @author Gustavo Alonso Olivares Lao
 */
@Schema(
    name = "RoadmapCycleResponse",
    description = "Roadmap cycle information response",
    example = "{\"id\": 1, \"cycleCode\": \"CYCLE-2026-Q4-01\", \"teamId\": \"123e4567-e89b-12d3-a456-426614174000\", \"cycleWindowStartDate\": \"2026-11-23\", \"cycleWindowEndDate\": \"2026-12-07\", \"capacityBudgetAmount\": 120.5, \"capacityBudgetUnit\": \"story points\", \"targetVelocity\": 40, \"status\": \"PLANNED\", \"releaseNotes\": \"Initial roadmap cycle for the Q4 release\"}"
)
public record RoadmapCycleResource(
    @Schema(description = "Roadmap cycle unique identifier", example = "1")
    Long id,

    @Schema(description = "Unique roadmap cycle code", example = "CYCLE-2026-Q4-01")
    String cycleCode,

    @Schema(description = "Team identifier from another bounded context", example = "123e4567-e89b-12d3-a456-426614174000")
    String teamId,

    @Schema(description = "Cycle window start date", example = "2026-11-23")
    String cycleWindowStartDate,

    @Schema(description = "Cycle window end date", example = "2026-12-07")
    String cycleWindowEndDate,

    @Schema(description = "Capacity budget amount", example = "120.5")
    BigDecimal capacityBudgetAmount,

    @Schema(description = "Capacity budget unit", example = "story points")
    String capacityBudgetUnit,

    @Schema(description = "Target velocity", example = "40")
    Integer targetVelocity,

    @Schema(description = "Cycle status", example = "PLANNED")
    String status,

    @Schema(description = "Release notes", example = "Initial roadmap cycle for the Q4 release")
    String releaseNotes
) {
}
