package com.SistemaDeGerenciamentodeAcademia.SGA.dto;

public class BuscarClienteDto {

    private String nome;

    public BuscarClienteDto(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
