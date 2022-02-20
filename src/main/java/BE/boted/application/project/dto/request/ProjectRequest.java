package BE.boted.application.project.dto.request;

import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;

@Data
public class ProjectRequest {

    @NotEmpty(message = "프로젝트 이름은 존재해야 합니다")
    private String name;
    private String description;
    @NotEmpty
    private Long captainId;
    private LocalDateTime deadLine;
}
