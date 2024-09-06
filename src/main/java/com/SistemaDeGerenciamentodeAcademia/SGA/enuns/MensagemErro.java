package com.SistemaDeGerenciamentodeAcademia.SGA.enuns;

public enum MensagemErro {

    OPCAO_INVALIDA("Cadastro não concluído.\nOpção inválida! Digite uma opção válida."),
    GENERO_INVALIDO("Entrada inválida."),
    CPF_INVALIDO("CPF inválido."),
    IDADE_INVALIDA("A idade precisa ser maior que 15 anos."),
    TELEFONE_INVALIDO("Telefone inválido."),
    EMAIL_INVALIDO("Necessário que contenho um email valido."),
    NOME_INVALIDO("Nome inválido.");

    private final String mensagem;

    MensagemErro(String mensagem){
        this.mensagem = mensagem;
    }

    public String getMensagem(){
        return mensagem;
    }
}
