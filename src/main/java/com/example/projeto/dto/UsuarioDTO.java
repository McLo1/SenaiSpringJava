package com.example.projeto.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class UsuarioDTO {

    @NotBlank(message = "O nome é obrigatorio")
    private String nome;

    @NotBlank(message = "O e-mail é obrigatorio")
    @Email(message = "Deve ser um e-mail valido")
    private String email;

    @NotBlank(message = "A senha é obrigatoria")
    private String senha;

    public UsuarioDTO() {
    }

    public UsuarioDTO(String nome, String email, String senha) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }

    public @NotBlank(message = "O nome é obrigatorio") String getNome() {
        return nome;
    }

    public void setNome(@NotBlank(message = "O nome é obrigatorio") String nome) {
        this.nome = nome;
    }

    public @NotBlank(message = "O e-mail é obrigatorio") @Email(message = "Deve ser um e-mail valido") String getEmail() {
        return email;
    }

    public void setEmail(@NotBlank(message = "O e-mail é obrigatorio") @Email(message = "Deve ser um e-mail valido") String email) {
        this.email = email;
    }

    public @NotBlank(message = "A senha é obrigatoria") String getSenha() {
        return senha;
    }

    public void setSenha(@NotBlank(message = "A senha é obrigatoria") String senha) {
        this.senha = senha;
    }
}
