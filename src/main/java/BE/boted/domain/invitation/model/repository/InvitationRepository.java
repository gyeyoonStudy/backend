package BE.boted.domain.invitation.model.repository;


import BE.boted.domain.crew.model.entity.Crew;
import BE.boted.domain.invitation.model.entity.Invitation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


public interface InvitationRepository extends JpaRepository<Invitation,Long> {

    public List<Invitation> findAllByCrew(Crew crew);
}
