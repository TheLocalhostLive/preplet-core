package live.thelocalhost.preplet_backend_v2.utility;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Embeddable
public class QuestionOptionId implements Serializable {
    Long questionId;
    String option;
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        QuestionOptionId that = (QuestionOptionId) o;
        return Objects.equals(questionId, that.questionId) &&
                Objects.equals(option, that.option);
    }

    @Override
    public int hashCode() {
        return Objects.hash(questionId, option);
    }
}
