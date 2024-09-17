package com.SistemaDeGerenciamentodeAcademia.SGA.enuns;

public enum OpcoesInstrutorEnum {

    OPCOES_INSTRUTOR("""
              ╔═══════════════════════════════════════════╗
              ║             Olá instrutor!                ║
              ║ Insira seu CPF e Senha para efetuar login ║
              ╚═══════════════════════════════════════════╝""");


    private final String mensagem;

    OpcoesInstrutorEnum(String mensagem){
        this.mensagem = mensagem;
    }

    public String getMensagem(){
        return mensagem;
    }
}
