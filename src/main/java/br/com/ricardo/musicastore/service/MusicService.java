package br.com.ricardo.musicastore.service;

import br.com.ricardo.musicastore.exception.MusicException;
import br.com.ricardo.musicastore.repository.MusicRepository;
import br.com.ricardo.musicastore.repository.jpa.MusicEntity;
import br.com.ricardo.musicastore.resource.music.json.MusicJson;
import br.com.ricardo.musicastore.validation.MusicValidation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MusicService {

    @Autowired
    private MusicRepository repository;

    @Autowired
    private MusicValidation musicValidation;

    public Page<MusicJson> getAll(Pageable pageable){
        Page<MusicEntity> artistEntitys = repository.findAll(pageable);
        return artistEntitys.map(e-> { return MusicJson.builder()
                .id(e.getId())
                .title(e.getTitle())
                .duration(e.getDuration())
                .build();
        });
    }

    public MusicJson getById(Integer id){
        MusicJson response = new MusicJson();
        MusicEntity entity = repository.findById(id).orElseThrow(()-> new MusicException("Music does not exist"));
        BeanUtils.copyProperties(entity, response);
        return response;
    }

    public void existById(Integer id) {
        if (!repository.existsById(id)) {
            throw new MusicException("Music does not exist");
        }
    }

    public void create(MusicJson request) {
        musicValidation.createMusicOfAlbumValidation(request);
        save(request);
    }

    public void update(MusicJson request) {
        musicValidation.updateMusicOfAlbumValidation(request);
        save(request);
    }

    public void save(MusicJson request) {
        MusicEntity entity = new MusicEntity();
        BeanUtils.copyProperties(request, entity);
        repository.save(entity);
        request.setId(entity.getId());
    }

}
