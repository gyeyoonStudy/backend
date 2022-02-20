package BE.boted.domain.invitation.model.dto.response;

import BE.boted.domain.invitation.model.entity.Invitation;
import BE.boted.domain.project.model.entity.Project;
import lombok.Data;

@Data
public class GetInviteResponse {

    private Long invitationId;
    private Project project;
    private Long projectId;
    private String captain;

    public GetInviteResponse(Invitation invitation) {
        invitationId = invitation.getId();
        project = invitation.getProject();
        projectId = project.getId();
        captain = project.getCaptain().getNickname();
    }
}
