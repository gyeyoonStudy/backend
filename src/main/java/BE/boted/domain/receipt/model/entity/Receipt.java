package BE.boted.domain.receipt.model.entity;

import BE.boted.domain.Period;
import BE.boted.domain.project.model.entity.Project;
import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class Receipt extends Period {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(mappedBy = "receipt", fetch = FetchType.LAZY)
    private Project project;
}
