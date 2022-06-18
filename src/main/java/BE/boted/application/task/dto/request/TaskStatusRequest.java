package BE.boted.application.task.dto.request;

import BE.boted.domain.task.model.entity.TaskStatus;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class TaskStatusRequest {
    @NotEmpty
    private TaskStatus status;
}
