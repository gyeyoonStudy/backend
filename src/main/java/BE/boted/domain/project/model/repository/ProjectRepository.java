package BE.boted.domain.project.model.repository;


import BE.boted.domain.project.model.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface ProjectRepository extends JpaRepository<Project, Long> {


}
