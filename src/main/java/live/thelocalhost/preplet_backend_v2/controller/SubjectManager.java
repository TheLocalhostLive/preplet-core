package live.thelocalhost.preplet_backend_v2.controller;

import live.thelocalhost.preplet_backend_v2.dto.SubjectDto;
import live.thelocalhost.preplet_backend_v2.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/subject")
public class SubjectManager {
    @Autowired
    private SubjectService subjectService;

    @PostMapping
    public ResponseEntity<SubjectDto> create(@RequestBody SubjectDto subjectDto){
        SubjectDto subjectDto1 = subjectService.create(subjectDto);
        return new ResponseEntity<>(subjectDto1, HttpStatus.CREATED);
    }
}
