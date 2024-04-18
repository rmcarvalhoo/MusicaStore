package br.com.ricardo.musicastore.validation;

import br.com.ricardo.musicastore.exception.AlbumException;

import br.com.ricardo.musicastore.exception.MusicException;
import br.com.ricardo.musicastore.repository.MusicOfAlbumRepository;
import br.com.ricardo.musicastore.resource.musicOfAlbum.json.MusicOfAlbumJson;
import br.com.ricardo.musicastore.service.AlbumService;
import br.com.ricardo.musicastore.service.MusicService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Slf4j
@Component
public class MusicOfAlbumValidation {

    @Autowired
    private MusicOfAlbumRepository repository;

    @Autowired
    private MusicService musicService;

    @Autowired
    private AlbumService albumService;

    public void createMusicOfAlbumValidation(MusicOfAlbumJson json){
        if (json.getId() != null && json.getId() >= 0) {
            throw new AlbumException("The id cannot be informed");
        }
        musicService.existById(json.getMusicId());
        albumService.existById(json.getAlbumId());
    }

    public void updateMusicOfAlbumValidation(MusicOfAlbumJson json){
        if (json.getId() == null) {
            throw new AlbumException("The id must be informed");
        }
        if (!repository.existsById(json.getId())) {
            throw new MusicException("Music of Album does not exist");
        }
        musicService.existById(json.getMusicId());
        albumService.existById(json.getAlbumId());
    }
}
