package live.thelocalhost.preplet_backend_v2.service;

import live.thelocalhost.preplet_backend_v2.dto.ChapterDto;
import live.thelocalhost.preplet_backend_v2.entity.Chapter;
import live.thelocalhost.preplet_backend_v2.mapper.ChapterMapper;
import live.thelocalhost.preplet_backend_v2.repository.ChapterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class ChapterService {
    @Autowired
    private ChapterRepository chapterRepository;

    public ChapterDto create(ChapterDto chapterDto){
        Chapter chapter = ChapterMapper.fromDto(chapterDto);
        Chapter savedChapter = chapterRepository.save(chapter);
        //System.out.println(savedChapter.getId()+" "+savedChapter.getChapterName());
        System.out.println(ChapterMapper.toDto(savedChapter).getId()+" Id--");

        return ChapterMapper.toDto(savedChapter);
    }
    public List<ChapterDto> getAllChapters(){
        return chapterRepository.findAll().stream().map(ChapterMapper::toDto).collect(Collectors.toList());
    }
    public ChapterDto getChapterById(Long id){
        return ChapterMapper.toDto(chapterRepository.findById(id).orElseThrow(()->new RuntimeException("Chapter Not Found")));

    }
}
