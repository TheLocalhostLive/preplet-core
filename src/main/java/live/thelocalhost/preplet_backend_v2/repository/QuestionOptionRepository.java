package live.thelocalhost.preplet_backend_v2.repository;

import live.thelocalhost.preplet_backend_v2.entity.QuestionOption;
import live.thelocalhost.preplet_backend_v2.utility.QuestionOptionId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionOptionRepository extends JpaRepository<QuestionOption, QuestionOptionId> {
}
