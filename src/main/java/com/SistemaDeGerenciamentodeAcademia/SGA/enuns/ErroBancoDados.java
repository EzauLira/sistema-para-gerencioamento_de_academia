package com.SistemaDeGerenciamentodeAcademia.SGA.enuns;

public enum ErroBancoDados {

    MESMO_TREINO("O mesmo treino já está agendado", "O mesmo treino já está agendado para este cliente nesta data."),
    JA_EXISTE_TREINO("Já existe um treino agendado", "Já existe um treino agendado para este cliente nesta data e hora. Deve haver pelo menos 30 minutos de diferença entre os treinos."),
    CLIENTE_NAO_ENCONTRADO("Cliente não encontrado", "Cliente não encontrado. Por favor cadastre o cliente ou reveja o nome digitado."),
    NOME_JA_CADASTRADO("Erro: Nome já cadastrado.", "Nome já está cadastrado."),
    CPF_JA_CADASTRADO("Erro: CPF já cadastrado.", "CPF já está cadastrado."),
    TELEFONE_JA_CADASTRADO("Erro: Telefone já cadastrado.", "Telefone já está cadastrado."),
    EMAIL_JA_CADASTRADO("Erro: Email já cadastrado.", "Email já está cadastrado."),
    SUCESSO("Cliente cadastrado com sucesso.", "Cliente cadastrado com sucesso."),
    OUTRO_ERRO("Outro erro", "Erro desconhecido");

    private final String mensagem;
    private final String mensagemCustom;

    ErroBancoDados(String mensagem, String mensagemCustom) {
        this.mensagem = mensagem;
        this.mensagemCustom = mensagemCustom;
    }

    public static ErroBancoDados novaMensagem(String message) {
        for (ErroBancoDados code : ErroBancoDados.values()) {
            if (message.contains(code.mensagem)) {
                return code;
            }
        }
        return OUTRO_ERRO;
    }

    public String getMensagemCustom() {
        return mensagemCustom;
    }
}