package BE.boted.domain.task.model.entity;

import BE.boted.domain.CreatedUpdatedAtEntity;
import BE.boted.domain.crewTask.model.entity.CrewTask;
import BE.boted.domain.project.model.entity.Project;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Task extends CreatedUpdatedAtEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;

    @OneToMany(mappedBy = "task")
    private List<CrewTask> crewTasks = new ArrayList<>();

    private String name;

    private String description;

    @Enumerated(EnumType.STRING)
    private TaskStatus status;

    private Long userAmount;

    private LocalDateTime doneDate;


}
