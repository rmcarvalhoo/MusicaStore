package br.com.ricardo.musicastore.validation;

import br.com.ricardo.musicastore.exception.AlbumException;
import br.com.ricardo.musicastore.repository.AlbumRepository;
import br.com.ricardo.musicastore.resource.album.json.AlbumJson;
import br.com.ricardo.musicastore.service.ArtistService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Slf4j
@Component
public class AlbumValidation {

    @Autowired
    private AlbumRepository repository;

    @Autowired
    private ArtistService artistService;

    public void createAlbumValidation(AlbumJson albumJson){
        if (albumJson.getId() != null && albumJson.getId() >= 0) {
            throw new AlbumException("The id field cannot be informed");
        }
        artistService.existById(albumJson.getArtistId());
    }

    public void updateAlbumValidation(AlbumJson albumJson) {
        if (albumJson.getId() == null) {
            throw new AlbumException("The id must be informed");
        }
        if(!repository.existsById(albumJson.getId())) {
            throw new AlbumException("Album does not exist");
        }
        artistService.existById(albumJson.getArtistId());
    }
}
