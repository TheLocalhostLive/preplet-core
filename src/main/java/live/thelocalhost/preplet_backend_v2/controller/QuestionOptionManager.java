//package live.thelocalhost.preplet_backend_v2.controller;
//
//
//import live.thelocalhost.preplet_backend_v2.dto.QuestionOptionDto;
//import live.thelocalhost.preplet_backend_v2.service.QuestionOptionService;
//import lombok.AllArgsConstructor;
//import lombok.NoArgsConstructor;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@AllArgsConstructor
//@NoArgsConstructor
//@RestController
//@RequestMapping("/api/question-option")
//public class QuestionOptionManager {
//
//    @Autowired
//    private QuestionOptionService questionOptionService;
//    @PostMapping
//    public ResponseEntity<QuestionOptionDto> create(@RequestBody QuestionOptionDto questionOptionDto){
//        return new ResponseEntity<>(questionOptionService.create(questionOptionDto), HttpStatus.CREATED);
//    }
//}
