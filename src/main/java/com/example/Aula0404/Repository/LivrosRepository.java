package com.example.Aula0404.Repository;

import com.example.Aula0404.Models.Livros;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LivrosRepository extends JpaRepository<Livros, Long> {

    Optional<Livros> findByTitulo(String titulo);

}
