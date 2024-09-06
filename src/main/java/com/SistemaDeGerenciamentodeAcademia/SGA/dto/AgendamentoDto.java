package com.SistemaDeGerenciamentodeAcademia.SGA.dto;

public class AgendamentoDto {

    private String nome;
    private int treino;
    private String data;
    private String hora;

    public AgendamentoDto(String nome, int treino, String data, String hora ){

        this.nome = nome;
        this.treino = treino;
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

}
