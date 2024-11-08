package live.thelocalhost.preplet_backend_v2.entity;

import jakarta.persistence.*;
import live.thelocalhost.preplet_backend_v2.utility.QuestionOptionId;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="question_option")
public class QuestionOption {
    @EmbeddedId
    QuestionOptionId questionOptionId;
    @ManyToOne
    @MapsId("questionId")
    @JoinColumn(name = "question_id", referencedColumnName = "id")
    private Question question;
}
