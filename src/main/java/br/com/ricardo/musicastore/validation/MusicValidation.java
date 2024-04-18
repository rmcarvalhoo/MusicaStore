package br.com.ricardo.musicastore.validation;

import br.com.ricardo.musicastore.exception.AlbumException;
import br.com.ricardo.musicastore.exception.MusicException;
import br.com.ricardo.musicastore.repository.MusicRepository;
import br.com.ricardo.musicastore.resource.music.json.MusicJson;
import br.com.ricardo.musicastore.resource.musicOfAlbum.json.MusicOfAlbumJson;
import br.com.ricardo.musicastore.service.AlbumService;
import br.com.ricardo.musicastore.service.MusicService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Slf4j
@Component
public class MusicValidation {

    @Autowired
    private MusicRepository repository;

    public void createMusicOfAlbumValidation(MusicJson json){
        if (json.getId() != null && json.getId() >= 0) {
            throw new AlbumException("The id field cannot be informed");
        }
    }

    public void updateMusicOfAlbumValidation(MusicJson json){
        if (json.getId() == null) {
            throw new AlbumException("The id field cannot be informed");
        }
        if (!repository.existsById(json.getId())) {
            throw new MusicException("Music does not exist");
        }
    }

}
