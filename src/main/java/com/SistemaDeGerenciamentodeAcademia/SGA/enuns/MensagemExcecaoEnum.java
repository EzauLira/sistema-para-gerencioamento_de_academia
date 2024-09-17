package com.SistemaDeGerenciamentodeAcademia.SGA.enuns;

/**
 * Enumeração para representar mensagens de exceção relacionadas a entradas inválidas
 * e outras condições de erro específicas no sistema. Cada tipo de exceção tem uma mensagem associada.
 */
public enum MensagemExcecaoEnum {

    ENTRADA_INVALIDA("Entrada inválida. Necessário que seja um número."),
    NOME_INVALIDO("\nNome inválido. Necessário que tenha no mínimo 10 caracteres.\n"),
    IDADE_INVALIDA("\nA idade precisa ser maior que 15 anos.\n"),
    TELEFONE_INVALIDO("\nTelefone inválido.\n"),
    EMAIL_INVALIDO("\nNecessário que contenho um email valido.\n"),
    DATA_INVALIDA("\nData inválida. necessária que seja no formato Dia/Mês/Ano\n"),
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
