package live.thelocalhost.preplet_backend_v2.dto;

import live.thelocalhost.preplet_backend_v2.entity.Chapter;
import live.thelocalhost.preplet_backend_v2.entity.Subject;
import live.thelocalhost.preplet_backend_v2.utility.SubjectChapterId;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SubjectChapterDto {
    private SubjectChapterId id; // Composite key
    private Subject subject;
    private Chapter chapter;
}
