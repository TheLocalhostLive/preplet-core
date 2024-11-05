package live.thelocalhost.preplet_backend_v2.utility;
import java.util.Objects;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class SubjectCourseId {
    private Long subjectId;
    private Long courseId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SubjectCourseId that = (SubjectCourseId) o;
        return Objects.equals(subjectId, that.subjectId) &&
                Objects.equals(courseId, that.courseId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(subjectId, courseId);
    }
}
