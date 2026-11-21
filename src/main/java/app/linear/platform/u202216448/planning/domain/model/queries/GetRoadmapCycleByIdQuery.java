package app.linear.platform.u202216448.planning.domain.model.queries;

/**
 * Query to get roadmap cycle by id.
 *
 * @param id The ID of the roadmap cycle to retrieve. Cannot be null or less than or equal to 0.
 * @author Gustavo Alonso Olivares Lao
 */
public record GetRoadmapCycleByIdQuery(Long id) {
    /**
     * Compact constructor for GetRoadmapCycleByIdQuery.
     * Validates that the id is not null and is greater than 0.
     * @throws IllegalArgumentException if id is null or less than or equal to 0.
     */
    public GetRoadmapCycleByIdQuery {
        if (id == null || id <= 0) throw new IllegalArgumentException("Roadmap cycle id is required.");
    }
}
