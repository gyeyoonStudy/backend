package BE.boted.domain.invitation.model.repository;


import BE.boted.domain.invitation.model.entity.Invitation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface InvatationRepository extends JpaRepository<Invitation,Long> {
}
