package BE.boted.domain.receipt.model.entity;

import BE.boted.domain.project.model.entity.Project;

import javax.persistence.*;

@Entity
public class Receipt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(mappedBy = "receipt")
    private Project project;
}
