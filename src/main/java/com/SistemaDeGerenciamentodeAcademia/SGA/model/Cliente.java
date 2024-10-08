package com.SistemaDeGerenciamentodeAcademia.SGA.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Classe para representar um cliente na academia.
 * Esta classe é usada para armazenar as informações do cliente.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Cliente {

    private String nome;
    private int idade;
    private String cpf;
    private int genero;
    private String telefone;
    private String email;
    private int idPlano;
    private String senha;
    private String planoNome;

//    public Cliente(String nome, String cpf, String telefone, String email) {
//        this.nome = nome;
//        this.cpf = cpf;
//        this.telefone = telefone;
//        this.email = email;
//    }
//
//    public Cliente(String nome, int idade, String cpf, int genero, String telefone, String email, String senha, int idPlano) {
//        this.nome = nome;
//        this.idade = idade;
//        this.cpf = cpf;
//        this.genero = genero;
//        this.telefone = telefone;
//        this.email = email;
//        this.senha = senha;
//        this.idPlano = idPlano;
//
//    }
//
//    public Cliente(String nome, String cpf, String telefone, String email, String senha, String planoNome) {
//        this.nome = nome;
//        this.cpf = cpf;
//        this.telefone = telefone;
//        this.email = email;
//        this.senha = senha;
//        this.planoNome = planoNome;
//    }
//
//    public String getNome() {
//        return nome;
//    }
//
//    public int getIdade() {
//        return idade;
//    }
//
//    public void setIDade(int idade) {
//        this.idade = idade;
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
//    public void setCpf(String cfp) {
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
//    public void setIdade(int idade) {
//        this.idade = idade;
//    }
//
//    public int getIdPlano() {
//        return idPlano;
//    }
//
//    public void setIdPlano(int idPlano) {
//        this.idPlano = idPlano;
//    }
//
//    public String getSenha() {
//        return senha;
//    }
//
//    public void setSenha(String senha) {
//        this.senha = senha;
//    }
//
//    public String getPlano_nome() {
//        return planoNome;
//    }
//
//    public void setPlano_nome(String planoNome) {
//        this.planoNome = planoNome;
//    }
}
