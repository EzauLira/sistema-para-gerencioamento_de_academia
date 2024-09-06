package com.SistemaDeGerenciamentodeAcademia.SGA.dto;

public class ColetarRelatorioDto {

    private String nome;

    public ColetarRelatorioDto(String nome){
        this.nome = nome;
    }

    public String getNome(){
        return nome;
    }
    public void setNome(String nome){
        this.nome = nome;
    }

}
