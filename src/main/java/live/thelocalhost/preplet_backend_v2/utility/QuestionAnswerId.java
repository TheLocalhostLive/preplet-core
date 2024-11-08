package live.thelocalhost.preplet_backend_v2.utility;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Embeddable
public class QuestionAnswerId {
    Long questionId;
    String answer;
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        QuestionAnswerId that = (QuestionAnswerId) o;
        return Objects.equals(questionId, that.questionId) &&
                Objects.equals(answer, that.answer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(questionId, answer);
    }
}
