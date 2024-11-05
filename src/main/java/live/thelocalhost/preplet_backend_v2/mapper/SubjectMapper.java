package live.thelocalhost.preplet_backend_v2.mapper;

import live.thelocalhost.preplet_backend_v2.dto.SubjectDto;
import live.thelocalhost.preplet_backend_v2.entity.Subject;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


public class SubjectMapper {
    public  static SubjectDto toDto(Subject subject){
        return new SubjectDto(
                subject.getId(),
                subject.getSubjectName()
        );
    }
    public static Subject fromDto(SubjectDto subjectDto){
            return new Subject(
                subjectDto.getId(),
                subjectDto.getSubjectName()
            );
    }

}
