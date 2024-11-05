package live.thelocalhost.preplet_backend_v2.service;

import live.thelocalhost.preplet_backend_v2.dto.QuestionDto;
import live.thelocalhost.preplet_backend_v2.dto.QuestionGetDto;
import live.thelocalhost.preplet_backend_v2.entity.Chapter;
import live.thelocalhost.preplet_backend_v2.entity.Course;
import live.thelocalhost.preplet_backend_v2.entity.Question;
import live.thelocalhost.preplet_backend_v2.entity.Subject;
import live.thelocalhost.preplet_backend_v2.mapper.ChapterMapper;
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
    @Autowired
    private ChapterService chapterService;

    public QuestionGetDto create(QuestionDto questionDto){
        System.out.println("DTO-chapter: "+questionDto.getChapterId());
        System.out.println("DTO-subject "+questionDto.getSubjectId());
        System.out.println("DTO-course: "+questionDto.getCourseId());
        Subject subject = subjectService.getSubjectById(questionDto.getSubjectId());
        System.out.println("Service-subject: "+subject.getId());
        Course course = courseService.getCouseById(questionDto.getCourseId());
        System.out.println("Service-course: "+course.getId());
        Chapter chapter = ChapterMapper.fromDto(chapterService.getChapterById(questionDto.getChapterId()));
        System.out.println("Service-chapter: "+chapter.getId());
        Question question = QuestionMapper.fromDto(questionDto,subject,course,chapter);
        System.out.println("Mapper-subject: "+question.getSubject().getId());
        System.out.println("Mapper-chapter: "+question.getChapter().getId());
        System.out.println("Mapper-course: "+question.getCourse().getId());
        Question savedQuestion =  questionRepository.save(question);
        System.out.println("Repository: "+savedQuestion.getId());
        QuestionGetDtoNative questionGetDtoNative = questionRepository.getQuestionById(savedQuestion.getId());
        System.out.println("Query-Id: "+questionGetDtoNative.getId());
        System.out.println("Query-courseName: "+questionGetDtoNative.getCourseName());
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
    }
    public List<QuestionGetDto> getQuestionsBySubjectId(Long subjectId){
        List<QuestionGetDtoNative> nativeResults = questionRepository.findQuestionsBySubjectId(subjectId);
        return nativeResults.stream().map(q->new QuestionGetDto(
                q.getId(),
                q.getCourseName(),
                q.getSubjectName(),
                q.getChapterName(),
                q.getYear(),
                q.getQuestionBody()
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
                q.getQuestionBody()
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
                q.getQuestionBody()
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
                q.getQuestionBody()
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
                q.getQuestionBody()
        )).collect(Collectors.toList());
    }

}
