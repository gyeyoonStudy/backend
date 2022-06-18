package BE.boted.domain.project.model.dto.response;

import BE.boted.domain.crew.model.entity.Crew;
import BE.boted.domain.project.model.entity.Project;
import lombok.Data;

@Data
public class MyProjectInfoDto {

    private String name;
    private String captain;

    public MyProjectInfoDto(Project project) {
        this.name = project.getName();
        this.captain = project.getCaptain().getNickname();
    }
}
