package com.SistemaDeGerenciamentodeAcademia.SGA.dto;


/**
 * Data Transfer Object (DTO) para representar os dados de um plano na academia.
 * Este objeto é utilizado para transferir informações sobre planos disponíveis.
 */
public class PlanosDto {

    private int id;
    private String nome;
    private String descricao;
    private int duracao;
    private int preco;


    public PlanosDto(int id, String nome, String descricao, int duracao, int preco) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.duracao = duracao;
        this.preco = preco;
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getDuracao() {
        return duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }

    public int getPreco() {
        return preco;
    }

    public void setPreco(int preco) {
        this.preco = preco;
    }
}
