package BE.boted.domain.crew.model.repository;


import BE.boted.domain.crew.model.entity.Crew;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CrewRepository extends JpaRepository<Crew,Long> {
}
