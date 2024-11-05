package live.thelocalhost.preplet_backend_v2.controller;

import live.thelocalhost.preplet_backend_v2.dto.SubjectDto;
import live.thelocalhost.preplet_backend_v2.mapper.SubjectMapper;
import live.thelocalhost.preplet_backend_v2.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/by-id")
    public ResponseEntity<SubjectDto> getBySubjectId(@RequestParam Long id){
        return new ResponseEntity<>(SubjectMapper.toDto(subjectService.getSubjectById(id)),HttpStatus.OK);
    }
}
