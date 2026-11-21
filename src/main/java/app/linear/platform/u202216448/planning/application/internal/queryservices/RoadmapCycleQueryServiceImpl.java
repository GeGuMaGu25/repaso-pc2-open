package app.linear.platform.u202216448.planning.application.internal.queryservices;

import app.linear.platform.u202216448.planning.application.queryservices.RoadmapCycleQueryService;
import app.linear.platform.u202216448.planning.domain.model.aggregates.RoadmapCycle;
import app.linear.platform.u202216448.planning.domain.model.queries.GetRoadmapCycleByIdQuery;
import app.linear.platform.u202216448.planning.domain.repositories.RoadmapCycleRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Application service that resolves roadmap cycle read queries.
 *
 * @author Gustavo Alonso Olivares Lao
 */
@Service
public class RoadmapCycleQueryServiceImpl implements RoadmapCycleQueryService {
    private final RoadmapCycleRepository roadmapCycleRepository;

    public RoadmapCycleQueryServiceImpl(RoadmapCycleRepository roadmapCycleRepository) {
        this.roadmapCycleRepository = roadmapCycleRepository;
    }

    @Override
    public Optional<RoadmapCycle> handle(GetRoadmapCycleByIdQuery query) {
        return roadmapCycleRepository.findById(query.id());
    }
}
