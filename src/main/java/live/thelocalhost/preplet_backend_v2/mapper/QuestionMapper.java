package live.thelocalhost.preplet_backend_v2.mapper;

import live.thelocalhost.preplet_backend_v2.dto.QuestionDto;
import live.thelocalhost.preplet_backend_v2.dto.QuestionGetDto;
import live.thelocalhost.preplet_backend_v2.entity.Chapter;
import live.thelocalhost.preplet_backend_v2.entity.Course;
import live.thelocalhost.preplet_backend_v2.entity.Question;
import live.thelocalhost.preplet_backend_v2.entity.Subject;
import live.thelocalhost.preplet_backend_v2.service.CourseService;
import live.thelocalhost.preplet_backend_v2.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class QuestionMapper {

    public  static QuestionDto toDto(Question question){
        return new QuestionDto(
                question.getId(),
                question.getCourse().getId(),
                question.getSubject().getId(),
                question.getChapter().getId(),
                question.getYear(),
                question.getQuestionBody()
        );
    }
    public static Question fromDto(QuestionDto questionDto , Subject subject , Course course , Chapter chapter){

        return  new Question(
                questionDto.getId(),
                course,
                subject,
                chapter,
                questionDto.getYear(),
                questionDto.getQuestionBody()
        );
    }
    public static QuestionGetDto toDto(Question question , String courseName, String subjectName, String chapterName , List<String> answers,List<String> options){
            return new QuestionGetDto(
                    question.getId(),
                    courseName,
                    subjectName,
                    chapterName,
                    question.getYear(),
                    question.getQuestionBody(),
                    options,
                    answers
            );
    }
}
