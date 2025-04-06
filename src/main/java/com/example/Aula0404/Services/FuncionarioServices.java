package com.example.Aula0404.Services;

import com.example.Aula0404.Models.Funcionario;
import com.example.Aula0404.Models.Usuario;
import com.example.Aula0404.Repository.FuncionarioRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class FuncionarioServices {
    private FuncionarioRepository funcionarioRepository;

    public FuncionarioServices(FuncionarioRepository funcionarioRepository) {
        this.funcionarioRepository = funcionarioRepository;
    }

    public List<Funcionario> listarTodos(){
        return funcionarioRepository.findAll();
    }

    public Funcionario salvar(@Valid Funcionario funcionario){
        if (funcionarioRepository.findByMatricula(funcionario.getMatricula()).isPresent()){
            throw new RuntimeException("Funcionario Já cadastrado");
        }
        return funcionarioRepository.save(funcionario);
    }

    public Funcionario atualizar(@Valid Funcionario funcionario){
        Funcionario funcionarioAtualizar = funcionarioRepository.findByMatricula(funcionario.getMatricula())
                .orElseThrow(() -> new RuntimeException("Funcionario não existe"));

        funcionarioAtualizar.setNome(funcionario.getNome());
        funcionarioAtualizar.setCPF(funcionario.getCPF());
        funcionarioAtualizar.setRg(funcionario.getRg());
        funcionarioAtualizar.setMatricula(funcionario.getMatricula());
        funcionarioAtualizar.setSetor(funcionario.getSetor());
        funcionarioAtualizar.setSalario(funcionario.getSalario());

        return funcionarioRepository.save(funcionarioAtualizar);
    }

    public void excluir(String matricula){
        Funcionario funcionarioAtualizar = funcionarioRepository.findByMatricula(matricula)
                .orElseThrow(() -> new RuntimeException("Funcionario não existe"));

        funcionarioRepository.deleteById(funcionarioAtualizar.getId());
    }

}