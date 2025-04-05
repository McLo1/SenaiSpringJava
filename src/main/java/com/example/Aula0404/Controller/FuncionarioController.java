package com.example.Aula0404.Controller;

import com.example.Aula0404.Models.Funcionario;
import com.example.Aula0404.Services.FuncionarioServices;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/funcionario")
public class FuncionarioController {

    public FuncionarioServices funcionarioServices;

    public FuncionarioController(FuncionarioServices funcionarioServices) {
        this.funcionarioServices = funcionarioServices;
    }

    @GetMapping
    public List<Funcionario> ListarTodos(){
        return funcionarioServices.listarTodos();
    }

    @PostMapping
    public ResponseEntity<Map<String, Object>> salvar(@Valid @RequestBody Funcionario funcionario){
        funcionarioServices.salvar(funcionario);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(Map.of("Mensagem: ", "Funcionario" + funcionario.getNome() + "Cadastrado com Sucesso"));
    }

    @PutMapping
    public ResponseEntity<Map<String, Object>> atualizar(@Valid @RequestBody Funcionario funcionario) {
        funcionarioServices.atualizar(funcionario);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(Map.of("Mensagem: ", "Funcionario" + funcionario.getNome() + "Atualizado com Sucesso"));
    }

    @DeleteMapping("/{matricula}")
    public ResponseEntity<Map<String, Object>> excluir(@PathVariable String matricula) {
        funcionarioServices.excluir(matricula);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(Map.of("mensagem","Usuário exluído com sucesso."));
    }
}
