package app.linear.platform.u202216448.planning.infrastructure.persistence.jpa.assemblers;

import app.linear.platform.u202216448.planning.domain.model.aggregates.RoadmapCycle;
import app.linear.platform.u202216448.planning.infrastructure.persistence.jpa.entities.RoadmapCyclePersistenceEntity;
import app.linear.platform.u202216448.shared.domain.model.valueobjects.CapacityBudget;
import app.linear.platform.u202216448.shared.domain.model.valueobjects.CycleWindow;
import app.linear.platform.u202216448.shared.infrastructure.persistence.jpa.embeddables.CapacityBudgetPersistenceEmbeddable;
import app.linear.platform.u202216448.shared.infrastructure.persistence.jpa.embeddables.CycleWindowPersistenceEmbeddable;

/**
 * Static assembler between roadmap cycle domain and persistence representations.
 *
 * @author Gustavo Alonso Olivares Lao
 */
public final class RoadmapCyclePersistenceAssembler {

    private RoadmapCyclePersistenceAssembler() {
    }

    public static RoadmapCycle toDomainFromPersistence(RoadmapCyclePersistenceEntity entity) {
        if (entity == null) return null;
        return RoadmapCycle.reconstitute(
                entity.getId(),
                entity.getCycleCode(),
                entity.getTeamId(),
                toDomainFromPersistence(entity.getCycleWindow()),
                toDomainFromPersistence(entity.getCapacityBudget()),
                entity.getTargetVelocity(),
                entity.getStatus(),
                entity.getReleaseNotes());
    }

    public static RoadmapCyclePersistenceEntity toPersistenceFromDomain(RoadmapCycle roadmapCycle) {
        if (roadmapCycle == null) return null;

        var entity = new RoadmapCyclePersistenceEntity();
        // Only set ID if the roadmap cycle is being updated (has a non-null ID)
        // For new roadmap cycles, leave ID null to allow JPA to generate it
        if (roadmapCycle.getId() != null) {
            entity.setId(roadmapCycle.getId());
        }
        entity.setCycleCode(roadmapCycle.getCycleCode());
        entity.setTeamId(roadmapCycle.getTeamId());
        entity.setCycleWindow(toPersistenceFromDomain(roadmapCycle.getCycleWindow()));
        entity.setCapacityBudget(toPersistenceFromDomain(roadmapCycle.getCapacityBudget()));
        entity.setTargetVelocity(roadmapCycle.getTargetVelocity());
        entity.setStatus(roadmapCycle.getStatus());
        entity.setReleaseNotes(roadmapCycle.getReleaseNotes());
        return entity;
    }

    private static CycleWindow toDomainFromPersistence(CycleWindowPersistenceEmbeddable value) {
        return value == null ? null : new CycleWindow(value.getStartDate(), value.getEndDate());
    }

    private static CapacityBudget toDomainFromPersistence(CapacityBudgetPersistenceEmbeddable value) {
        return value == null ? null : new CapacityBudget(value.getAmount(), value.getUnit());
    }

    private static CycleWindowPersistenceEmbeddable toPersistenceFromDomain(CycleWindow value) {
        return value == null ? null : new CycleWindowPersistenceEmbeddable(value.startDate(), value.endDate());
    }

    private static CapacityBudgetPersistenceEmbeddable toPersistenceFromDomain(CapacityBudget value) {
        return value == null ? null : new CapacityBudgetPersistenceEmbeddable(value.amount(), value.unit());
    }
}
