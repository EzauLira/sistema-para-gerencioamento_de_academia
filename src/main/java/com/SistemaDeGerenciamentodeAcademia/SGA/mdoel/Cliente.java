package com.SistemaDeGerenciamentodeAcademia.SGA.mdoel;

/**
 * Classe para representar um cliente na academia.
 * Esta classe é usada para armazenar as informações do cliente.
 */
public class Cliente {

    private String nome;
    private int idade;
    private String cpf;
    private String genero;
    private String telefone;
    private String email;
    private int idPlano;

    public Cliente( String nome, int idade, String cpf, String genero, String telefone, String email, int idPlano) {
        this.nome = nome;
        this.idade = idade;
        this.cpf = cpf;
        this.genero = genero;
        this.telefone = telefone;
        this.email = email;
        this.idPlano = idPlano;
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIDade(int idade) {
        this.idade = idade;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cfp) {
        this.cpf = cpf;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
