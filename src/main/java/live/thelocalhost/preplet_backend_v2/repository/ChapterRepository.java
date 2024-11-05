package live.thelocalhost.preplet_backend_v2.repository;

import live.thelocalhost.preplet_backend_v2.entity.Chapter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChapterRepository extends JpaRepository<Chapter,Long> {
}
