package com.SistemaDeGerenciamentodeAcademia.SGA.dto;

public class TreinosAtivosEInativosDto {

    private int id;
    private String nome;
    private String data;
    private String hora;


    public TreinosAtivosEInativosDto(int id, String nome, String data, String hora) {
        this.id = id;
        this.nome = nome;
        this.data = data;
        this.hora = hora;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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
