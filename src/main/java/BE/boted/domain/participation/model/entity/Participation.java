package BE.boted.domain.participation.model.entity;

import BE.boted.domain.Period;
import BE.boted.domain.crew.model.entity.Crew;
import BE.boted.domain.invitation.model.entity.InvitationStatus;
import BE.boted.domain.project.model.entity.Project;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
public class Participation extends Period {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "crew_id")
    private Crew crew;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "project_id")
    private Project project;


    public Participation(Crew crew, Project project) {
        this.crew = crew;
        crew.getParticipations().add(this);
        this.project = project;
        project.getParticipations().add(this);

    }

    public void delete() {
        this.crew.getParticipations().remove(this);
        this.project.getParticipations().remove(this);
    }
}
