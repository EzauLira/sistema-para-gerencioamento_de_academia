package com.SistemaDeGerenciamentodeAcademia.SGA.enuns;

/**
 * Enumeração para representar mensagens de exceção relacionadas a entradas inválidas
 * e outras condições de erro específicas no sistema. Cada tipo de exceção tem uma mensagem associada.
 */
public enum MensagemExcecaoEnum {

    ENTRADA_INVALIDA("Entrada inválida. Necessário que seja um número."),
    NOME_INVALIDO("\nNome inválido. Necessário que tenha no mínimo 10 caracteres.\n"),
    IDADE_INVALIDA("\nA idade precisa ser maior que 15 anos.\n"),
    TELEFONE_INVALIDO("\nTelefone inválido. O telefone deve conter exatamente 11 dígitos numéricos, o DDD deve estar entre 01 e 99, o número de celular deve começar com 9 e não pode ter todos os dígitos iguais.\n"),
    EMAIL_INVALIDO("\nNecessário que contenho um email valido.\n"),
    HORA_INVALIDA("Hora inválida. Por favor, use o formato HH:mm."),
    DATA_INVALIDA("\nData inválida. necessária que seja no formato 01/01/2024\n"),
    CPF_INVALIDO("\nCPF inválido. O CPF deve conter exatamente 11 dígitos numéricos e não pode conter todos os dígitos iguais. \n");

    private final String mensagem;

    /**
     * Construtor para criar uma instância {@link MensagemExcecaoEnum}.
     *
     * @param mensagem A mensagem associada à exceção.
     */
    MensagemExcecaoEnum(String mensagem){
        this.mensagem = mensagem;
    }

    /**
     * Obtém a mensagem associada à exceção.
     *
     * @return A mensagem da exceção.
     */
    public String getMensagem(){
        return mensagem;
    }

}
