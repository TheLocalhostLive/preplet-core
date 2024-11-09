//package live.thelocalhost.preplet_backend_v2.service;
//
//import live.thelocalhost.preplet_backend_v2.dto.QuestionAnswerDto;
//import live.thelocalhost.preplet_backend_v2.entity.Question;
//import live.thelocalhost.preplet_backend_v2.entity.QuestionAnswer;
//import live.thelocalhost.preplet_backend_v2.mapper.QuestionAnswerMapper;
//import live.thelocalhost.preplet_backend_v2.native_query_schemas.AnswerDtoNative;
//import live.thelocalhost.preplet_backend_v2.repository.QuestionAnswerRepository;
//import lombok.AllArgsConstructor;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.stream.Collectors;
//
//@Service
//@AllArgsConstructor
//public class QuestionAnswerService {
//
//    @Autowired
//    private QuestionAnswerRepository questionAnswerRepository;
//    @Autowired
//    private QuestionService questionService;
//
//    public QuestionAnswerDto create(QuestionAnswerDto questionAnswerDto){
//        System.out.println("questionId:"+questionAnswerDto.getQuestionId());
//        Question question = questionService.getQuestionByQuestionId(questionAnswerDto.getQuestionId());
//        QuestionAnswer questionAnswer = QuestionAnswerMapper.fromDto(questionAnswerDto,question);
//        return QuestionAnswerMapper.toDto(questionAnswerRepository.save(questionAnswer));
//    }
//    public List<String> getAnswerByQuestionId(Long questionId){
//        return questionAnswerRepository
//                .findAnswersByQuestionId(questionId)
//                .stream()
//                .map(AnswerDtoNative::getAnswer)
//                .collect(Collectors.toList());
//    }
//}
