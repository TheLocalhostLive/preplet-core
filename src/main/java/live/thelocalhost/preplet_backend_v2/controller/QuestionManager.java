package live.thelocalhost.preplet_backend_v2.controller;


import jakarta.persistence.Entity;
import live.thelocalhost.preplet_backend_v2.dto.QuestionDto;
import live.thelocalhost.preplet_backend_v2.dto.QuestionGetDto;
import live.thelocalhost.preplet_backend_v2.service.QuestionService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@RestController
@RequestMapping("/api/questions")
public class QuestionManager {

    @Autowired
    QuestionService questionService;

    @PostMapping
    public ResponseEntity<QuestionGetDto> create(@RequestBody QuestionDto questionDto){
        QuestionGetDto questionGetDto = questionService.create(questionDto);
        return new ResponseEntity<>(questionGetDto,HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<QuestionGetDto>> getAllQuestion(){
        List<QuestionGetDto> questionGetDtoList = questionService.getAllQuestion();
        return new ResponseEntity<>(questionGetDtoList, HttpStatus.OK);
    }
//    @GetMapping("/by-subject")
//    public ResponseEntity<List<QuestionGetDto>> getQuestionsBySubjectId(@RequestParam Long subjectId) {
//        List<QuestionGetDto> questionGetDtoList = questionService.getQuestionsBySubjectId(subjectId);
//        return new ResponseEntity<>(questionGetDtoList, HttpStatus.OK);
//    }


}
