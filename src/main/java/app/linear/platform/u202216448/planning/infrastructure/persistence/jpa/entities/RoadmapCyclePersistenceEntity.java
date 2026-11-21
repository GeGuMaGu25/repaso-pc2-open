package app.linear.platform.u202216448.planning.infrastructure.persistence.jpa.entities;

import app.linear.platform.u202216448.planning.domain.model.valueobjects.CycleCode;
import app.linear.platform.u202216448.planning.domain.model.valueobjects.CycleStatus;
import app.linear.platform.u202216448.planning.domain.model.valueobjects.TeamId;
import app.linear.platform.u202216448.planning.infrastructure.persistence.jpa.converters.CycleCodePersistenceConverter;
import app.linear.platform.u202216448.planning.infrastructure.persistence.jpa.converters.TeamIdPersistenceConverter;
import app.linear.platform.u202216448.shared.infrastructure.persistence.jpa.embeddables.CapacityBudgetPersistenceEmbeddable;
import app.linear.platform.u202216448.shared.infrastructure.persistence.jpa.embeddables.CycleWindowPersistenceEmbeddable;
import app.linear.platform.u202216448.shared.infrastructure.persistence.jpa.entities.AuditableAbstractPersistenceEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * JPA persistence entity for roadmap cycles.
 *
 * @author Gustavo Alonso Olivares Lao
 */
@Entity
@Table(name = "roadmap_cycles")
@Getter
@Setter
@NoArgsConstructor
public class RoadmapCyclePersistenceEntity extends AuditableAbstractPersistenceEntity {

    @Convert(converter = CycleCodePersistenceConverter.class)
    @Column(nullable = false, unique = true)
    private CycleCode cycleCode;

    @Convert(converter = TeamIdPersistenceConverter.class)
    @Column(nullable = false, length = 36)
    private TeamId teamId;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "startDate", column = @Column(name = "cycle_window_start_date", nullable = false)),
            @AttributeOverride(name = "endDate", column = @Column(name = "cycle_window_end_date", nullable = false))})
    private CycleWindowPersistenceEmbeddable cycleWindow;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "amount", column = @Column(name = "capacity_budget_amount", nullable = false)),
            @AttributeOverride(name = "unit", column = @Column(name = "capacity_budget_unit", nullable = false))})
    private CapacityBudgetPersistenceEmbeddable capacityBudget;

    @Column(nullable = false)
    private Integer targetVelocity;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private CycleStatus status;

    @Column(columnDefinition = "TEXT")
    private String releaseNotes;
}
