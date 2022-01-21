package BE.boted.domain.invite.model.entity;

import BE.boted.domain.CreatedAtEntity;
import BE.boted.domain.crew.model.entity.Crew;

import javax.persistence.*;

@Entity
public class Invite extends CreatedAtEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private InviteStatus status;

    @OneToOne(mappedBy = "invite")
    private Crew crew;
}
