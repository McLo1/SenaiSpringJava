package com.example.Aula0404.Services;

import com.example.Aula0404.Models.Musica;
import com.example.Aula0404.Repository.MusicaRepository;
import jakarta.validation.Valid;
import org.hibernate.loader.ast.internal.MultiIdEntityLoaderStandard;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MusicaService {

    public MusicaRepository musicaRepository;

    public MusicaService(MusicaRepository musicaRepository) {
        this.musicaRepository = musicaRepository;
    }

    public List<Musica> listarTodos(){
        return musicaRepository.findAll();
    }

    public Musica salvar(@Valid Musica musica){
        if (musicaRepository.findByNome(musica.getNome()).isPresent()){
            throw new RuntimeException("Musica Já cadastrada");
        }

        return musicaRepository.save(musica);

    }

    public Musica atualizar(@Valid Musica musica){

        Musica musicaAtualizar = musicaRepository.findById(musica.getId())
                .orElseThrow(() -> new RuntimeException("Musica não existente cadastrada"));

        musicaAtualizar.setNome(musica.getNome());
        musicaAtualizar.setGenero(musica.getGenero());

        return musicaRepository.save(musicaAtualizar);
    }

    public void excluir(long id){

        Musica musicaAtualizar = musicaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Musica Já cadastrada"));

        musicaRepository.deleteById(musicaAtualizar.getId());
    }

}