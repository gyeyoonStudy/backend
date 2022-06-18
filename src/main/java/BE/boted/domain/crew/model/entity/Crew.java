package BE.boted.domain.crew.model.entity;

import BE.boted.domain.Period;
import BE.boted.domain.invitation.model.entity.Invitation;
import BE.boted.domain.crewtask.model.entity.CrewTask;
import BE.boted.domain.participation.model.entity.Participation;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
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

    @OneToMany(mappedBy = "crew")
    private List<Participation> participations = new ArrayList<>();

    public Crew(String nickname, String email, String school) {
        this.nickname = nickname;
        this.email = email;
        this.school = school;
    }

    public void change(String nickname, String email, String school) {
        this.nickname = nickname;
        this.email = email;
        this.school = school;
    }
}
