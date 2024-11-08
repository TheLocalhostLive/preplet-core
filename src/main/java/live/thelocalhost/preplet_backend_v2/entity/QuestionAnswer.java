package live.thelocalhost.preplet_backend_v2.entity;

import jakarta.persistence.*;
import live.thelocalhost.preplet_backend_v2.utility.QuestionAnswerId;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="question_answer")
public class QuestionAnswer {
    @EmbeddedId
    QuestionAnswerId questionAnswerId;
    @ManyToOne
    @MapsId("questionId")
    @JoinColumn(name = "question_id", referencedColumnName = "id")
    private Question question;
}
