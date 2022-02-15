package BE.boted.domain.project.model.entity;

import BE.boted.domain.Period;
import BE.boted.domain.invitation.model.entity.Invitation;
import BE.boted.domain.receipt.model.entity.Receipt;
import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
public class Project extends Period {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    private String captain;

    private LocalDateTime deadLine;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "receipt_id")
    private Receipt receipt;

    @OneToMany(mappedBy = "project")
    private List<Invitation> invitations = new ArrayList<>();



}
