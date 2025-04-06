package com.example.Aula0404.Repository;

import com.example.Aula0404.Models.Musica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@Repository
public interface MusicaRepository extends JpaRepository<Musica, Long> {
    Optional<Musica> FindByNome(String Nome);

}
