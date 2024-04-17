package br.com.ricardo.musicastore.repository.jpa;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Collection;
import java.util.Objects;

@Data
@Entity
@Table(name = "MUSIC", schema = "musicdb", catalog = "")
public class MusicEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID", nullable = false)
    private Integer id;

    @Basic
    @Column(name = "TITLE", nullable = false, length = 200)
    private String title;

    @Basic
    @Column(name = "DURATION", nullable = false)
    private Integer duration;

    @OneToMany(mappedBy = "musicByMusicId")
    private Collection<MusicOfAlbumEntity> musicOfAlbumsById;

}
