package live.thelocalhost.preplet_backend_v2.entity;

import jakarta.persistence.*;
import live.thelocalhost.preplet_backend_v2.utility.SubjectChapterId;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="subject_chapter")
public class SubjectChapter {

    @EmbeddedId
    private SubjectChapterId id; // Composite key

    @ManyToOne
    @MapsId("subjectId") // Links subjectId in SubjectChapterId to Subject
    @JoinColumn(name = "subject_id", referencedColumnName = "id")
    private Subject subject;

    @ManyToOne
    @MapsId("chapterId") // Links chapterId in SubjectChapterId to Chapter
    @JoinColumn(name = "chapter_id", referencedColumnName = "id")
    private Chapter chapter;
}
