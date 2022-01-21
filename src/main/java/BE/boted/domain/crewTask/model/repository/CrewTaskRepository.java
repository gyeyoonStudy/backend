package BE.boted.domain.crewTask.model.repository;

import BE.boted.domain.crewTask.model.entity.CrewTask;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CrewTaskRepository extends JpaRepository<CrewTask,Long> {
}
