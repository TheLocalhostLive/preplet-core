package live.thelocalhost.preplet_backend_v2.mapper;


import live.thelocalhost.preplet_backend_v2.dto.QuestionOptionDto;
import live.thelocalhost.preplet_backend_v2.entity.Question;
import live.thelocalhost.preplet_backend_v2.entity.QuestionOption;
import live.thelocalhost.preplet_backend_v2.utility.QuestionOptionId;

public class QuestionOptionMapper {
    public static QuestionOptionDto toDto(QuestionOption questionOption){
        return new QuestionOptionDto(
                questionOption.getQuestionOptionId().getQuestionId(),
                questionOption.getQuestionOptionId().getOption()

        );

    }
    public static QuestionOption fromDto(QuestionOptionDto questionOptionDto, Question question){
        QuestionOptionId questionOptionId = new QuestionOptionId(
                questionOptionDto.getQuestionId(),
                questionOptionDto.getOption()
        );

        QuestionOption questionOption = new QuestionOption();
        questionOption.setQuestionOptionId(questionOptionId);
        questionOption.setQuestion(question);

        return questionOption;

    }
}
