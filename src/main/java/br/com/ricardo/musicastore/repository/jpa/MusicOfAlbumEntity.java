package br.com.ricardo.musicastore.repository.jpa;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Objects;

@Data
@Entity
@Table(name = "MUSIC_OF_ALBUM", schema = "musicdb", catalog = "")
public class MusicOfAlbumEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID", nullable = false)
    private Integer id;

    @Basic
    @Column(name = "MUSIC_ID", nullable = false)
    private Integer musicId;

    @Basic
    @Column(name = "ALBUM_ID", nullable = false)
    private Integer albumId;

    @ManyToOne
    @JoinColumn(name = "MUSIC_ID", referencedColumnName = "ID", nullable = false, insertable=false, updatable=false)
    private MusicEntity musicByMusicId;

    @ManyToOne
    @JoinColumn(name = "ALBUM_ID", referencedColumnName = "ID", nullable = false, insertable=false, updatable=false)
    private AlbumEntity albumByAlbumId;

}
