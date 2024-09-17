package com.SistemaDeGerenciamentodeAcademia.SGA.dto;


/**
 * Data Transfer Object (DTO) para representar os dados de um agendamento de treino na academia.
 * Este objeto é utilizado para transferir as informações necessárias para agendar um treino.
 */
public class AgendamentoDto {

    private String nome;
    private int treino;
    private int novoTreino;
    private String data;
    private String hora;
    private String senha;

    public AgendamentoDto(String nome, int treino, String data, String hora){
        this.nome = nome;
        this.treino = treino;
        this.data = data;
        this.hora = hora;
    }

    public AgendamentoDto(int treino, int novoTreino, String data, String hora){
        this.treino = treino;
        this.novoTreino = novoTreino;
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
}
