package BE.boted.domain.crew.model.entity;

import BE.boted.domain.CreatedUpdatedAtEntity;
import BE.boted.domain.crewProject.model.entity.CrewProject;
import BE.boted.domain.crewTask.model.entity.CrewTask;
import BE.boted.domain.invite.model.entity.Invite;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Crew extends CreatedUpdatedAtEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String email;

    @OneToMany(mappedBy = "crew")
    private List<CrewProject> crewProjects = new ArrayList<>();

    @OneToMany(mappedBy = "crew")
    private List<CrewTask> crewTasks = new ArrayList<>();

    @OneToOne
    @JoinColumn(name = "invite")
    private Invite invite;
}
