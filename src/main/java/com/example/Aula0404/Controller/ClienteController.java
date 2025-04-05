package com.example.Aula0404.Controller;

import com.example.Aula0404.Models.Cliente;
import com.example.Aula0404.Services.ClienteServices;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
    public ClienteServices clienteServices;

    public ClienteController(ClienteServices clienteServices) {
        this.clienteServices = clienteServices;
    }

    @GetMapping
    public List<Cliente> listarTodos(){
        return clienteServices.listarTodos();
    }

    @PostMapping
    public ResponseEntity<Map<String, Object>> salvar(@Valid @RequestBody Cliente cliente){
        clienteServices.salvar(cliente);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(Map.of("Mensagem: ", "Cliente" + cliente.getNome() + "Cadastrado com Sucesso"));
    }

    @PutMapping
    public ResponseEntity<Map<String, Object>> atualizar(@Valid @RequestBody Cliente cliente){
        clienteServices.atualizar(cliente);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(Map.of("Mensagem: ", "Atualizado com Sucesso"));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Object>> atualizar(@PathVariable Long id){
        clienteServices.excluir(id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(Map.of("Mensagem: ", "Excluido com Sucesso"));
    }
}
