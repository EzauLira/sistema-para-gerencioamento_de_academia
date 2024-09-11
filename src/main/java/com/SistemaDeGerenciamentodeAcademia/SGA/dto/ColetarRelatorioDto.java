package com.SistemaDeGerenciamentodeAcademia.SGA.dto;

/**
 * Data Transfer Object (DTO) para representar a coleta de um relatório com base no nome fornecido.
 * Este objeto é utilizado para transferir o nome necessário para gerar o relatório.
 */
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
