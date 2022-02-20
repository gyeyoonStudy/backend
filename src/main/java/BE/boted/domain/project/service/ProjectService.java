package BE.boted.domain.project.service;


import BE.boted.application.project.dto.request.ProjectChangeRequest;
import BE.boted.domain.crew.exception.CrewNotExistException;
import BE.boted.domain.crew.model.dto.response.ProjectCrewDto;
import BE.boted.domain.crew.model.dto.response.ProjectCrewListDto;
import BE.boted.domain.crew.model.entity.Crew;
import BE.boted.domain.crew.model.repository.CrewRepository;
import BE.boted.domain.invitation.model.entity.Invitation;
import BE.boted.domain.invitation.model.repository.InvitationRepository;
import BE.boted.domain.participation.exception.ParticipationNotExistException;
import BE.boted.domain.participation.model.entity.Participation;
import BE.boted.domain.participation.model.repository.ParticipationRepository;
import BE.boted.domain.project.exception.ProjectNotExistException;
import BE.boted.domain.project.model.dto.response.*;
import BE.boted.domain.project.model.entity.Project;
import BE.boted.domain.project.model.repository.ProjectRepository;
import BE.boted.domain.task.exception.TaskNotExistException;
import BE.boted.domain.task.model.dto.response.ProjectTaskDto;
import BE.boted.domain.task.model.dto.response.ProjectTaskListDto;
import BE.boted.domain.task.model.entity.Task;
import BE.boted.domain.task.model.entity.TaskStatus;
import BE.boted.domain.task.model.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ProjectService {

    private final CrewRepository crewRepository;
    private final TaskRepository taskRepository;
    private final ProjectRepository projectRepository;
    private final InvitationRepository invitationRepository;
    private final ParticipationRepository participationRepository;

    //기획 api에서는 captain이 없었는데 없는 이유가 있나요 ?(만들어질 때 만든 사람이 captain 아닌가욤
    @Transactional
    public ProjectDto createProject(String name,
                                    String description,
                                    Long captainId,
                                    LocalDateTime deadLine) {


        Crew captain = crewRepository.findById(captainId)
                .orElseThrow(() -> new CrewNotExistException("존재하지 않는 회원입니다"));

        Project project = new Project(name, description, captain, deadLine);
        Project saveProject = projectRepository.save(project);

        return new ProjectDto(saveProject);
    }

    public MyProjectInfoListDto getMyProjectList(Long crewId) {

        Crew crew = crewRepository.findById(crewId)
                .orElseThrow(() -> new CrewNotExistException("존재하지 않는 회원입니다"));

        List<Participation> participations = crew.getParticipations();

        List<MyProjectInfoDto> myProjectInfoDtos = participations.stream()
                .map(participation -> participation.getProject())
                .map(project -> new MyProjectInfoDto(project))
                .collect(Collectors.toList());

        return new MyProjectInfoListDto(myProjectInfoDtos);

    }

    public ProjectSimpleInfoDto getSimpleProjectInfo(Long projectId) {

        Project project = projectRepository.findById(projectId)
                .orElseThrow(() -> new ProjectNotExistException("존재하지 않는 프로젝트입니다"));

        return new ProjectSimpleInfoDto(project);

    }

    public ProjectInfoDto getDetailProjectInfo(Long projectId) {

        Project project = projectRepository.findById(projectId)
                .orElseThrow(() -> new ProjectNotExistException("존재하지 않는 프로젝트입니다"));

        return new ProjectInfoDto(project);
    }

    public ProjectCrewListDto getCrewListAtModify(Long projectId) {

        Project project = projectRepository.findById(projectId)
                .orElseThrow(() -> new ProjectNotExistException("존재하지 않는 프로젝트입니다"));

        List<Participation> participations = project.getParticipations();

        List<ProjectCrewDto> projectCrewDtos = participations.stream()
                .map(participation -> participation.getCrew())
                .map(crew -> new ProjectCrewDto(crew))
                .collect(Collectors.toList());

        return new ProjectCrewListDto(projectCrewDtos);
    }

    //여기서 양방향 연관관계가 아니라 단방향이라서 Repository를 두번 써서 네트워크를 두번 타서
    //성능이 별로 안좋아 보이는데 다른 방법으로는 quarydsl 써야되나요 ??
    //그리고 만약에 양방향연관관계라고해도 project findBy로 찾고 project.getTasks이렇게 해도 네트워크를 두번 타는건가요 ??
    public ProjectTaskListDto getProjectTaskList(Long projectId) {

        Project project = projectRepository.findById(projectId)
                .orElseThrow(() -> new ProjectNotExistException("존재하지 않는 프로젝트입니다"));

        List<Task> findTasks = taskRepository.findAllByProject(project);

        List<ProjectTaskDto> projectTaskDtos = findTasks.stream()
                .map(task -> new ProjectTaskDto(task))
                .collect(Collectors.toList());

        return new ProjectTaskListDto(projectTaskDtos);
    }

    @Transactional
    public void changeTaskStatus(Long taskId, TaskStatus taskStatus) {

        Task task = taskRepository.findById(taskId)
                .orElseThrow(() -> new TaskNotExistException("존재하지 않는 테스크입니다"));
        task.changeStatus(taskStatus);
    }

    @Transactional
    public Long changeProject(Long projectId, ProjectChangeRequest req) {

        Project project = projectRepository.findById(projectId)
                .orElseThrow(() -> new ProjectNotExistException("존재하지 않는 프로젝트입니다"));

        project.changeProject(req.getName(), req.getDescription(), req.getDeadLine());

        return project.getId();
    }

    @Transactional
    public Long inviteCrew(Long crewId, Long projectId) {

        Crew crew = crewRepository.findById(crewId)
                .orElseThrow(() -> new CrewNotExistException("존재하지 않는 회원입니다"));

        Project project = projectRepository.findById(projectId)
                .orElseThrow(() -> new ProjectNotExistException("존재하지 않는 프로젝트입니다"));

        Invitation invitation = new Invitation(crew, project);

        return invitationRepository.save(invitation).getId();
    }

    @Transactional
    public void changeCaptain(Long crewId, Long projectId) {

        Crew crew = crewRepository.findById(crewId)
                .orElseThrow(() -> new CrewNotExistException("존재하지 않는 회원입니다"));

        Project project = projectRepository.findById(projectId)
                .orElseThrow(() -> new ProjectNotExistException("존재하지 않는 프로젝트입니다"));

        project.changeCaptain(crew);
    }

    //성능 안좋은거같음 . 꿀팁업나욘. 의견 : 캡틴이 프로젝트 만들때 아니면 초대수락 할 때 participationId값넘기고
    //uri를 participationid 값 보내면 안되나요 ?
    @Transactional
    public void outCrew(Long crewId, Long projectId) {

        Crew crew = crewRepository.findById(crewId)
                .orElseThrow(() -> new CrewNotExistException("존재하지 않는 회원입니다"));

        Project project = projectRepository.findById(projectId)
                .orElseThrow(() -> new ProjectNotExistException("존재하지 않는 프로젝트입니다"));

        Participation participation = participationRepository.findByCrewAAndProject(crew, project)
                .orElseThrow(() -> new ParticipationNotExistException("존재하지 않는 참여입니다"));

        participationRepository.delete(participation);
        participation.delete();
    }

    @Transactional
    public void deleteProject(Long projectId) {

        Project project = projectRepository.findById(projectId)
                .orElseThrow(() -> new ProjectNotExistException("존재하지 않는 프로젝트입니다"));

        projectRepository.delete(project);
    }


}
