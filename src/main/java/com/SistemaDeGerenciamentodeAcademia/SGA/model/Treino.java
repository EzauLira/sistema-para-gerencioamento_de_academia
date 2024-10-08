package com.SistemaDeGerenciamentodeAcademia.SGA.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Classe para representar um treino na academia.
 * Esta classe é usada para armazenar as informações de um treino.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Treino {

    private int id;
    private String nome;
    private String descricao;

//    public Treino(int id, String nome, String descricao){
//        this.id = id;
//        this.nome = nome;
//        this.descricao = descricao;
//    }
//
//    public int getId(){
//        return id;
//    }
//    public void setId(int id){
//        this.id = id;
//    }
//    public String getNome(){
//        return nome;
//    }
//    public void setNome(String nome) {
//        this.nome = nome;
//    }
//    public String getDescricao() {
//        return descricao;
//    }
//    public void setDescricao(String descricao) {
//        this.descricao = descricao;
//    }
}
