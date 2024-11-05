package live.thelocalhost.preplet_backend_v2.controller;


import live.thelocalhost.preplet_backend_v2.dto.CourseDto;
import live.thelocalhost.preplet_backend_v2.dto.UserDto;
import live.thelocalhost.preplet_backend_v2.service.CourseService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/course")
public class CourseManager {
    private CourseService courseService;

    @PostMapping
    public ResponseEntity<CourseDto> create(@RequestBody CourseDto courseDto){
        CourseDto savedCourse = courseService.create(courseDto);
        return new ResponseEntity<>(savedCourse,HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<CourseDto>> getAllCourse(){
        List<CourseDto> courseDtoList = courseService.getAllCourse();
        return new ResponseEntity<>(courseDtoList,HttpStatus.OK);
    }
}
