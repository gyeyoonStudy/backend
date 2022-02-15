package BE.boted.domain.task.model.entity;

import BE.boted.domain.Period;
import BE.boted.domain.crewtask.model.entity.CrewTask;
import BE.boted.domain.project.model.entity.Project;
import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
public class Task extends Period {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    @Enumerated(EnumType.STRING)
    private TaskStatus status;

    private Long userAmount;

    private LocalDateTime doneDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "project_id")
    private Project project;

    @OneToMany(mappedBy = "task")
    private List<CrewTask> crewTasks = new ArrayList<>();


}
