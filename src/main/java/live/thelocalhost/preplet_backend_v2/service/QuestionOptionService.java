//package live.thelocalhost.preplet_backend_v2.service;
//
//import live.thelocalhost.preplet_backend_v2.dto.QuestionOptionDto;
//import live.thelocalhost.preplet_backend_v2.entity.Question;
//import live.thelocalhost.preplet_backend_v2.entity.QuestionOption;
//import live.thelocalhost.preplet_backend_v2.mapper.QuestionOptionMapper;
//import live.thelocalhost.preplet_backend_v2.native_query_schemas.OptionDtoNative;
//import live.thelocalhost.preplet_backend_v2.repository.QuestionOptionRepository;
//import live.thelocalhost.preplet_backend_v2.repository.QuestionRepository;
//import lombok.AllArgsConstructor;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.stream.Collectors;
//
//@Service
//public class QuestionOptionService {
//    @Autowired
//    private QuestionOptionRepository questionOptionRepository;
//    @Autowired
//    private QuestionService questionService;
//    public QuestionOptionDto create(QuestionOptionDto questionOptionDto){
//        Question question = questionService.getQuestionByQuestionId(questionOptionDto.getQuestionId());
//        QuestionOption questionOption = QuestionOptionMapper.fromDto(questionOptionDto,question);
//        return QuestionOptionMapper.toDto(questionOptionRepository.save(questionOption));
//    }
//
//    public List<String> getOptionsByQuestionId(Long questionId){
//        return questionOptionRepository.findOptionsByQuestionId(questionId)
//                .stream()
//                .map(OptionDtoNative::getOption)
//                .collect(Collectors.toList());
//
//    }
//}
