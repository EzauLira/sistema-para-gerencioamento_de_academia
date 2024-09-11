package com.SistemaDeGerenciamentodeAcademia.SGA.enuns;

/**
 * Enumeração para representar mensagens de exceção relacionadas a entradas inválidas
 * e outras condições de erro específicas no sistema. Cada tipo de exceção tem uma mensagem associada.
 */
public enum MensagemExcecao {

    ENTRADA_INVALIDA("Entrada inválida. Necessário que seja um número."),
    NOME_INVALIDO("Nome inválido. Necessário que tenha no mínimo 10 caracteres.\n"),
    IDADE_INVALIDA("A idade precisa ser maior que 15 anos."),
    GENERO_INVALIDO("Entrada inválida. Digite 'M' para masculino ou 'F' para feminino."),
    TELEFONE_INVALIDO("Telefone inválido."),
    EMAIL_INVALIDO("Necessário que contenho um email valido."),
    CPF_INVALIDO("CPF inválido. Necessário que seja no mínimo 11 digitos.");

    private final String mensagem;

    /**
     * Construtor para criar uma nova instância {@link MensagemExcecao}.
     *
     * @param mensagem A mensagem associada à exceção.
     */
    MensagemExcecao(String mensagem){
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
