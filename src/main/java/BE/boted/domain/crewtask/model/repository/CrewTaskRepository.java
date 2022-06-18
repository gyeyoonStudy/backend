package BE.boted.domain.crewtask.model.repository;

import BE.boted.domain.crewtask.model.entity.CrewTask;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface CrewTaskRepository extends JpaRepository<CrewTask,Long> {

}
