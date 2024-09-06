package com.SistemaDeGerenciamentodeAcademia.SGA.mdoel;


public class Cliente {

    private String nome;
    private int idade;
    private String cfp;
    private String genero;
    private String telefone;
    private String email;
    private int idPlano;

    public Cliente( String nome, int idade, String cfp, String genero, String telefone, String email, int idPlano) {
        this.nome = nome;
        this.idade = idade;
        this.cfp = cfp;
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

    public String getCfp() {
        return cfp;
    }

    public void setCfp(String cfp) {
        this.cfp = cfp;
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
