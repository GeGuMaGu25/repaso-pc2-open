package app.linear.platform.u202216448.planning.application.queryservices;

import app.linear.platform.u202216448.planning.domain.model.aggregates.RoadmapCycle;
import app.linear.platform.u202216448.planning.domain.model.queries.GetRoadmapCycleByIdQuery;

import java.util.Optional;

/**
 * Application service contract for `roadmap cycle` read queries.
 *
 * @author Gustavo Alonso Olivares Lao
 */
public interface RoadmapCycleQueryService {
    /**
     * Handles retrieval of a roadmap cycle by id.
     *
     * @param query roadmap-cycle-id query
     * @return matching roadmap cycle, if found
     * @see GetRoadmapCycleByIdQuery
     */
    Optional<RoadmapCycle> handle(GetRoadmapCycleByIdQuery query);
}
