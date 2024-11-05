package live.thelocalhost.preplet_backend_v2.mapper;

import live.thelocalhost.preplet_backend_v2.dto.ChapterDto;
import live.thelocalhost.preplet_backend_v2.entity.Chapter;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


public class ChapterMapper {
    public static ChapterDto toDto(Chapter chapter){
        return new ChapterDto(
                chapter.getId(),
                chapter.getChapterName()
        );
    }
    public static Chapter fromDto(ChapterDto chapterDto){
        return new Chapter(
                chapterDto.getId(),
                chapterDto.getChapterName()
        );
    }
}
