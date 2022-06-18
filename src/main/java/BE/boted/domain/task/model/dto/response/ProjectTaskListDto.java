package BE.boted.domain.task.model.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class ProjectTaskListDto {

    private List<ProjectTaskDto> taskList;
}
