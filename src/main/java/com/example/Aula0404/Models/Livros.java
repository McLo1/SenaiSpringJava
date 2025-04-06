package com.example.Aula0404.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Livros {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String titulo;
    private String autor;
    private String editora;

    public Livros() {
    }

    public Livros(int id, String titulo, String autor, String editora) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.editora = editora;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }
}
