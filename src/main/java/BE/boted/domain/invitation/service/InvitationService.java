package BE.boted.domain.invitation.service;

import BE.boted.domain.crew.exception.CrewNotExistException;
import BE.boted.domain.crew.model.entity.Crew;
import BE.boted.domain.crew.model.repository.CrewRepository;
import BE.boted.domain.invitation.exception.InviteNotExistException;
import BE.boted.domain.invitation.model.dto.response.GetInviteResponse;
import BE.boted.domain.invitation.model.entity.Invitation;
import BE.boted.domain.invitation.model.repository.InvitationRepository;
import BE.boted.domain.participation.model.entity.Participation;
import BE.boted.domain.participation.model.repository.ParticipationRepository;
import BE.boted.domain.project.exception.ProjectNotExistException;
import BE.boted.domain.project.model.dto.response.InviteProjectDto;
import BE.boted.domain.project.model.dto.response.InviteProjectListDto;
import BE.boted.domain.project.model.entity.Project;
import BE.boted.domain.project.model.repository.ProjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class InvitationService {

    private final InvitationRepository invitationRepository;
    private final CrewRepository crewRepository;
    private final ProjectRepository projectRepository;
    private final ParticipationRepository participationRepository;

    //사용 x
    @Transactional
    public Long saveInvite(Long crewId, Long projectId) {

        Crew crew = crewRepository.findById(crewId)
                .orElseThrow(() -> new CrewNotExistException("존재하지 않는 회원입니다"));

        Project project = projectRepository.findById(projectId)
                .orElseThrow(() -> new ProjectNotExistException("존재하지 않는 프로젝트입니다"));

        Invitation invitation = new Invitation(crew, project);

        return invitationRepository.save(invitation).getId();
    }

    public InviteProjectListDto getMyInvite(Long crewId) {
        Crew crew = crewRepository.findById(crewId)
                .orElseThrow(() -> new CrewNotExistException("존재하지 않는 회원입니다"));

        List<Invitation> invitations = invitationRepository.findAllByCrew(crew);

        List<InviteProjectDto> inviteProjectDtos = invitations.stream()
                .map(invitation -> new InviteProjectDto(invitation))
                .collect(Collectors.toList());


        return new InviteProjectListDto(inviteProjectDtos);
    }

    //초대수락이나, 거절하면 그냥 초대 삭제하면 안되나요 ?? 그래서 InvitationStatus 존재의미를 모르겠습니다!
    @Transactional
    public Long acceptInvite(Long inviteId) {

        Invitation findInvite = invitationRepository.findById(inviteId)
                .orElseThrow(() -> new InviteNotExistException("존재하지 않는 초대입니다"));

        Participation participation = new Participation(findInvite.getCrew(), findInvite.getProject());
        participationRepository.save(participation);
        invitationRepository.delete(findInvite);

        return findInvite.accept();

    }

    @Transactional
    public void refuseInvite(Long inviteId) {

        Invitation findInvite = invitationRepository.findById(inviteId)
                .orElseThrow(() -> new InviteNotExistException("존재하지 않는 초대입니다"));

        invitationRepository.delete(findInvite);
        findInvite.refuse();
    }
}
