package BE.boted.domain.task.model.dto.response;

import BE.boted.domain.crew.model.dto.response.ProjectCrewDto;
import BE.boted.domain.task.model.entity.Task;
import BE.boted.domain.task.model.entity.TaskStatus;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
public class ProjectTaskDto {

    private Long taskId;
    private String taskName;
    private List<ProjectCrewDto> crews;
    private TaskStatus status;

    public ProjectTaskDto(Task task) {
        this.taskId = task.getId();
        this.taskName = task.getName();
        this.crews = task.getCrewTasks().stream()
                        .map(crewTask -> crewTask.getCrew())
                        .map(crew -> new ProjectCrewDto(crew))
                        .collect(Collectors.toList());
        this.status = task.getStatus();
    }
}
