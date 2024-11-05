package live.thelocalhost.preplet_backend_v2.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import live.thelocalhost.preplet_backend_v2.entity.Course;
import live.thelocalhost.preplet_backend_v2.entity.Subject;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class QuestionDto {
    private Long id;
    private Long courseId;
    private Long subjectId;
    private Long chapterId;
    Integer year;
    String questionBody;
}
