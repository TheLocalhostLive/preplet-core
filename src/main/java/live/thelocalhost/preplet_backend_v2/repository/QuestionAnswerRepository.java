package live.thelocalhost.preplet_backend_v2.repository;

import live.thelocalhost.preplet_backend_v2.entity.QuestionAnswer;
import live.thelocalhost.preplet_backend_v2.native_query_schemas.AnswerDtoNative;
import live.thelocalhost.preplet_backend_v2.native_query_schemas.QuestionGetDtoNative;
import live.thelocalhost.preplet_backend_v2.utility.QuestionAnswerId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface QuestionAnswerRepository extends JpaRepository<QuestionAnswer, QuestionAnswerId> {
    @Query(value = "SELECT a.answer as answer "+
            "FROM question_answer a " +
            "WHERE a.question_id =:questionId",
            nativeQuery = true
    )
    List<AnswerDtoNative> findAnswersByQuestionId(@Param("questionId") Long questionId);

}
