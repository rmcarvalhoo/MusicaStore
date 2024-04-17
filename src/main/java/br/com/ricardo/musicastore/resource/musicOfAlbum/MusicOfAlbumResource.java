package br.com.ricardo.musicastore.resource.musicOfAlbum;

import br.com.ricardo.musicastore.resource.musicOfAlbum.json.MusicOfAlbumJson;
import br.com.ricardo.musicastore.service.MusicOfAlbumService;
import br.com.ricardo.musicastore.service.MusicService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/music-of-album")
public class MusicOfAlbumResource {

    @Autowired
    private MusicOfAlbumService musicServiceOfAlbumService;

    @GetMapping("/")
    public ResponseEntity<MusicOfAlbumJson> getById(
            @RequestParam(value = "start", defaultValue = "0") Integer start,
            @RequestParam(value = "limit", defaultValue = "10") Integer limit,
            @RequestParam(value = "id") Integer id) {
        log.info("MusicResource.getById(start [{}], limit [{}], id [{}])",start,limit, id);
        return ResponseEntity.ok(musicServiceOfAlbumService.getById(id));
    }

    @GetMapping("/all")
    public ResponseEntity<Page<MusicOfAlbumJson>> getAll(
            @RequestParam(value = "start", defaultValue = "0") Integer start,
            @RequestParam(value = "limit", defaultValue = "10") Integer limit) {
        log.info("MusicResource.getAll(start [{}], limit [{}])",start,limit);
        return ResponseEntity.ok(musicServiceOfAlbumService.getAll(PageRequest.of(start, limit)));
    }

    @PostMapping("/create")
    public ResponseEntity<MusicOfAlbumJson> create(@RequestBody @Valid MusicOfAlbumJson request) {
        log.info("MusicResource.create(MusicOfAlbumJson [{}])", request);
        musicServiceOfAlbumService.create(request);
        return ResponseEntity.status(HttpStatus.OK).body(request);
    }

}
