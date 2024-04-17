package br.com.ricardo.musicastore.validation;

import br.com.ricardo.musicastore.exception.AlbumException;
import br.com.ricardo.musicastore.resource.album.json.AlbumJson;
import br.com.ricardo.musicastore.service.ArtistService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class AlbumValidation {

    @Autowired
    private ArtistService artistService;

    public void createAlbumValidation(AlbumJson albumJson){
        if (albumJson.getId() != null && albumJson.getId() >= 0) {
            throw new AlbumException("The id field cannot be informed");
        }

        artistService.getById(albumJson.getArtistId());
    }
}
