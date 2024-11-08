package live.thelocalhost.preplet_backend_v2.service;

import live.thelocalhost.preplet_backend_v2.dto.QuestionAnswerDto;
import live.thelocalhost.preplet_backend_v2.entity.Question;
import live.thelocalhost.preplet_backend_v2.entity.QuestionAnswer;
import live.thelocalhost.preplet_backend_v2.mapper.QuestionAnswerMapper;
import live.thelocalhost.preplet_backend_v2.repository.QuestionAnswerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestionAnswerService {

    @Autowired
    private QuestionAnswerRepository questionAnswerRepository;
    @Autowired
    private QuestionService questionService;

    public QuestionAnswerDto create(QuestionAnswerDto questionAnswerDto){
        System.out.println("questionId:"+questionAnswerDto.getQuestionId());
        Question question = questionService.getQuestionByQuestionId(questionAnswerDto.getQuestionId());
        QuestionAnswer questionAnswer = QuestionAnswerMapper.fromDto(questionAnswerDto,question);
        return QuestionAnswerMapper.toDto(questionAnswerRepository.save(questionAnswer));
    }
}
