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
    @Query(value = "SELECT q.id AS id,  c.course_name As courseName , s.subject_name AS subjectName,cp.chapter_name AS chapterName,q.year AS year , q.question_body AS questionBody " +
            "FROM question q " +
            "JOIN course c ON q.course_id = c.id " +
            "JOIN subject s ON q.subject_id = s.id "+
            "JOIN chapter cp ON q.chapter_id = cp.id",
            nativeQuery = true)
    List<QuestionGetDtoNative> findAllQuestions();

    @Query(value = "SELECT q.id AS id,  c.course_name As courseName , s.subject_name AS subjectName ,cp.chapter_name AS chapterName,q.year AS year , q.question_body AS questionBody "+
            "FROM question q " +
            "JOIN course c ON q.course_id = c.id " +
            "JOIN subject s ON q.subject_id = s.id " +
            "JOIN chapter cp ON q.chapter_id = cp.id " +
            "WHERE q.id =:savedQuestionId ",
            nativeQuery = true
    )
    QuestionGetDtoNative getQuestionById(@Param("savedQuestionId") Long savedQuestionId);


    @Query(value = "SELECT q.id AS id,  c.course_name As courseName , s.subject_name AS subjectName ,cp.chapter_name AS chapterName,q.year AS year , q.question_body AS questionBody "+
            "FROM question q " +
            "JOIN course c ON q.course_id = c.id " +
            "JOIN subject s ON q.subject_id = s.id " +
            "JOIN chapter cp ON q.chapter_id = cp.id " +
            "WHERE q.subject_id =:subjectId ",
            nativeQuery = true
    )
    List<QuestionGetDtoNative> findQuestionsBySubjectId(@Param("subjectId") Long subjectId);

    @Query(value = "SELECT q.id AS id,  c.course_name As courseName , s.subject_name AS subjectName ,cp.chapter_name AS chapterName,q.year AS year , q.question_body AS questionBody "+
            "FROM question q " +
            "JOIN course c ON q.course_id = c.id " +
            "JOIN subject s ON q.subject_id = s.id " +
            "JOIN chapter cp ON q.chapter_id = cp.id " +
            "WHERE q.chapter_id =:chapterId",
            nativeQuery = true
    )
    List<QuestionGetDtoNative> findQuestionsByChapterId(@Param("chapterId") Long chapterId);

    @Query(value = "SELECT q.id AS id,  c.course_name As courseName , s.subject_name AS subjectName ,cp.chapter_name AS chapterName,q.year AS year , q.question_body AS questionBody "+
            "FROM question q " +
            "JOIN course c ON q.course_id = c.id " +
            "JOIN subject s ON q.subject_id = s.id " +
            "JOIN chapter cp ON q.chapter_id = cp.id " +
            "WHERE q.subject_id =:subjectId AND q.course_id =:courseId",
            nativeQuery = true
    )
    List<QuestionGetDtoNative> findQuestionsBySubjectIdAndCourseId(@Param("subjectId") Long subjectId,@Param("courseId") Long courseId);


    @Query(value = "SELECT q.id AS id,  c.course_name As courseName , s.subject_name AS subjectName ,cp.chapter_name AS chapterName,q.year AS year , q.question_body AS questionBody "+
            "FROM question q " +
            "JOIN course c ON q.course_id = c.id " +
            "JOIN subject s ON q.subject_id = s.id " +
            "JOIN chapter cp ON q.chapter_id = cp.id " +
            "WHERE q.subject_id =:subjectId AND q.chapter_id =:chapterId",
            nativeQuery = true
    )
    List<QuestionGetDtoNative> findQuestionsBySubjectIdAndChapterId(@Param("subjectId") Long subjectId,@Param("chapterId") Long chapterId);
}
