package br.com.ricardo.musicastore.repository.jpa;

import br.com.ricardo.musicastore.resource.artist.json.ArtistJson;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Collection;
import java.util.Objects;

@Data
@Entity
@Table(name = "ARTIST", schema = "musicdb", catalog = "")
public class ArtistEntity {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID", nullable = false)
    private Integer id;

    @Basic
    @Column(name = "NAME", nullable = false, length = 200)
    private String name;

    @Basic
    @Column(name = "NATIONALITY", nullable = false, length = 50)
    private String nationality;

    @Basic
    @Column(name = "SITE", nullable = false, length = 50)
    private String site;

    @Basic
    @Column(name = "IMAGE", nullable = false, length = 50)
    private String image;

    @OneToMany(mappedBy = "artistByArtistId")
    private Collection<AlbumEntity> albumsById;

}
