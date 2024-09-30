package com.SistemaDeGerenciamentodeAcademia.SGA.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Instrutor {
    private String nome;
    private String cpf;
    private int genero;
    private String telefone;
    private String email;
    private String senha;

//    public Instrutor(String nome, String cpf, int genero, String telefone, String email, String senha) {
//        this.nome = nome;
//        this.cpf = cpf;
//        this.genero = genero;
//        this.telefone = telefone;
//        this.email = email;
//        this.senha = senha;
//    }
//
//    public String getNome() {
//        return nome;
//    }
//
//    public void setNome(String nome) {
//        this.nome = nome;
//    }
//
//    public String getCpf() {
//        return cpf;
//    }
//
//    public void setCpf(String cpf) {
//        this.cpf = cpf;
//    }
//
//    public int getGenero() {
//        return genero;
//    }
//
//    public void setGenero(int genero) {
//        this.genero = genero;
//    }
//
//    public String getTelefone() {
//        return telefone;
//    }
//
//    public void setTelefone(String telefone) {
//        this.telefone = telefone;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public String getSenha() {
//        return senha;
//    }
//
//    public void setSenha(String senha) {
//        this.senha = senha;
//    }
}
