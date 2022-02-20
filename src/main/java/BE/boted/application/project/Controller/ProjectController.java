package BE.boted.application.project.Controller;

import BE.boted.application.project.dto.request.ProjectChangeRequest;
import BE.boted.application.project.dto.request.ProjectRequest;
import BE.boted.application.task.dto.request.TaskStatusRequest;
import BE.boted.domain.crew.model.dto.response.ProjectCrewListDto;
import BE.boted.domain.project.model.dto.response.MyProjectInfoListDto;
import BE.boted.domain.project.model.dto.response.ProjectDto;
import BE.boted.domain.project.model.dto.response.ProjectInfoDto;
import BE.boted.domain.project.model.dto.response.ProjectSimpleInfoDto;
import BE.boted.domain.project.service.ProjectService;
import BE.boted.domain.task.model.dto.response.ProjectTaskListDto;
import BE.boted.response.MessageSuccessResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class ProjectController {

    private final ProjectService projectService;

    @GetMapping("/project/{crewId}")
    @ResponseStatus(HttpStatus.OK)
    public MyProjectInfoListDto getMyProjectList(@PathVariable("crewId") Long crewId) {
        return projectService.getMyProjectList(crewId);
    }

    @GetMapping("/project/simple/{projectId}")
    @ResponseStatus(value = HttpStatus.OK)
    public ProjectSimpleInfoDto getSimpleInfoAtchange(@PathVariable("projectId") Long projectId) {
        return projectService.getSimpleProjectInfo(projectId);
    }

    @GetMapping("/project/{projectId}")
    @ResponseStatus(HttpStatus.OK)
    public ProjectInfoDto getDetatilInfo(@PathVariable("projectId") Long projectId) {
        return projectService.getDetailProjectInfo(projectId);
    }

    @GetMapping("/project/{projectId}/crews")
    @ResponseStatus(HttpStatus.OK)
    public ProjectCrewListDto getProjectCrewList(@PathVariable("projectId") Long projectId) {
        return projectService.getCrewListAtModify(projectId);
    }

    @GetMapping("/project/{projectId}/task")
    @ResponseStatus(HttpStatus.OK)
    public ProjectTaskListDto getProjectTaskList(@PathVariable("projectId") Long projectId) {
        return projectService.getProjectTaskList(projectId);
    }


    //uri에 생성한 사람 알아야되니깐 crewId값 받아야되지 않나요 ??
    @PostMapping("/project/{crewId}")
    @ResponseStatus(HttpStatus.OK)
    public ProjectDto createProject(@RequestBody @Valid ProjectRequest req) {
        return projectService.createProject(req.getName(), req.getDescription(), req.getCaptainId(), req.getDeadLine());
    }

    //여기서 왜 projectId 필요한가요??
    @PostMapping("/project/{projectId}/task/{taskId}/status")
    @ResponseStatus(HttpStatus.OK)
    public MessageSuccessResponse changeTastStatus(@PathVariable("taskId") Long taskId,
                                                   @RequestBody @Valid TaskStatusRequest req) {
        projectService.changeTaskStatus(taskId, req.getStatus());
        return new MessageSuccessResponse();
    }

    @PostMapping("/project/{projectId}")
    @ResponseStatus(HttpStatus.OK)
    public Long changeProject(@PathVariable("projectId") Long projecId, ProjectChangeRequest req) {
        return projectService.changeProject(projecId, req);
    }

    @PostMapping("/project/{projectId}/{crewId}")
    @ResponseStatus(HttpStatus.OK)
    public Long inviteCrew(@PathVariable("prjectId") Long projectId,
                           @PathVariable("crewId") Long crewId) {
        return projectService.inviteCrew(crewId, projectId);
    }

    @PostMapping("/project/{projectId}/captain/{crewId}")
    @ResponseStatus(HttpStatus.OK)
    public MessageSuccessResponse changeCaptain(@PathVariable("projectId") Long projectId,
                                                @PathVariable("crewId") Long crewId) {
        projectService.changeCaptain(crewId, projectId);
        return new MessageSuccessResponse();
    }

    @DeleteMapping("/project/{projectId}/{crewId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public MessageSuccessResponse outCrew(@PathVariable("projectId") Long projectId,
                                          @PathVariable("crewId") Long crewId) {

        projectService.outCrew(crewId, projectId);
        return new MessageSuccessResponse();
    }

    @DeleteMapping("/project/{projectId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public MessageSuccessResponse deleteProject(@PathVariable("projectId") Long projectId) {
        projectService.deleteProject(projectId);
        return new MessageSuccessResponse();
    }
}
