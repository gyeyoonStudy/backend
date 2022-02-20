package BE.boted.domain.crew.model.repository;


import BE.boted.domain.crew.model.entity.Crew;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


public interface CrewRepository extends JpaRepository<Crew,Long> {
    public Boolean existsByNickname(String nickname);

    public Optional<Crew> findByNickname(String nickname);
}
