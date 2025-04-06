package com.example.Aula0404.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Entity
public class Livros {

    @Setter
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank(message = "Insira um titulo para o livro")
    private String titulo;

    @NotBlank(message = "Insira o nome do autor do livro")
    private String autor;

    @NotBlank(message = "Insira o nome da editora do livro")
    private String editora;

    public Livros() {
    }

    public Livros(int id, String titulo, String autor, String editora) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.editora = editora;
    }

    public @NotBlank(message = "Insira um titulo para o livro") String getTitulo() {
        return titulo;
    }

    public void setTitulo(@NotBlank(message = "Insira um titulo para o livro") String titulo) {
        this.titulo = titulo;
    }

    public @NotBlank(message = "Insira o nome do autor do livro") String getAutor() {
        return autor;
    }

    public void setAutor(@NotBlank(message = "Insira o nome do autor do livro") String autor) {
        this.autor = autor;
    }

    public @NotBlank(message = "Insira o nome da editora do livro") String getEditora() {
        return editora;
    }

    public void setEditora(@NotBlank(message = "Insira o nome da editora do livro") String editora) {
        this.editora = editora;
    }
}
