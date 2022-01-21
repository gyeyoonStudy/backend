package BE.boted.domain.project.model.entity;

import BE.boted.domain.CreatedUpdatedAtEntity;
import BE.boted.domain.crewProject.model.entity.CrewProject;
import BE.boted.domain.receipt.model.entity.Receipt;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Project extends CreatedUpdatedAtEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "receipt_id")
    private Receipt receipt;

    @OneToMany(mappedBy = "project")
    private List<CrewProject> crewProjects = new ArrayList<>();

    private String name;

    private String description;

    private String captain;

    private LocalDateTime deadLine;






}
