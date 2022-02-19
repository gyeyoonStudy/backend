package BE.boted.domain.task.model.repository;

import BE.boted.domain.project.model.entity.Project;
import BE.boted.domain.task.model.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {

    public List<Task> findAllByProject(Project project);
}
