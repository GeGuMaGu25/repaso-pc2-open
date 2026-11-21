package app.linear.platform.u202216448.planning.application.commandservices;

import app.linear.platform.u202216448.planning.domain.model.aggregates.RoadmapCycle;
import app.linear.platform.u202216448.planning.domain.model.commands.CreateRoadmapCycleCommand;
import app.linear.platform.u202216448.shared.application.result.ApplicationError;
import app.linear.platform.u202216448.shared.application.result.Result;

/**
 * Application service contract for commands over the {@link RoadmapCycle} aggregate.
 *
 * @author Gustavo Alonso Olivares Lao
 */
public interface RoadmapCycleCommandService {
    /**
     * Handles roadmap cycle creation.
     *
     * @param command command containing initial roadmap cycle data
     * @return created roadmap cycle identifier or an application error
     * @see CreateRoadmapCycleCommand
     */
    Result<Long, ApplicationError> handle(CreateRoadmapCycleCommand command);
}
