package br.com.ricardo.musicastore.repository;

import br.com.ricardo.musicastore.repository.jpa.MusicEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MusicRepository extends JpaRepository<MusicEntity, Integer> {
}
