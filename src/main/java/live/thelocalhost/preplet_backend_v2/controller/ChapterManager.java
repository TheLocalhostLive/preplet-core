package live.thelocalhost.preplet_backend_v2.controller;

import live.thelocalhost.preplet_backend_v2.dto.ChapterDto;
import live.thelocalhost.preplet_backend_v2.service.ChapterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/chapter")
public class ChapterManager {
    @Autowired
    private ChapterService chapterService;

    @PostMapping
    public ResponseEntity<ChapterDto> create(@RequestBody ChapterDto chapterDto){
           ChapterDto savedChapter = chapterService.create(chapterDto);
           return new ResponseEntity<>(savedChapter, HttpStatus.CREATED);
    }
    @GetMapping("/by-id")
    public ResponseEntity<ChapterDto> getChapterById( @RequestParam Long id){
        return new ResponseEntity<>(chapterService.getChapterById(id),HttpStatus.OK);
    }
}
