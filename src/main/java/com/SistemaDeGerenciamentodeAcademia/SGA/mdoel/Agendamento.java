package com.SistemaDeGerenciamentodeAcademia.SGA.mdoel;

/**
 * Classe para representar um agendamento de treino na academia.
 * Esta classe é usada para armazenar as informações do agendamento.
 */
public class Agendamento {

    private int id;
    private String nome;
    private int treino;
    private String treinoNome;
    private int novoTreino;
    private String data;
    private String hora;
    private String senha;

    public void Agendamento(String nome, int treino, String data, String hora){
        this.nome = nome;
        this.treino = treino;
        this.data = data;
        this.hora = hora;
    }

    public Agendamento(String nome, String treinoNome) {
        this.nome = nome;
        this.treinoNome = treinoNome;
    }

    public Agendamento(String treinoNome, String data, String hora) {
        this.treinoNome = treinoNome;
        this.data = data;
        this.hora = hora;
    }

    public Agendamento(int treino, int novoTreino, String data, String hora) {
        this.treino = treino;
        this.novoTreino = novoTreino;
        this.hora = hora;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getTreino() {
        return treino;
    }

    public void setTreino(int treino) {
        this.treino = treino;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTreinoNome() {
        return treinoNome;
    }

    public void setTreinoNome(String treinoNome) {
        this.treinoNome = treinoNome;
    }

    public int getNovoTreino() {
        return novoTreino;
    }

    public void setNovoTreino(int novoTreino) {
        this.novoTreino = novoTreino;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
