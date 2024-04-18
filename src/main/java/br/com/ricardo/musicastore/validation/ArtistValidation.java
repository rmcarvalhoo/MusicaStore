package br.com.ricardo.musicastore.validation;

import br.com.ricardo.musicastore.exception.ArtistException;
import br.com.ricardo.musicastore.exception.MusicException;
import br.com.ricardo.musicastore.repository.ArtistRepository;
import br.com.ricardo.musicastore.resource.artist.json.ArtistJson;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ArtistValidation {

    @Autowired
    private ArtistRepository repository;

    public void updateArtistValidation(ArtistJson json){
        if (json.getId() == null) {
            throw new ArtistException("The id must be informed");
        }
        if (!repository.existsById(json.getId())) {
            throw new MusicException("Artist does not exist");
        }
    }

    public void createArtistValidation(ArtistJson json){
        if (json.getId() != null && json.getId() >= 0) {
            throw new ArtistException("The id field cannot be informed");
        }
    }
}
