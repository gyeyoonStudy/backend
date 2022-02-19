package BE.boted.domain.invitation.model.entity;


import BE.boted.domain.Period;
import BE.boted.domain.crew.model.entity.Crew;
import BE.boted.domain.project.model.entity.Project;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
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

    public Invitation(Crew crew, Project project) {

        //setCrew
        this.crew = crew;
        crew.getInvitations().add(this);

        //setProject
        this.project = project;
        project.getInvitations().add(this);

        //setBasic
        this.status = InvitationStatus.WAIT;
    }

//    public void setCrew(Crew crew) {
//        this.crew = crew;
//        crew.getInvitations().add(this);
//    }
//
//    public void setProject(Project project) {
//        this.project = project;
//        project.getInvitations().add(this);
//    }
//
//    public void setBasic() {
//        this.status = InvitationStatus.WAIT;
//    }

    public Long accept(){
        this.crew.getInvitations().remove(this);
        this.project.getInvitations().remove(this);
        return project.getId();
    }

//    public Long refuse() {
//        this.status = InvitationStatus.REFUSE;
//        return this.id;
//    }

    public void refuse() {
        this.crew.getInvitations().remove(this);
        this.project.getInvitations().remove(this);
    }
}
