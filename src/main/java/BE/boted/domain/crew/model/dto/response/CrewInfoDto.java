package BE.boted.domain.crew.model.dto.response;

import BE.boted.domain.crew.model.entity.Crew;

public class CrewInfoDto {

    private String nickname;
    private String email;
    private String school;

    public CrewInfoDto(Crew crew) {
        this.nickname = crew.getNickname();
        this.email = crew.getEmail();
        this.school = crew.getSchool();
    }
}
