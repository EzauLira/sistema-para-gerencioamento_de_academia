package com.SistemaDeGerenciamentodeAcademia.SGA.enuns;

public enum MensagemSucesso {

    CONEXAO_EFETUADA("Conexão efetuada com sucesso!"),
    AGENDAMENTO_EFETUADO("Agendamento efetuada com sucesso!"),
    CADASTRO_EFETUADO("Cadastro efetuado com sucesso!");

    private final String mensagem;

    MensagemSucesso(String mensagem){
        this.mensagem = mensagem;
    }
    public String getMensagem(){
        return mensagem;
    }

}