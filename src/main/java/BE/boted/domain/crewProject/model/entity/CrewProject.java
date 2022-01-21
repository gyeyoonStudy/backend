package BE.boted.domain.crewProject.model.entity;


import BE.boted.domain.CreatedUpdatedAtEntity;
import BE.boted.domain.crew.model.entity.Crew;
import BE.boted.domain.project.model.entity.Project;

import javax.persistence.*;

@Entity
public class CrewProject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "crew_id")
    private Crew crew;

    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;
}
