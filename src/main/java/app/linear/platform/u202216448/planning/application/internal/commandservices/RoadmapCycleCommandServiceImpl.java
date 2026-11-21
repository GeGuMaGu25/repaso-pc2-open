package app.linear.platform.u202216448.planning.application.internal.commandservices;

import app.linear.platform.u202216448.planning.application.commandservices.RoadmapCycleCommandService;
import app.linear.platform.u202216448.planning.domain.model.aggregates.RoadmapCycle;
import app.linear.platform.u202216448.planning.domain.model.commands.CreateRoadmapCycleCommand;
import app.linear.platform.u202216448.planning.domain.repositories.RoadmapCycleRepository;
import app.linear.platform.u202216448.shared.application.result.ApplicationError;
import app.linear.platform.u202216448.shared.application.result.Result;
import org.springframework.stereotype.Service;

/**
 * Application service that executes roadmap cycle commands.
 *
 * @author Gustavo Alonso Olivares Lao
 */
@Service
public class RoadmapCycleCommandServiceImpl implements RoadmapCycleCommandService {
    private final RoadmapCycleRepository roadmapCycleRepository;

    public RoadmapCycleCommandServiceImpl(RoadmapCycleRepository roadmapCycleRepository) {
        this.roadmapCycleRepository = roadmapCycleRepository;
    }

    @Override
    public Result<Long, ApplicationError> handle(CreateRoadmapCycleCommand command) {
        if (roadmapCycleRepository.existsByCycleCode(command.cycleCode()))
            return Result.failure(ApplicationError.conflict("RoadmapCycle", "Roadmap cycle with code '%s' already exists"
                    .formatted(command.cycleCode().code())));
        var roadmapCycle = new RoadmapCycle(command);
        try {
            roadmapCycle = roadmapCycleRepository.save(roadmapCycle);
        } catch (Exception e) {
            return Result.failure(ApplicationError.unexpected("create-roadmap-cycle", e.getMessage()));
        }
        return Result.success(roadmapCycle.getId());
    }
}
