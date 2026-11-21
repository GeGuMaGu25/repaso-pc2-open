package app.linear.platform.u202216448.planning.interfaces.rest.transform;

import app.linear.platform.u202216448.planning.domain.model.commands.CreateRoadmapCycleCommand;
import app.linear.platform.u202216448.planning.domain.model.valueobjects.CycleCode;
import app.linear.platform.u202216448.planning.domain.model.valueobjects.CycleStatus;
import app.linear.platform.u202216448.planning.domain.model.valueobjects.TeamId;
import app.linear.platform.u202216448.planning.interfaces.rest.resources.CreateRoadmapCycleResource;
import app.linear.platform.u202216448.shared.domain.model.valueobjects.CapacityBudget;
import app.linear.platform.u202216448.shared.domain.model.valueobjects.CycleWindow;

import java.util.Arrays;
import java.util.UUID;

/**
 * Assembler to convert a CreateRoadmapCycleResource to a CreateRoadmapCycleCommand.
 *
 * @author Gustavo Alonso Olivares Lao
 */
public class CreateRoadmapCycleCommandFromResourceAssembler {
    /**
     * Converts a CreateRoadmapCycleResource to a CreateRoadmapCycleCommand.
     *
     * @param resource The {@link CreateRoadmapCycleResource} resource to convert.
     * @return The {@link CreateRoadmapCycleCommand} command that results from the conversion.
     * @throws IllegalArgumentException if any value object or enumeration value is not valid.
     */
    public static CreateRoadmapCycleCommand toCommandFromResource(CreateRoadmapCycleResource resource) {
        return new CreateRoadmapCycleCommand(
                new CycleCode(resource.cycleCode()),
                new TeamId(toUuid(resource.teamId())),
                new CycleWindow(resource.cycleWindowStartDate(), resource.cycleWindowEndDate()),
                new CapacityBudget(resource.capacityBudgetAmount(), resource.capacityBudgetUnit()),
                resource.targetVelocity(),
                toCycleStatus(resource.status()),
                resource.releaseNotes());
    }

    /**
     * Converts a team id string to a UUID.
     *
     * @param teamId The team id string.
     * @return The UUID, or null if the team id is null.
     * @throws IllegalArgumentException if the team id is not a valid UUID.
     */
    private static UUID toUuid(String teamId) {
        if (teamId == null) return null;
        try {
            return UUID.fromString(teamId);
        } catch (IllegalArgumentException exception) {
            throw new IllegalArgumentException("Team id must be a valid UUID", exception);
        }
    }

    /**
     * Converts a status name to a CycleStatus.
     *
     * @param status The status name.
     * @return The {@link CycleStatus}, or null if the status is not specified.
     * @throws IllegalArgumentException if the status name is not a valid cycle status.
     */
    private static CycleStatus toCycleStatus(String status) {
        if (status == null || status.isBlank()) return null;
        try {
            return CycleStatus.valueOf(status.trim().toUpperCase());
        } catch (IllegalArgumentException exception) {
            throw new IllegalArgumentException("Cycle status must be one of %s"
                    .formatted(Arrays.toString(CycleStatus.values())), exception);
        }
    }
}
