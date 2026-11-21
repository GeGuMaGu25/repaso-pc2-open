package app.linear.platform.u202216448.planning.domain.model.aggregates;

import app.linear.platform.u202216448.planning.domain.model.commands.CreateRoadmapCycleCommand;
import app.linear.platform.u202216448.planning.domain.model.valueobjects.CycleCode;
import app.linear.platform.u202216448.planning.domain.model.valueobjects.CycleStatus;
import app.linear.platform.u202216448.planning.domain.model.valueobjects.TeamId;
import app.linear.platform.u202216448.shared.domain.model.aggregates.AbstractDomainAggregateRoot;
import app.linear.platform.u202216448.shared.domain.model.valueobjects.CapacityBudget;
import app.linear.platform.u202216448.shared.domain.model.valueobjects.CycleWindow;
import lombok.Getter;

import java.util.Objects;

/**
 * RoadmapCycle aggregate root.
 *
 * <p>
 * Represents a work cycle with bounded dates planned by a team in the Linear platform.
 * A roadmap cycle has a measurable capacity budget, a target velocity and a status.
 * When no status is specified, the roadmap cycle starts as PLANNED.
 * </p>
 *
 * @author Gustavo Alonso Olivares Lao
 */
@Getter
public class RoadmapCycle extends AbstractDomainAggregateRoot<RoadmapCycle> {
    /**
     * The unique identifier for the roadmap cycle.
     */
    private Long id;

    /**
     * The unique code of the roadmap cycle.
     */
    private CycleCode cycleCode;

    /**
     * The identifier of the team managed in another bounded context.
     */
    private TeamId teamId;

    /**
     * The start and end dates of the roadmap cycle.
     */
    private CycleWindow cycleWindow;

    /**
     * The capacity budget of the roadmap cycle.
     */
    private CapacityBudget capacityBudget;

    /**
     * The target velocity of the roadmap cycle.
     */
    private Integer targetVelocity;

    /**
     * The current status of the roadmap cycle.
     */
    private CycleStatus status;

    /**
     * The optional release notes of the roadmap cycle.
     */
    private String releaseNotes;

    /**
     * Constructor for RoadmapCycle.
     * Sets the status to PLANNED when no status is specified.
     * @param cycleCode The cycle code.
     * @param teamId The team id.
     * @param cycleWindow The cycle window.
     * @param capacityBudget The capacity budget.
     * @param targetVelocity The target velocity.
     * @param status The status. PLANNED if null.
     * @param releaseNotes The release notes. Optional.
     */
    public RoadmapCycle(
            CycleCode cycleCode,
            TeamId teamId,
            CycleWindow cycleWindow,
            CapacityBudget capacityBudget,
            Integer targetVelocity,
            CycleStatus status,
            String releaseNotes) {
        this.cycleCode = Objects.requireNonNull(cycleCode, "cycleCode is required");
        this.teamId = Objects.requireNonNull(teamId, "teamId is required");
        this.cycleWindow = Objects.requireNonNull(cycleWindow, "cycleWindow is required");
        this.capacityBudget = Objects.requireNonNull(capacityBudget, "capacityBudget is required");
        this.targetVelocity = Objects.requireNonNull(targetVelocity, "targetVelocity is required");
        this.status = status != null ? status : CycleStatus.PLANNED;
        this.releaseNotes = releaseNotes;
    }

    /**
     * Constructor for RoadmapCycle with a CreateRoadmapCycleCommand.
     * @param command The CreateRoadmapCycleCommand.
     */
    public RoadmapCycle(CreateRoadmapCycleCommand command) {
        this(
                command.cycleCode(),
                command.teamId(),
                command.cycleWindow(),
                command.capacityBudget(),
                command.targetVelocity(),
                command.status(),
                command.releaseNotes());
    }

    /**
     * Reconstitutes an existing roadmap cycle from persistence state.
     *
     * @param id The unique identifier.
     * @param cycleCode The cycle code.
     * @param teamId The team id.
     * @param cycleWindow The cycle window.
     * @param capacityBudget The capacity budget.
     * @param targetVelocity The target velocity.
     * @param status The status.
     * @param releaseNotes The release notes.
     * @return The reconstituted RoadmapCycle instance.
     */
    public static RoadmapCycle reconstitute(
            Long id,
            CycleCode cycleCode,
            TeamId teamId,
            CycleWindow cycleWindow,
            CapacityBudget capacityBudget,
            Integer targetVelocity,
            CycleStatus status,
            String releaseNotes) {
        var roadmapCycle = new RoadmapCycle(cycleCode, teamId, cycleWindow, capacityBudget, targetVelocity, status, releaseNotes);
        roadmapCycle.id = id;
        return roadmapCycle;
    }

    /**
     * Gets the status name.
     * @return The status name.
     */
    public String getStatusName() {
        return this.status.name();
    }
}
