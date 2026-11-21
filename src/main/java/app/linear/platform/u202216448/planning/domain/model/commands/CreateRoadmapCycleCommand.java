package app.linear.platform.u202216448.planning.domain.model.commands;

import app.linear.platform.u202216448.planning.domain.model.valueobjects.CycleCode;
import app.linear.platform.u202216448.planning.domain.model.valueobjects.CycleStatus;
import app.linear.platform.u202216448.planning.domain.model.valueobjects.TeamId;
import app.linear.platform.u202216448.shared.domain.model.valueobjects.CapacityBudget;
import app.linear.platform.u202216448.shared.domain.model.valueobjects.CycleWindow;

/**
 * Command to create a roadmap cycle
 * @param cycleCode the roadmap cycle code.
 *                  Cannot be null
 * @param teamId the identifier of the team that owns the roadmap cycle.
 *               Cannot be null
 * @param cycleWindow the start and end dates of the roadmap cycle.
 *                    Cannot be null
 * @param capacityBudget the capacity budget of the roadmap cycle.
 *                       Cannot be null
 * @param targetVelocity the target velocity of the roadmap cycle.
 *                       Cannot be null, must be greater than 0
 * @param status the roadmap cycle status.
 *               Optional, PLANNED by default
 * @param releaseNotes the release notes of the roadmap cycle.
 *                     Optional
 * @author Gustavo Alonso Olivares Lao
 */
public record CreateRoadmapCycleCommand(
        CycleCode cycleCode,
        TeamId teamId,
        CycleWindow cycleWindow,
        CapacityBudget capacityBudget,
        Integer targetVelocity,
        CycleStatus status,
        String releaseNotes) {

    /**
     * Constructor
     * @throws IllegalArgumentException if cycleCode, teamId, cycleWindow or capacityBudget is null
     * @throws IllegalArgumentException if targetVelocity is null or less than or equal to 0
     */
    public CreateRoadmapCycleCommand {
        if (cycleCode == null) {
            throw new IllegalArgumentException("cycleCode cannot be null");
        }
        if (teamId == null) {
            throw new IllegalArgumentException("teamId cannot be null");
        }
        if (cycleWindow == null) {
            throw new IllegalArgumentException("cycleWindow cannot be null");
        }
        if (capacityBudget == null) {
            throw new IllegalArgumentException("capacityBudget cannot be null");
        }
        if (targetVelocity == null || targetVelocity <= 0) {
            throw new IllegalArgumentException("targetVelocity must be a positive integer greater than 0");
        }
    }
}
