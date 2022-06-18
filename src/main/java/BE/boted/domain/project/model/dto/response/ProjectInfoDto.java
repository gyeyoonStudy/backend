package BE.boted.domain.project.model.dto.response;

import BE.boted.domain.crew.model.entity.Crew;
import BE.boted.domain.project.model.entity.Project;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class ProjectInfoDto {

    private String name;
    private String captain;
    private String description;
    private LocalDateTime deadLine;

    public ProjectInfoDto(Project project) {
        this.name = project.getName();
        this.description = project.getDescription();
        this.captain = project.getCaptain().getNickname();
        this.deadLine = project.getDeadLine();
    }
}
