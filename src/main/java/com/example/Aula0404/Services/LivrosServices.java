package com.example.Aula0404.Services;

import com.example.Aula0404.Models.Livros;
import com.example.Aula0404.Repository.LivrosRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class LivrosServices {
    public LivrosRepository livrosRepository;

    public LivrosServices(LivrosRepository livrosRepository) {
        this.livrosRepository = livrosRepository;
    }

    public List<Livros> listarTodos(){
        return livrosRepository.findAll();
    }

    public Livros salvar(@Valid Livros livos){
        if (livrosRepository.findByTitulo(livos.getTitulo()).isPresent()) {
            throw new RuntimeException(("Titulo existente"));
        }
        return livrosRepository.save(livos);
    }

    public Livros atualizar(@Valid Livros livros) {
        Livros livrosAtualizar = livrosRepository.findById(livros.getId())
                .orElseThrow(() -> new RuntimeException("Livro Já existente"));

        livrosAtualizar.setTitulo(livros.getTitulo());
        livrosAtualizar.setAutor(livros.getAutor());
        livrosAtualizar.setEditora(livros.getEditora());

       return livrosRepository.save(livrosAtualizar);
    }

    public void excluir(Long Id){
        Livros livrosAtualizar = livrosRepository.findById(Id)
                .orElseThrow(() -> new RuntimeException("Livro Já existente"));

        livrosRepository.deleteById(livrosAtualizar.getId());
    }
}
