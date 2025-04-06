package com.example.Aula0404.Controller;

import com.example.Aula0404.Models.Livros;
import com.example.Aula0404.Services.LivrosServices;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/livros")
public class LivrosController {
    public LivrosServices livrosServices;

    public LivrosController(LivrosServices livrosServices) {
        this.livrosServices = livrosServices;
    }

    @GetMapping
    public List<Livros> listarTodos(){
        return livrosServices.listarTodos();
    }

    @PostMapping
    public ResponseEntity<Map<String,Object>> salvar(@Valid @RequestBody Livros livros){
        livrosServices.salvar(livros);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(Map.of("mensagem: " + livros.getTitulo()," Salvo com sucesso"));
    }

    @PutMapping
    public ResponseEntity<Map<String,Object>> atualizar(@Valid @RequestBody Livros livros) {
        livrosServices.atualizar(livros);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(Map.of("mensagem: " + livros.getTitulo(), " Atualizado com sucesso"));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String,Object>> excluir(@PathVariable long id) {
        livrosServices.excluir(id);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(Map.of("mensagem: ",  " Excluido com sucesso"));
    }
}
