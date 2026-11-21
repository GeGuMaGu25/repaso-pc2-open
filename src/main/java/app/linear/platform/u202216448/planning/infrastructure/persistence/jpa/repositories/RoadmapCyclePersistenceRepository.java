package app.linear.platform.u202216448.planning.infrastructure.persistence.jpa.repositories;

import app.linear.platform.u202216448.planning.domain.model.valueobjects.CycleCode;
import app.linear.platform.u202216448.planning.infrastructure.persistence.jpa.entities.RoadmapCyclePersistenceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Spring Data repository for roadmap cycle persistence entities.
 *
 * @author Gustavo Alonso Olivares Lao
 */
@Repository
public interface RoadmapCyclePersistenceRepository extends JpaRepository<RoadmapCyclePersistenceEntity, Long> {
    boolean existsByCycleCode(CycleCode cycleCode);
}
