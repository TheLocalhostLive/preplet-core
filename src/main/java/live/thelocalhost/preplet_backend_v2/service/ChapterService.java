package live.thelocalhost.preplet_backend_v2.service;

import live.thelocalhost.preplet_backend_v2.dto.ChapterDto;
import live.thelocalhost.preplet_backend_v2.entity.Chapter;
import live.thelocalhost.preplet_backend_v2.mapper.ChapterMapper;
import live.thelocalhost.preplet_backend_v2.repository.ChapterRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

public class ChapterService {
    @Autowired
    private ChapterRepository chapterRepository;

    public ChapterDto create(ChapterDto chapterDto){
        Chapter chapter = ChapterMapper.fromDto(chapterDto);
        return ChapterMapper.toDto(chapterRepository.save(chapter));
    }
    public List<ChapterDto> getAllChapters(){
        return chapterRepository.findAll().stream().map(ChapterMapper::toDto).collect(Collectors.toList());
    }
    public ChapterDto getChapterById(Long id){
        return ChapterMapper.toDto(chapterRepository.findById(id).orElseThrow(()->new RuntimeException("Chapter Not Found")));

    }
}
