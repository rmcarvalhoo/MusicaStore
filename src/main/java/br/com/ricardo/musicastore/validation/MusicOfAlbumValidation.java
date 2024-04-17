package br.com.ricardo.musicastore.validation;

import br.com.ricardo.musicastore.exception.AlbumException;

import br.com.ricardo.musicastore.resource.musicOfAlbum.json.MusicOfAlbumJson;
import br.com.ricardo.musicastore.service.AlbumService;
import br.com.ricardo.musicastore.service.MusicService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class MusicOfAlbumValidation {

    @Autowired
    private MusicService musicService;

    @Autowired
    private AlbumService albumService;

    public void createMusicOfAlbumValidation(MusicOfAlbumJson json){
        if (json.getId() != null && json.getId() >= 0) {
            throw new AlbumException("The id field cannot be informed");
        }

        musicService.getById(json.getMusicId());
        albumService.getById(json.getAlbumId());
    }
}
