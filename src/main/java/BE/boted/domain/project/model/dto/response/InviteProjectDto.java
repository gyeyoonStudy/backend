package BE.boted.domain.project.model.dto.response;

import BE.boted.domain.invitation.model.entity.Invitation;
import lombok.Data;

@Data
public class InviteProjectDto {

    private Long invitationId;
    private Long projectId;
    private String projectName;
    private String captainName;

    public InviteProjectDto(Invitation invitation) {
        this.invitationId = invitation.getId();
        this.projectId = invitation.getProject().getId();
        this.projectName = invitation.getProject().getName();
        this.captainName = invitation.getProject().getCaptain().getNickname();
    }
}
