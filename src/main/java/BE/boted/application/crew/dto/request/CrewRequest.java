package BE.boted.application.crew.dto.request;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
public class CrewRequest {

    @NotEmpty(message = "닉네임은 반드시 존재해야합니다")
    @Size(max = 100)
    private String nickname;
    private String email;
    private String school;

}
