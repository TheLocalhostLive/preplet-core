package live.thelocalhost.preplet_backend_v2.controller;


import live.thelocalhost.preplet_backend_v2.dto.QuestionAnswerDto;
import live.thelocalhost.preplet_backend_v2.service.QuestionAnswerService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@NoArgsConstructor
@RestController
@RequestMapping("/api/question-answer")
public class QuestionAnswerManager {

    @Autowired
    private QuestionAnswerService questionAnswerService;
    @PostMapping
    public ResponseEntity<QuestionAnswerDto> create(@RequestBody QuestionAnswerDto questionAnswerDto){
        return new ResponseEntity<>(questionAnswerService.create(questionAnswerDto), HttpStatus.CREATED);
    }
}
