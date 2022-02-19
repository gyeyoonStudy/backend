package BE.boted.domain.project.model.entity;

import BE.boted.domain.Period;
import BE.boted.domain.crew.model.entity.Crew;
import BE.boted.domain.invitation.model.entity.Invitation;
import BE.boted.domain.participation.model.entity.Participation;
import BE.boted.domain.receipt.model.entity.Receipt;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Project extends Period {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    private LocalDateTime deadLine;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "crew_id")
    private Crew captain;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "receipt_id")
    private Receipt receipt;

    @OneToMany(mappedBy = "project")
    private List<Invitation> invitations = new ArrayList<>();

    @OneToMany(mappedBy = "project")
    private List<Participation> participations = new ArrayList<>();

    public Project(String name,
                   String description,
                   Crew captain,
                   LocalDateTime deadLine) {
        this.name = name;
        this.description = description;
        this.captain = captain;
        this.deadLine = deadLine;
    }

    public void changeCaptain(Crew crew) {
        this.captain = crew;
    }

    public void changeProject(String name, String description, LocalDateTime deadLine) {
        this.name = name;
        this.description = description;
        this.deadLine = deadLine;
    }
}
