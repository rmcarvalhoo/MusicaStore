package br.com.ricardo.musicastore.resource.album;

import br.com.ricardo.musicastore.resource.album.json.AlbumJson;
import br.com.ricardo.musicastore.service.AlbumService;
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
@RequestMapping("/album")
public class AlbumResource {

    @Autowired
    private AlbumService albumService;

    @GetMapping("/")
    public ResponseEntity<AlbumJson> getById(
            @RequestParam(value = "start", defaultValue = "0") Integer start,
            @RequestParam(value = "limit", defaultValue = "10") Integer limit,
            @RequestParam(value = "id") Integer id) {
        log.info("AlbumResource.getById(start [{}], limit [{}], id [{}])",start,limit, id);
        return ResponseEntity.ok(albumService.getById(id));
    }

    @GetMapping("/all")
    public ResponseEntity<Page<AlbumJson>> getAll(
            @RequestParam(value = "start", defaultValue = "0") Integer start,
            @RequestParam(value = "limit", defaultValue = "10") Integer limit) {
        log.info("AlbumResource.getAll(start [{}], limit [{}])",start,limit);
        return ResponseEntity.ok(albumService.getAll(PageRequest.of(start, limit)));
    }

    @PostMapping("/create")
    public ResponseEntity<AlbumJson> create(@RequestBody @Valid AlbumJson request) {
        log.info("AlbumResource.create(AlbumRequest [{}])", request);
        albumService.create(request);
        return ResponseEntity.status(HttpStatus.OK).body(request);
    }

    @PutMapping("/{id}/update")
    public ResponseEntity<AlbumJson> update(
            @PathVariable("id") Integer id,
            @RequestBody @Valid AlbumJson request) {
        log.info("AlbumResource.update(id [{}], AlbumRequest [{}])", id, request);
        request.setId(id);
        albumService.update(request);
        return ResponseEntity.status(HttpStatus.OK).body(request);
    }

}
