package app.linear.platform.u202216448.planning.interfaces.rest.resources;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * Create roadmap cycle resource.
 *
 * @author Gustavo Alonso Olivares Lao
 */
@Schema(
    name = "CreateRoadmapCycleRequest",
    description = "Request payload for creating a new roadmap cycle",
    example = "{\"cycleCode\": \"CYCLE-2026-Q4-01\", \"teamId\": \"123e4567-e89b-12d3-a456-426614174000\", \"cycleWindowStartDate\": \"2026-11-23\", \"cycleWindowEndDate\": \"2026-12-07\", \"capacityBudgetAmount\": 120.5, \"capacityBudgetUnit\": \"story points\", \"targetVelocity\": 40, \"status\": \"PLANNED\", \"releaseNotes\": \"Initial roadmap cycle for the Q4 release\"}"
)
public record CreateRoadmapCycleResource(
    @NotBlank(message = "{validation.not-blank}")
    @Schema(description = "Unique roadmap cycle code", example = "CYCLE-2026-Q4-01")
    String cycleCode,

    @NotBlank(message = "{validation.not-blank}")
    @Schema(description = "Team identifier from another bounded context (UUID)", example = "123e4567-e89b-12d3-a456-426614174000")
    String teamId,

    @NotNull(message = "{validation.not-null}")
    @Schema(description = "Cycle window start date (yyyy-MM-dd)", example = "2026-11-23")
    LocalDate cycleWindowStartDate,

    @NotNull(message = "{validation.not-null}")
    @Schema(description = "Cycle window end date (yyyy-MM-dd). It must be after the start date", example = "2026-12-07")
    LocalDate cycleWindowEndDate,

    @NotNull(message = "{validation.not-null}")
    @Schema(description = "Capacity budget amount. It must be greater than zero", example = "120.5")
    BigDecimal capacityBudgetAmount,

    @NotBlank(message = "{validation.not-blank}")
    @Schema(description = "Capacity budget unit", example = "story points")
    String capacityBudgetUnit,

    @NotNull(message = "{validation.not-null}")
    @Schema(description = "Target velocity. It must be a positive integer greater than 0", example = "40")
    Integer targetVelocity,

    @Schema(description = "Cycle status. PLANNED by default", example = "PLANNED", allowableValues = {"PLANNED", "ACTIVE", "COMPLETED", "CANCELLED"}, nullable = true)
    String status,

    @Schema(description = "Release notes. Optional", example = "Initial roadmap cycle for the Q4 release", nullable = true)
    String releaseNotes
) {
}
