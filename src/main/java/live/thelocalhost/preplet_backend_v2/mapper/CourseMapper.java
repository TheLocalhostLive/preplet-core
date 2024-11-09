package live.thelocalhost.preplet_backend_v2.mapper;

import live.thelocalhost.preplet_backend_v2.dto.CourseDto;
import live.thelocalhost.preplet_backend_v2.entity.Course;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class CourseMapper {
   public static CourseDto toDto(Course course){
        return new CourseDto(
            course.getId(),
                course.getCourseName()
        );
   }
   public static Course fromDto(CourseDto courseDto){
       return new Course(
               courseDto.getId(),
               courseDto.getCourseName()
       );
   }


}
