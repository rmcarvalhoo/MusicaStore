package br.com.ricardo.musicastore.service;

import br.com.ricardo.musicastore.exception.AlbumException;
import br.com.ricardo.musicastore.repository.AlbumRepository;
import br.com.ricardo.musicastore.repository.jpa.AlbumEntity;
import br.com.ricardo.musicastore.repository.jpa.ArtistEntity;
import br.com.ricardo.musicastore.resource.album.json.AlbumJson;
import br.com.ricardo.musicastore.resource.artist.json.ArtistJson;
import br.com.ricardo.musicastore.validation.AlbumValidation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class AlbumService {

    @Autowired
    private AlbumRepository repository;

    @Autowired
    private ArtistService artistService;

    @Autowired
    private AlbumValidation albumValidation;

    public Page<AlbumJson> getAll(Pageable pageable){
        Page<AlbumEntity> albumEntitys = repository.findAll(pageable);

        return albumEntitys.map(e-> {
            ArtistJson artistJson = new ArtistJson();
            BeanUtils.copyProperties(e.getArtistByArtistId(), artistJson);
            return AlbumJson.builder()
                .id(e.getId())
                .title(e.getTitle())
                .launchYear(e.getLaunchYear())
                .image(e.getImage())
                .artistId(e.getArtistId())
                .artist(artistJson)
                .build();
        });
    }

    public AlbumJson getById(Integer id){
        AlbumJson response = AlbumJson.builder()
                .artist(new ArtistJson())
                .build();
        AlbumEntity entity = repository.findById(id).orElseThrow(()-> new AlbumException("Album does not exist"));
        BeanUtils.copyProperties(entity, response);
        BeanUtils.copyProperties(entity.getArtistByArtistId(), response.getArtist());
        return response;
    }

    public void create(AlbumJson request) {
        albumValidation.createAlbumValidation(request);

        AlbumEntity entity = new AlbumEntity();
        BeanUtils.copyProperties(request, entity);
        repository.save(entity);
        request.setId(entity.getId());
        request.setArtist(artistService.getById(request.getArtistId()));
    }

}
