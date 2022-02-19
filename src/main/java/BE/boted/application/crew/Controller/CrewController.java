package BE.boted.application.crew.Controller;

import BE.boted.application.crew.dto.request.CrewRequest;
import BE.boted.domain.crew.model.dto.response.CrewInfoDto;
import BE.boted.domain.crew.model.dto.response.CrewResponse;
import BE.boted.domain.crew.service.CrewService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class CrewController {

    private final CrewService crewService;


    @PostMapping("/account/new")
    @ResponseStatus(HttpStatus.CREATED)
    public CrewResponse saveMember(@RequestBody @Valid CrewRequest req) {
        return crewService.saveCrew(req.getNickname(), req.getEmail(), req.getSchool());
    }

    @GetMapping("/account/{itemId}")
    @ResponseStatus(HttpStatus.OK)
    public CrewInfoDto getProfile(@PathVariable("itemId") Long itemId) {
        return crewService.getProfile(itemId);
    }

    @PostMapping("/account/{itemId}")
    @ResponseStatus(HttpStatus.OK)
    public CrewResponse changeProfile(@PathVariable("itemId") Long itemId,
                                      @RequestBody @Valid CrewRequest req) {
        return crewService.changeCrew(itemId, req);
    }


}
