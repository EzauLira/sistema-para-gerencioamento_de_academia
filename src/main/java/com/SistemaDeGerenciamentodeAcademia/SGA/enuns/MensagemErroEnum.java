package com.SistemaDeGerenciamentodeAcademia.SGA.enuns;

/**
 * Enumeração para representar as mensagens de erro relacionadas a entradas inválidas
 * e outras condições de erro no sistema. Cada tipo de erro tem uma mensagem associada.
 */
public enum MensagemErroEnum {

    OPCAO_INVALIDA("Cadastro não concluído.\nOpção inválida! Digite uma opção válida."),
    GENERO_INVALIDO("Entrada inválida."),
    CPF_INVALIDO("CPF inválido."),
    IDADE_INVALIDA("A idade precisa ser maior que 15 anos."),
    TELEFONE_INVALIDO("Telefone inválido."),
    EMAIL_INVALIDO("Necessário que contenho um email valido."),
    DATA_INVALIDA("Data inválida. A data de agendamento não pode ser antes da data atual."),
    NOME_INVALIDO("Nome inválido.");

    private final String mensagem;

    /**
     * Construtor para criar uma nova instância {@link MensagemErroEnum}.
     *
     * @param mensagem A mensagem associada ao erro.
     */
    MensagemErroEnum(String mensagem){
        this.mensagem = mensagem;
    }

    /**
     * Obtém a mensagem associada ao erro.
     *
     * @return A mensagem do erro.
     */
    public String getMensagem(){
        return mensagem;
    }
}
