package app.linear.platform.u202216448.planning.interfaces.rest.transform;

import app.linear.platform.u202216448.planning.domain.model.aggregates.RoadmapCycle;
import app.linear.platform.u202216448.planning.interfaces.rest.resources.RoadmapCycleResource;

/**
 * Assembler to convert a RoadmapCycle entity to a RoadmapCycleResource.
 *
 * @author Gustavo Alonso Olivares Lao
 */
public class RoadmapCycleResourceFromEntityAssembler {
    /**
     * Converts a RoadmapCycle entity to a RoadmapCycleResource.
     *
     * @param entity The {@link RoadmapCycle} entity to convert.
     * @return The {@link RoadmapCycleResource} resource that results from the conversion.
     */
    public static RoadmapCycleResource toResourceFromEntity(RoadmapCycle entity) {
        return new RoadmapCycleResource(
                entity.getId(),
                entity.getCycleCode().code(),
                entity.getTeamId().value().toString(),
                entity.getCycleWindow().startDate().toString(),
                entity.getCycleWindow().endDate().toString(),
                entity.getCapacityBudget().amount(),
                entity.getCapacityBudget().unit(),
                entity.getTargetVelocity(),
                entity.getStatusName(),
                entity.getReleaseNotes());
    }
}
