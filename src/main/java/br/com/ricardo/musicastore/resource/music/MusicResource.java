package br.com.ricardo.musicastore.resource.music;

import br.com.ricardo.musicastore.resource.artist.json.ArtistJson;
import br.com.ricardo.musicastore.resource.music.json.MusicJson;
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
@RequestMapping("/music")
public class MusicResource {

    @Autowired
    private MusicService musicService;

    @GetMapping("/")
    public ResponseEntity<MusicJson> getById(
            @RequestParam(value = "start", defaultValue = "0") Integer start,
            @RequestParam(value = "limit", defaultValue = "10") Integer limit,
            @RequestParam(value = "id") Integer id) {
        log.info("MusicResource.getById(start [{}], limit [{}], id [{}])",start,limit, id);
        return ResponseEntity.ok(musicService.getById(id));
    }

    @GetMapping("/all")
    public ResponseEntity<Page<MusicJson>> getAll(
            @RequestParam(value = "start", defaultValue = "0") Integer start,
            @RequestParam(value = "limit", defaultValue = "10") Integer limit) {
        log.info("MusicResource.getAll(start [{}], limit [{}])",start,limit);
        return ResponseEntity.ok(musicService.getAll(PageRequest.of(start, limit)));
    }

    @PostMapping("/create")
    public ResponseEntity<MusicJson> create(@RequestBody @Valid MusicJson request) {
        log.info("MusicResource.create(MusicRequest [{}])", request);
        musicService.create(request);
        return ResponseEntity.status(HttpStatus.OK).body(request);
    }

    @PutMapping("/{id}/update")
    public ResponseEntity<MusicJson> update(@PathVariable("id") Integer id,
                                             @RequestBody @Valid MusicJson request) {
        log.info("MusicResource.create(id [{}], MusicJson [{}])", id, request);
        request.setId(id);
        musicService.update(request);
        return ResponseEntity.status(HttpStatus.OK).body(request);
    }

}
