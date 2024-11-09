package live.thelocalhost.preplet_backend_v2.repository;

import live.thelocalhost.preplet_backend_v2.entity.QuestionOption;
import live.thelocalhost.preplet_backend_v2.native_query_schemas.AnswerDtoNative;
import live.thelocalhost.preplet_backend_v2.native_query_schemas.OptionDtoNative;
import live.thelocalhost.preplet_backend_v2.utility.QuestionOptionId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface QuestionOptionRepository extends JpaRepository<QuestionOption, QuestionOptionId> {
    @Query(value = "SELECT a.option as options "+
            "FROM question_option a " +
            "WHERE a.question_id =:questionId",
            nativeQuery = true
    )
    List<OptionDtoNative> findOptionsByQuestionId(@Param("questionId") Long questionId);
}
