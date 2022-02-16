package BE.boted.application.crew.Controller;

import BE.boted.application.crew.dto.CrewRequest;
import BE.boted.domain.crew.model.dto.CrewResponse;
import BE.boted.domain.crew.service.CrewService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class CrewController {

    private final CrewService crewService;


    @PostMapping("/account/new")
    public CrewResponse saveMember(@RequestBody @Valid CrewRequest req) {
        return crewService.saveCrew(req.getNickname(), req.getEmail(), req.getSchool());
    }

    @GetMapping("/account/{itemId}")
    public CrewResponse getProfile(@PathVariable("itemId") Long itemId) {
        return crewService.getProfile(itemId);
    }

    @PostMapping("/account{itemId}")
    public CrewResponse changeProfile(@PathVariable("itemId") Long itemId,
                                      @RequestBody @Valid CrewRequest req) {
        return crewService.changeCrew(itemId, req);
    }


}
