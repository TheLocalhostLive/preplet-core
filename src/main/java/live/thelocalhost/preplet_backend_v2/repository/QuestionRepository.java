package live.thelocalhost.preplet_backend_v2.repository;

import live.thelocalhost.preplet_backend_v2.dto.QuestionGetDto;
import live.thelocalhost.preplet_backend_v2.entity.Question;
import live.thelocalhost.preplet_backend_v2.native_query_schemas.QuestionGetDtoNative;
import lombok.extern.java.Log;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question, Long> {

}
