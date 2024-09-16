package com.SistemaDeGerenciamentodeAcademia.SGA.enuns;

public enum OpcoesInstrutorEnum {

    OPCOES_INSTRUTOR("""
              ╔════════════════════════════════════════════╗
              ║ Você deseja Fazer login ou se cadastrar?   ║
              ║ [1] - LOGIN                                ║
              ║ [2] - CADASTRAR                            ║
              ╚════════════════════════════════════════════╝
              Digite uma opção:""");


    private final String mensagem;

    OpcoesInstrutorEnum(String mensagem){
        this.mensagem = mensagem;
    }

    public String getMensagem(){
        return mensagem;
    }
}
