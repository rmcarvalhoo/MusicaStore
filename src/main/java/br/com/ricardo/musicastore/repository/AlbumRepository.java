package br.com.ricardo.musicastore.repository;

import br.com.ricardo.musicastore.repository.jpa.AlbumEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlbumRepository extends JpaRepository<AlbumEntity, Integer> {
}
