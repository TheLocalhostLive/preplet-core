package live.thelocalhost.preplet_backend_v2.utility;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Objects;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class SubjectChapterId  implements Serializable {
    private Long subjectId;
    private Long chapterId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SubjectChapterId that = (SubjectChapterId) o;
        return Objects.equals(subjectId, that.subjectId) &&
                Objects.equals(chapterId, that.chapterId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(subjectId, chapterId);
    }

}
