package BE.boted.domain.crewTask.model.entity;


import BE.boted.domain.crew.model.entity.Crew;
import BE.boted.domain.task.model.entity.Task;

import javax.persistence.*;

@Entity
public class CrewTask {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "crew_id")
    private Crew crew;

    @ManyToOne
    @JoinColumn(name = "task_id")
    private Task task;

}
