package BE.boted.domain.crew.model.dto.response;

import BE.boted.domain.crew.model.entity.Crew;
import lombok.Data;

@Data
public class ProjectCrewDto {

    private String nickname;
    private Long id;

    public ProjectCrewDto(Crew crew) {
        this.nickname = crew.getNickname();
        this.id = crew.getId();
    }
}
