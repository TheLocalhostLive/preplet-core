package live.thelocalhost.preplet_backend_v2.service;

import live.thelocalhost.preplet_backend_v2.dto.QuestionDto;
import live.thelocalhost.preplet_backend_v2.dto.QuestionGetDto;
import live.thelocalhost.preplet_backend_v2.entity.Course;
import live.thelocalhost.preplet_backend_v2.entity.Question;
import live.thelocalhost.preplet_backend_v2.entity.Subject;
import live.thelocalhost.preplet_backend_v2.mapper.QuestionMapper;
import live.thelocalhost.preplet_backend_v2.native_query_schemas.QuestionGetDtoNative;
import live.thelocalhost.preplet_backend_v2.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class QuestionService {
    @Autowired
    private QuestionRepository questionRepository;
    @Autowired
    private SubjectService subjectService;
    @Autowired
    private  CourseService courseService;

    public QuestionGetDto create(QuestionDto questionDto){
        Subject subject = subjectService.getSubjectById(questionDto.getSubjectId());
        Course course = courseService.getCouseById(questionDto.getCourseId());
        Question question = QuestionMapper.fromDto(questionDto,subject,course);
        Question savedQuestion =  questionRepository.save(question);
        QuestionGetDtoNative questionGetDtoNative = questionRepository.getQuestionById(savedQuestion.getId());
        return new QuestionGetDto(
                questionGetDtoNative.getId(),
                questionGetDtoNative.getCourseName(),
                questionGetDtoNative.getSubjectName(),
                questionGetDtoNative.getChapterName(),
                questionGetDtoNative.getYear(),
                questionGetDtoNative.getQuestionBody()
        );
    }

    public List<QuestionGetDto> getAllQuestion(){
        List<QuestionGetDtoNative> nativeResults = questionRepository.findAllQuestions();
        return nativeResults.stream().map(q->new QuestionGetDto(
                q.getId(),
                q.getCourseName(),
                q.getSubjectName(),
                q.getChapterName(),
                q.getYear(),
                q.getQuestionBody()
        )).collect(Collectors.toList());
//        List<QuestionGetDto> resultList = new ArrayList<>();
//        for (QuestionGetDtoNative nativeResult : nativeResults) {
//            resultList.add(new QuestionGetDto(
//                    nativeResult.getId(),
//                    nativeResult.getCourseName(),
//                    nativeResult.getSubjectName(),
//                    nativeResult.getYear(),
//                    nativeResult.getQuestionBody()
//            ));
//        }
//        return resultList;
    }

}
