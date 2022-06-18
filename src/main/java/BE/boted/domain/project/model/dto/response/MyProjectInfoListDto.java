package BE.boted.domain.project.model.dto.response;

import lombok.Data;

import java.util.List;

@Data
public class MyProjectInfoListDto {

    private List<MyProjectInfoDto> projectList;

    public MyProjectInfoListDto(List<MyProjectInfoDto> myProjectInfoDtos) {
        this.projectList = myProjectInfoDtos;
    }
}
