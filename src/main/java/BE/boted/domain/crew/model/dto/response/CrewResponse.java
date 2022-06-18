package BE.boted.domain.crew.model.dto.response;

import BE.boted.domain.crew.model.entity.Crew;
import lombok.Data;

@Data
public class CrewResponse {

    private Long crewId;
    private String nickname;
    private String email;
    private String school;

    public CrewResponse(Crew crew) {
        this.crewId = crew.getId();
        this.nickname = crew.getNickname();
        this.email = crew.getEmail();
        this.school = crew.getSchool();
    }
}
