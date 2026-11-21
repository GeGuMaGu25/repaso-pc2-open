package app.linear.platform.u202216448.planning.infrastructure.persistence.jpa.adapters;

import app.linear.platform.u202216448.planning.domain.model.aggregates.RoadmapCycle;
import app.linear.platform.u202216448.planning.domain.model.valueobjects.CycleCode;
import app.linear.platform.u202216448.planning.domain.repositories.RoadmapCycleRepository;
import app.linear.platform.u202216448.planning.infrastructure.persistence.jpa.assemblers.RoadmapCyclePersistenceAssembler;
import app.linear.platform.u202216448.planning.infrastructure.persistence.jpa.repositories.RoadmapCyclePersistenceRepository;
import app.linear.platform.u202216448.shared.infrastructure.events.DomainEventPublisher;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Repository adapter that bridges the roadmap cycle domain repository port with Spring Data JPA.
 *
 * @author Gustavo Alonso Olivares Lao
 */
@Repository
public class RoadmapCycleRepositoryImpl implements RoadmapCycleRepository {

    private final RoadmapCyclePersistenceRepository roadmapCyclePersistenceRepository;
    private final DomainEventPublisher domainEventPublisher;

    public RoadmapCycleRepositoryImpl(
            RoadmapCyclePersistenceRepository roadmapCyclePersistenceRepository,
            DomainEventPublisher domainEventPublisher) {
        this.roadmapCyclePersistenceRepository = roadmapCyclePersistenceRepository;
        this.domainEventPublisher = domainEventPublisher;
    }

    @Override
    public Optional<RoadmapCycle> findById(Long id) {
        return roadmapCyclePersistenceRepository.findById(id).map(RoadmapCyclePersistenceAssembler::toDomainFromPersistence);
    }

    @Override
    public RoadmapCycle save(RoadmapCycle roadmapCycle) {
        var saved = roadmapCyclePersistenceRepository.save(RoadmapCyclePersistenceAssembler.toPersistenceFromDomain(roadmapCycle));
        var savedRoadmapCycle = RoadmapCyclePersistenceAssembler.toDomainFromPersistence(saved);
        domainEventPublisher.publishAndClearEvents(roadmapCycle);
        return savedRoadmapCycle;
    }

    @Override
    public boolean existsByCycleCode(CycleCode cycleCode) {
        return roadmapCyclePersistenceRepository.existsByCycleCode(cycleCode);
    }
}
