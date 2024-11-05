package live.thelocalhost.preplet_backend_v2.repository;

import live.thelocalhost.preplet_backend_v2.entity.SubjectCourse;
import live.thelocalhost.preplet_backend_v2.utility.SubjectCourseId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectCourseRepository extends JpaRepository<SubjectCourse, SubjectCourseId> {
}
