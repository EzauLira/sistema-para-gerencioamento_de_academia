package com.SistemaDeGerenciamentodeAcademia.SGA.dto;


/**
 * Data Transfer Object (DTO) para representar os dados de um agendamento de treino na academia.
 * Este objeto é utilizado para transferir as informações necessárias para agendar um treino.
 */
public class AgendamentoDto {

    private int id;
    private String nome;
    private int treino;
    private String treinoNome;
    private int novoTreino;
    private String data;
    private String hora;
    private String senha;

    public AgendamentoDto(int id, String nome, int treino, int novoTreino, String data, String hora, String senha) {
        this.id = id;
        this.nome = nome;
        this.treino = treino;
        this.novoTreino = novoTreino;
        this.data = data;
        this.hora = hora;
        this.senha = senha;
    }

    public AgendamentoDto(int treino, int novoTreino, String data, String hora){
        this.treino = treino;
        this.novoTreino = novoTreino;
        this.data = data;
        this.hora = hora;
    }

    public AgendamentoDto(String nome, String treinoNome) {
        this.nome = nome;
        this.treinoNome = treinoNome;
    }

    public AgendamentoDto(String treinoNome, String data, String hora) {
        this.treinoNome = treinoNome;
        this.data = data;
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

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getNovoTreino() {
        return novoTreino;
    }

    public void setNovoTreino(int novoTreino) {
        this.novoTreino = novoTreino;
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
}
