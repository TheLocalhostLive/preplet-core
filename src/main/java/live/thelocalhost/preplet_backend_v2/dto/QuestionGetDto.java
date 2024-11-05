package live.thelocalhost.preplet_backend_v2.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class QuestionGetDto {
    Long id;
    String courseName;
    String subjectName;
    String chapterName;
    Integer year;
    String questionBody;
}