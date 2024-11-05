package live.thelocalhost.preplet_backend_v2.service;

import live.thelocalhost.preplet_backend_v2.dto.SubjectDto;
import live.thelocalhost.preplet_backend_v2.entity.Subject;
import live.thelocalhost.preplet_backend_v2.mapper.SubjectMapper;
import live.thelocalhost.preplet_backend_v2.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SubjectService {
    @Autowired
    private SubjectRepository subjectRepository;

    public SubjectDto create(SubjectDto subjectDto){
            Subject subject = SubjectMapper.fromDto(subjectDto);
            Subject savedSubject = subjectRepository.save(subject);
            return SubjectMapper.toDto(savedSubject);
    }

    public List<SubjectDto> getAllSubject(){
            return subjectRepository.findAll().stream().map(SubjectMapper::toDto).collect(Collectors.toList());
    }
    public Subject getSubjectById(Long subjectId){
        return subjectRepository.findById(subjectId)
                .orElseThrow(() -> new RuntimeException("Subject not found"));
    }
}
