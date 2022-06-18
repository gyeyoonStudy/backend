package BE.boted.application.invitation.Controller;

import BE.boted.domain.invitation.model.dto.response.GetInviteResponse;
import BE.boted.domain.invitation.service.InvitationService;
import BE.boted.domain.project.model.dto.response.InviteProjectListDto;
import BE.boted.response.MessageSuccessResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class InvitationController {

    private final InvitationService invitationService;

    @GetMapping("/invitation/{crewId}")
    @ResponseStatus(HttpStatus.OK)
    public InviteProjectListDto getMyInviteList(@PathVariable("crewId") Long crewId) {
        return invitationService.getMyInvite(crewId);
    }

    @PostMapping("/invitation/{invitationId}")
    @ResponseStatus(HttpStatus.OK)
    public Long acceptInvite(@PathVariable("invitationId") Long invitationId) {
        return invitationService.acceptInvite(invitationId);
    }

    @DeleteMapping("/invitation/{invitationId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public MessageSuccessResponse refuseInvite(@PathVariable("invitationId") Long invitationId) {
        invitationService.refuseInvite(invitationId);
        return new MessageSuccessResponse();
    }
}
