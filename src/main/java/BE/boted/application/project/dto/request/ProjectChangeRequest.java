package BE.boted.application.project.dto.request;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;

@Data
public class ProjectChangeRequest {

    @NotEmpty(message = "프로젝트 이름은 존재해야합니다")
    private String name;
    private String description;
    private LocalDateTime deadLine;
}
