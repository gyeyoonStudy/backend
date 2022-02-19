package BE.boted.domain.project.model.dto.response;

import BE.boted.domain.project.model.entity.Project;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ProjectSimpleInfoDto {

    private String name;
    private String description;
    private LocalDateTime deadLine;

    public ProjectSimpleInfoDto(Project project) {
        this.name = project.getName();
        this.description = project.getDescription();
        this.deadLine = project.getDeadLine();
    }
}
