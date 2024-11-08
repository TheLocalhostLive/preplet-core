package live.thelocalhost.preplet_backend_v2.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class QuestionAnswerDto {
    private Long questionId;
    private String answer;
}
