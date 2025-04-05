package com.example.Aula0404.Services;

import com.example.Aula0404.Models.Cliente;
import com.example.Aula0404.Repository.ClienteRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class ClienteServices {
    public ClienteRepository clienteRepository;

    public ClienteServices(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public List<Cliente> listarTodos(){
        return clienteRepository.findAll();
    }

    public Cliente salvar(@Valid Cliente cliente) {
        if (clienteRepository.findByEmail(cliente.getEmail()).isPresent()) {
            throw new RuntimeException("Cliente já cadastrado");

        }
        return clienteRepository.save(cliente);
    }

    public Cliente atualizar(@Valid Cliente cliente){
        Cliente clienteAtualizar = clienteRepository.findByEmail(cliente.getEmail())
                .orElseThrow(() -> new RuntimeException("Cliente Já cadastrado"));

        clienteAtualizar.setNome(cliente.getNome());
        clienteAtualizar.setEmail(cliente.getEmail());
        clienteAtualizar.setTelefone(cliente.getTelefone());
        clienteAtualizar.setEndereco(cliente.getEndereco());

        return clienteRepository.save(clienteAtualizar);

    }

    public void excluir(long id){
        Cliente clienteAtualizar = clienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente Já cadastrado"));
        clienteRepository.deleteById(id);
    }


}
