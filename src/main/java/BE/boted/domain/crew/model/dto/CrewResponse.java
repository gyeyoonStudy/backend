package BE.boted.domain.crew.model.dto;

import BE.boted.domain.crew.model.entity.Crew;
import lombok.Data;

@Data
public class CrewResponse {

    private Long id;
    private String nickname;
    private String email;
    private String school;

    public CrewResponse(Crew crew) {
        this.id = crew.getId();
        this.nickname = crew.getNickname();
        this.email = crew.getEmail();
        this.school = crew.getSchool();
    }
}
