package live.thelocalhost.preplet_backend_v2.service;

import live.thelocalhost.preplet_backend_v2.dto.QuestionAnswerDto;
import live.thelocalhost.preplet_backend_v2.dto.QuestionDto;
import live.thelocalhost.preplet_backend_v2.dto.QuestionGetDto;
import live.thelocalhost.preplet_backend_v2.dto.QuestionOptionDto;
import live.thelocalhost.preplet_backend_v2.entity.*;
import live.thelocalhost.preplet_backend_v2.mapper.ChapterMapper;
import live.thelocalhost.preplet_backend_v2.mapper.QuestionAnswerMapper;
import live.thelocalhost.preplet_backend_v2.mapper.QuestionMapper;
import live.thelocalhost.preplet_backend_v2.mapper.QuestionOptionMapper;
import live.thelocalhost.preplet_backend_v2.native_query_schemas.AnswerDtoNative;
import live.thelocalhost.preplet_backend_v2.native_query_schemas.OptionDtoNative;
import live.thelocalhost.preplet_backend_v2.native_query_schemas.QuestionGetDtoNative;
import live.thelocalhost.preplet_backend_v2.repository.QuestionAnswerRepository;
import live.thelocalhost.preplet_backend_v2.repository.QuestionOptionRepository;
import live.thelocalhost.preplet_backend_v2.repository.QuestionRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class QuestionService {
    @Autowired
    private QuestionRepository questionRepository;
    @Autowired
    private QuestionAnswerRepository questionAnswerRepository;
    @Autowired
    private QuestionOptionRepository questionOptionRepository;
    @Autowired
    private SubjectService subjectService;
    @Autowired
    private  CourseService courseService;
    @Autowired
    private ChapterService chapterService;

    public QuestionGetDto create(QuestionDto questionDto){

        Subject subject = subjectService.getSubjectById(questionDto.getSubjectId());

        Course course = courseService.getCourseById(questionDto.getCourseId());

        Chapter chapter = ChapterMapper.fromDto(chapterService.getChapterById(questionDto.getChapterId()));

        Question question = QuestionMapper.fromDto(questionDto,subject,course,chapter);

        Question savedQuestion =  questionRepository.save(question);

        QuestionGetDtoNative questionGetDtoNative = questionRepository.getQuestionById(savedQuestion.getId());

        return new QuestionGetDto(
                questionGetDtoNative.getId(),
                questionGetDtoNative.getCourseName(),
                questionGetDtoNative.getSubjectName(),
                questionGetDtoNative.getChapterName(),
                questionGetDtoNative.getYear(),
                questionGetDtoNative.getQuestionBody(),
                getOptionsByQuestionId(questionGetDtoNative.getId()),
                getAnswerByQuestionId(questionGetDtoNative.getId())
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
                q.getQuestionBody(),
                getOptionsByQuestionId(q.getId()),
                getAnswerByQuestionId(q.getId())
        )).collect(Collectors.toList());
    }
    public List<QuestionGetDto> getQuestionsBySubjectId(Long subjectId){
        List<QuestionGetDtoNative> nativeResults = questionRepository.findQuestionsBySubjectId(subjectId);
        return nativeResults.stream().map(q->new QuestionGetDto(
                q.getId(),
                q.getCourseName(),
                q.getSubjectName(),
                q.getChapterName(),
                q.getYear(),
                q.getQuestionBody(),
                getOptionsByQuestionId(q.getId()),
                getAnswerByQuestionId(q.getId())
        )).collect(Collectors.toList());
    }
    public List<QuestionGetDto> getQuestionByChapterId(Long chapterId){
        List<QuestionGetDtoNative> nativeResults = questionRepository.findQuestionsByChapterId(chapterId);
        return nativeResults.stream().map(q->new QuestionGetDto(
                q.getId(),
                q.getCourseName(),
                q.getSubjectName(),
                q.getChapterName(),
                q.getYear(),
                q.getQuestionBody(),
                getOptionsByQuestionId(q.getId()),
                getAnswerByQuestionId(q.getId())
        )).collect(Collectors.toList());
    }
    public List<QuestionGetDto> getQuestionBySubjectAndChapter(Long subjectId , Long chapterId){

        List<QuestionGetDtoNative> nativeResults = questionRepository.findQuestionsBySubjectIdAndChapterId(subjectId,chapterId);
        return nativeResults.stream().map(q->new QuestionGetDto(
                q.getId(),
                q.getCourseName(),
                q.getSubjectName(),
                q.getChapterName(),
                q.getYear(),
                q.getQuestionBody(),
                getOptionsByQuestionId(q.getId()),
                getAnswerByQuestionId(q.getId())
        )).collect(Collectors.toList());
    }
    public List<QuestionGetDto> getQuestionBySubjectAndCourse(Long subjectId , Long courseId){
        List<QuestionGetDtoNative> nativeResults = questionRepository.findQuestionsBySubjectIdAndCourseId(subjectId,courseId);
        return nativeResults.stream().map(q->new QuestionGetDto(
                q.getId(),
                q.getCourseName(),
                q.getSubjectName(),
                q.getChapterName(),
                q.getYear(),
                q.getQuestionBody(),
                getOptionsByQuestionId(q.getId()),
                getAnswerByQuestionId(q.getId())
        )).collect(Collectors.toList());
    }
    public List<QuestionGetDto> getQuestionsByYear(Integer year){
        List<QuestionGetDtoNative> nativeResults = questionRepository.findQuestionsByYear(year);
        return nativeResults.stream().map(q->new QuestionGetDto(
                q.getId(),
                q.getCourseName(),
                q.getSubjectName(),
                q.getChapterName(),
                q.getYear(),
                q.getQuestionBody(),
                getOptionsByQuestionId(q.getId()),
                getAnswerByQuestionId(q.getId())
        )).collect(Collectors.toList());
    }

    public Question getQuestionByQuestionId(Long id){
        return questionRepository.findById(id).orElseThrow(()->new RuntimeException("Question Not Found"));
    }
    public QuestionAnswerDto createAnswer(QuestionAnswerDto questionAnswerDto){
        System.out.println("questionId:"+questionAnswerDto.getQuestionId());
        Question question = getQuestionByQuestionId(questionAnswerDto.getQuestionId());
        QuestionAnswer questionAnswer = QuestionAnswerMapper.fromDto(questionAnswerDto,question);
        return QuestionAnswerMapper.toDto(questionAnswerRepository.save(questionAnswer));
    }
    public List<String> getAnswerByQuestionId(Long questionId){
        return questionAnswerRepository
                .findAnswersByQuestionId(questionId)
                .stream()
                .map(AnswerDtoNative::getAnswer)
                .collect(Collectors.toList());
    }
    public QuestionOptionDto createOption(QuestionOptionDto questionOptionDto){
        Question question = getQuestionByQuestionId(questionOptionDto.getQuestionId());
        QuestionOption questionOption = QuestionOptionMapper.fromDto(questionOptionDto,question);
        return QuestionOptionMapper.toDto(questionOptionRepository.save(questionOption));
    }

    public List<String> getOptionsByQuestionId(Long questionId){
        System.out.println("Question Id " + questionId);
        List<String> options = questionOptionRepository
                .findOptionsByQuestionId(questionId)
                .stream()
                .map(OptionDtoNative::getOptions)
                .collect(Collectors.toList());
        for(String op:options){
            System.out.println(op+" ");
        }
        return options;
    }

}
