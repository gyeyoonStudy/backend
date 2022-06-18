package BE.boted.domain.participation.model.repository;

import BE.boted.domain.crew.model.entity.Crew;
import BE.boted.domain.participation.model.entity.Participation;
import BE.boted.domain.project.model.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ParticipationRepository extends JpaRepository<Participation, Long> {

    public List<Participation> findAllByCrew(Crew crew);

    public Optional<Participation> findByCrewAAndProject(Crew crew, Project project);
}
