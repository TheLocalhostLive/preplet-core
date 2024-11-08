package live.thelocalhost.preplet_backend_v2.repository;

import live.thelocalhost.preplet_backend_v2.entity.QuestionAnswer;
import live.thelocalhost.preplet_backend_v2.utility.QuestionAnswerId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionAnswerRepository extends JpaRepository<QuestionAnswer, QuestionAnswerId> {

}
