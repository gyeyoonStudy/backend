package BE.boted.domain.crew.model.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class ProjectCrewListDto {

    private List<ProjectCrewDto> crewList = new ArrayList<>();

}
