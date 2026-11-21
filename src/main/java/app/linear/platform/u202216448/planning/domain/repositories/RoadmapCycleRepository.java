package app.linear.platform.u202216448.planning.domain.repositories;

import app.linear.platform.u202216448.planning.domain.model.aggregates.RoadmapCycle;
import app.linear.platform.u202216448.planning.domain.model.valueobjects.CycleCode;

import java.util.Optional;

/**
 * Roadmap cycle repository port.
 *
 * @author Gustavo Alonso Olivares Lao
 */
public interface RoadmapCycleRepository {
    Optional<RoadmapCycle> findById(Long id);

    RoadmapCycle save(RoadmapCycle roadmapCycle);

    boolean existsByCycleCode(CycleCode cycleCode);
}
