package BE.boted.domain.crew.model.entity;

import BE.boted.domain.Period;
import BE.boted.domain.invitation.model.entity.Invitation;
import BE.boted.domain.crewtask.model.entity.CrewTask;
import lombok.Getter;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
public class Crew extends Period {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nickname;

    private String email;

    private String school;

    @OneToMany(mappedBy = "crew")
    private List<Invitation> invitations = new ArrayList<>();

    @OneToMany(mappedBy = "crew")
    private List<CrewTask> crewTasks = new ArrayList<>();



}
