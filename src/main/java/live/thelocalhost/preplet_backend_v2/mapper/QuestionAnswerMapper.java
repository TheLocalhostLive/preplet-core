package live.thelocalhost.preplet_backend_v2.mapper;

import live.thelocalhost.preplet_backend_v2.dto.QuestionAnswerDto;
import live.thelocalhost.preplet_backend_v2.entity.Question;
import live.thelocalhost.preplet_backend_v2.entity.QuestionAnswer;
import live.thelocalhost.preplet_backend_v2.utility.QuestionAnswerId;

public class QuestionAnswerMapper {

    public static QuestionAnswerDto toDto(QuestionAnswer questionAnswer){
        return new QuestionAnswerDto(
                questionAnswer.getQuestionAnswerId().getQuestionId(),
                questionAnswer.getQuestionAnswerId().getAnswer()
        );
    }

    public static QuestionAnswer fromDto(QuestionAnswerDto questionAnswerDto , Question question){
        QuestionAnswerId questionAnswerId = new QuestionAnswerId(
                questionAnswerDto.getQuestionId(),
                questionAnswerDto.getAnswer()
        );
        //System.out.println("");
        QuestionAnswer questionAnswer = new QuestionAnswer();
        questionAnswer.setQuestionAnswerId(questionAnswerId);
        questionAnswer.setQuestion(question);

        return questionAnswer;
    }
}
