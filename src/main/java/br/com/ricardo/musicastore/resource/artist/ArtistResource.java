package br.com.ricardo.musicastore.resource.artist;

import br.com.ricardo.musicastore.resource.artist.json.ArtistJson;
import br.com.ricardo.musicastore.service.ArtistService;
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
@RequestMapping("/artist")
public class ArtistResource {

    @Autowired
    private ArtistService artistService;

    @GetMapping("/")
    public ResponseEntity<ArtistJson> getById(
            @RequestParam(value = "start", defaultValue = "0") Integer start,
            @RequestParam(value = "limit", defaultValue = "10") Integer limit,
            @RequestParam(value = "id") Integer id) {
        log.info("ArtistResource.getById(start [{}], limit [{}], id [{}])",start,limit, id);
        return ResponseEntity.ok(artistService.getById(id));
    }

    @GetMapping("/all")
    public ResponseEntity<Page<ArtistJson>> getAll(
            @RequestParam(value = "start", defaultValue = "0") Integer start,
            @RequestParam(value = "limit", defaultValue = "10") Integer limit) {
        log.info("ArtistResource.getAll(start [{}], limit [{}])",start,limit);
        return ResponseEntity.ok(artistService.getAll(PageRequest.of(start, limit)));
    }

    @PutMapping("/{id}/update")
    public ResponseEntity<ArtistJson> update(@PathVariable("id") Integer id,
                                             @RequestBody @Valid ArtistJson request) {
        log.info("ArtistResource.create(id [{}], ArtistRequest [{}])", id, request);
        request.setId(id);
        artistService.update(request);
        return ResponseEntity.status(HttpStatus.OK).body(request);
    }

    @PostMapping("/create")
    public ResponseEntity<ArtistJson> create(@RequestBody @Valid ArtistJson request) {
        log.info("ArtistResource.create(ArtistRequest [{}])", request);
        artistService.create(request);
        return ResponseEntity.status(HttpStatus.OK).body(request);
    }

}
