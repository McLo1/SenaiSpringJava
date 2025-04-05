package com.example.Aula0404.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
public class Funcionario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank(message = "Insira o nome do Funcionario")
    private String Nome;
    @NotBlank(message = "Insira um CPF valido")
    @Size(min = 11,max = 11, message = "Um CPF contém 11 digitos")
    private String CPF;
    @NotBlank(message = "Insira o seu RG")
    @Size(min = 7, max = 9, message = "Insira um RG valido")
    private String rg;
    @NotBlank(message = "Insira a sua matricula")
    private String matricula;
    @NotBlank(message = "Insira o setor que você trabalha")
    private String setor;
    @NotBlank(message = "Insira o salario do Funcionario")
    private double salario;

    public Funcionario() {
    }

    public Funcionario(long id, String nome, String CPF, String rg, String matricula, String setor, double salario) {
        this.id = id;
        Nome = nome;
        this.CPF = CPF;
        this.rg = rg;
        this.matricula = matricula;
        this.setor = setor;
        this.salario = salario;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
}
