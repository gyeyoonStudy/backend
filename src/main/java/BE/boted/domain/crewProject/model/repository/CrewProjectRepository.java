package BE.boted.domain.crewProject.model.repository;


import BE.boted.domain.crewProject.model.entity.CrewProject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CrewProjectRepository extends JpaRepository<CrewProject,Long> {
}
