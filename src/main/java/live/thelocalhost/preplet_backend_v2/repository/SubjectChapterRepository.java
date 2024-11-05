package live.thelocalhost.preplet_backend_v2.repository;

import live.thelocalhost.preplet_backend_v2.entity.SubjectChapter;
import live.thelocalhost.preplet_backend_v2.utility.SubjectChapterId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectChapterRepository extends JpaRepository<SubjectChapter, SubjectChapterId> {
}
