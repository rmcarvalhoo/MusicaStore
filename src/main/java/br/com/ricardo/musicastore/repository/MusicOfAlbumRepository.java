package br.com.ricardo.musicastore.repository;

import br.com.ricardo.musicastore.repository.jpa.MusicOfAlbumEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MusicOfAlbumRepository extends JpaRepository<MusicOfAlbumEntity, Integer> {
}
