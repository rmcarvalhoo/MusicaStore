package br.com.ricardo.musicastore.service;

import br.com.ricardo.musicastore.exception.ArtistException;
import br.com.ricardo.musicastore.repository.ArtistRepository;
import br.com.ricardo.musicastore.repository.jpa.ArtistEntity;
import br.com.ricardo.musicastore.resource.artist.json.ArtistJson;
import br.com.ricardo.musicastore.validation.ArtistValidation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class ArtistService {

    @Autowired
    private ArtistRepository repository;

    @Autowired
    private ArtistValidation artistValidation;

    public Page<ArtistJson> getAll(Pageable pageable){
        Page<ArtistEntity> artistEntitys = repository.findAll(pageable);
        return artistEntitys.map(e-> {
            ArtistJson json = new ArtistJson();
            BeanUtils.copyProperties(e, json);
            return json;
        });
    }

    public ArtistJson getById(Integer id){
        ArtistJson response = new ArtistJson();
        ArtistEntity entity = repository.findById(id).orElseThrow(()-> new ArtistException("Artist does not exist"));
        BeanUtils.copyProperties(entity, response);
        return response;
    }

    public void existById(Integer id){
        if (!repository.existsById(id)) {
            throw new ArtistException("Artist does not exist");
        }
    }

    public void create(ArtistJson request) {
        artistValidation.createArtistValidation(request);
        save(request);
    }

    public void update(ArtistJson request) {
        artistValidation.updateArtistValidation(request);
        save(request);
    }

    private void save(ArtistJson request) {
        ArtistEntity entity = new ArtistEntity();
        BeanUtils.copyProperties(request, entity);
        repository.save(entity);
        request.setId(entity.getId());
    }
}
