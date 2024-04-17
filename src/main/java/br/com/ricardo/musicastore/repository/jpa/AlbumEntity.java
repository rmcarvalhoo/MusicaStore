package br.com.ricardo.musicastore.repository.jpa;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Collection;

@Data
@Entity
@Table(name = "ALBUM", schema = "musicdb", catalog = "")
public class AlbumEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Integer id;

    @Basic
    @Column(name = "TITLE", nullable = false, length = 200)
    private String title;

    @Basic
    @Column(name = "LAUNCH_YEAR", nullable = false)
    private int launchYear;

    @Basic
    @Column(name = "IMAGE", nullable = false, length = 200)
    private String image;

    @Basic
    @Column(name = "ARTIST_ID", nullable = false)
    private int artistId;

    @ManyToOne
    @JoinColumn(name = "ARTIST_ID", referencedColumnName = "ID", nullable = false, insertable=false, updatable=false)
    private ArtistEntity artistByArtistId;

    @OneToMany(mappedBy = "albumByAlbumId")
    private Collection<MusicOfAlbumEntity> musicOfAlbumsById;


}
