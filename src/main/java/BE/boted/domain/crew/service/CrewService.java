package BE.boted.domain.crew.service;

import BE.boted.application.crew.dto.request.CrewRequest;
import BE.boted.domain.crew.exception.CrewNotExistException;
import BE.boted.domain.crew.exception.NickNameAlreadyExistException;
import BE.boted.domain.crew.model.dto.response.CrewInfoDto;
import BE.boted.domain.crew.model.dto.response.CrewResponse;
import BE.boted.domain.crew.model.entity.Crew;
import BE.boted.domain.crew.model.repository.CrewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CrewService {

    private final CrewRepository crewRepository;

    @Transactional
    public CrewResponse saveCrew(String nickname, String email, String school) {

        if (crewRepository.existsByNickname(nickname) == true) {
            throw new NickNameAlreadyExistException("이미 존재하는 닉네임입니다");
        }

        Crew crew = new Crew(nickname, email, school);
        crewRepository.save(crew);

        return new CrewResponse(crew);

    }

    public CrewInfoDto getProfile(Long crewId) {
        Crew crew = crewRepository.findById(crewId)
                .orElseThrow(() -> new CrewNotExistException("존재하지 않는 회원입니다."));

        return new CrewInfoDto(crew);
    }

    @Transactional
    public CrewResponse changeCrew(Long crewId, CrewRequest req){

        Crew findCrew = crewRepository.findById(crewId)
                .orElseThrow(() -> new CrewNotExistException("존재하지 않는 회원입니다"));

        findCrew.change(req.getNickname(), req.getEmail(), req.getSchool());

        return new CrewResponse(findCrew);
    }


}
