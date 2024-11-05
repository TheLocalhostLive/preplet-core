package live.thelocalhost.preplet_backend_v2.entity;

import jakarta.persistence.*;
import live.thelocalhost.preplet_backend_v2.utility.SubjectCourseId;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name="subject_course")
public class SubjectCourse {

    @EmbeddedId
    private SubjectCourseId subjectCourseId;

    @ManyToOne
    @MapsId("subjectId")
    @JoinColumn(name = "subject_id",referencedColumnName = "id")
    private Subject subject;

    @ManyToOne
    @MapsId("courseId")
    @JoinColumn(name = "courseId",referencedColumnName = "id")
    private Course course;
}
