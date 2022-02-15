package BE.boted.domain.invitation.model.entity;


import BE.boted.domain.Period;
import BE.boted.domain.crew.model.entity.Crew;
import BE.boted.domain.project.model.entity.Project;
import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class Invitation extends Period {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private InvitationStatus status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "crew_id")
    private Crew crew;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "project_id")
    private Project project;

}
