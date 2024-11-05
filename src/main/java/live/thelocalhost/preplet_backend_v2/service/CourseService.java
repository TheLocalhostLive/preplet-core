package live.thelocalhost.preplet_backend_v2.service;

import live.thelocalhost.preplet_backend_v2.dto.CourseDto;
import live.thelocalhost.preplet_backend_v2.entity.Course;
import live.thelocalhost.preplet_backend_v2.mapper.CourseMapper;
import live.thelocalhost.preplet_backend_v2.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseService {
    @Autowired
    private CourseRepository courseRepository;
    public CourseDto create(CourseDto courseDto){
        Course course = CourseMapper.fromDto(courseDto);
        Course savedCourse = courseRepository.save(course);
        return CourseMapper.toDto(savedCourse);
    }
    public List<CourseDto> getAllCourse(){
        return courseRepository.findAll().stream().map(CourseMapper::toDto).collect(Collectors.toList());
    }
    public Course getCouseById(Long courseId){
        return courseRepository.findById(courseId).orElseThrow(()->new RuntimeException("Course Not Found"));
    }
}
