package br.com.ricardo.musicastore.service;

import br.com.ricardo.musicastore.exception.MusicException;
import br.com.ricardo.musicastore.repository.MusicOfAlbumRepository;
import br.com.ricardo.musicastore.repository.jpa.MusicOfAlbumEntity;
import br.com.ricardo.musicastore.resource.musicOfAlbum.json.MusicOfAlbumJson;
import br.com.ricardo.musicastore.validation.MusicOfAlbumValidation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class MusicOfAlbumService {

    @Autowired
    private MusicOfAlbumRepository repository;

    @Autowired
    private MusicOfAlbumValidation musicOfAlbumValidation;

    public Page<MusicOfAlbumJson> getAll(Pageable pageable){
        Page<MusicOfAlbumEntity> artistEntitys = repository.findAll(pageable);
        return artistEntitys.map(e-> { return MusicOfAlbumJson.builder()
                .id(e.getId())
                .musicId(e.getMusicId())
                .albumId(e.getAlbumId())
                .build();
        });
    }

    public MusicOfAlbumJson getById(Integer id){
        MusicOfAlbumJson response = new MusicOfAlbumJson();
        MusicOfAlbumEntity entity = repository.findById(id).orElseThrow(()-> new MusicException("Music of Album does not exist"));
        BeanUtils.copyProperties(entity, response);
        return response;
    }

    public void create(MusicOfAlbumJson request) {
        musicOfAlbumValidation.createMusicOfAlbumValidation(request);
        MusicOfAlbumEntity entity = new MusicOfAlbumEntity();
        BeanUtils.copyProperties(request, entity);
        repository.save(entity);
        request.setId(entity.getId());
    }

}
