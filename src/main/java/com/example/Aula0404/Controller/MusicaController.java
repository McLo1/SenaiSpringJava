package com.example.Aula0404.Controller;

import com.example.Aula0404.Models.Musica;
import com.example.Aula0404.Services.MusicaService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/musica")
public class MusicaController {

    public MusicaService musicaService;

    public MusicaController(MusicaService musicaService) {
        this.musicaService = musicaService;
    }

    @GetMapping
    public List<Musica> listarTodos(){
        return musicaService.listarTodos();
    }

    @PostMapping
    public ResponseEntity<Map<String, Object>> salvar(@Valid @RequestBody Musica musica){
        musicaService.salvar(musica);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(Map.of("Mensagem: " + musica.getNome(), " Cadastrado com Sucesso"));
    }

    @PutMapping
    public ResponseEntity<Map<String, Object>> atualizar(@Valid @RequestBody Musica musica){
        musicaService.atualizar(musica);

        return ResponseEntity.status(HttpStatus.OK)
                .body(Map.of("Mensagem: " + musica.getNome(), "Editada com Sucesso"));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Object>> excluir(@PathVariable long id){
        musicaService.excluir(id);

        return ResponseEntity.status(HttpStatus.OK)
                .body(Map.of("Mensagem: " ,"Excluido com Sucesso"));
    }

}
