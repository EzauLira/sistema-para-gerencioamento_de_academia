package com.SistemaDeGerenciamentodeAcademia.SGA.enuns;

/**
 * Enumeração para representar mensagens de sucesso relacionadas a operações realizadas
 * no sistema. Cada tipo de sucesso tem uma mensagem associada.
 */
public enum MensagemSucessoEnum {
    AGENDAMENTO_EFETUADO("Agendamento efetuado com sucesso!"),
    AGENDAMENTO_ATIALIZADO("\nAgendamento atualizado com sucesso!"),
    AGENDAMENTO_CANCELADO("\nAgendamento cancelado com sucesso!"),
    CADASTRO_EFETUADO("Cadastro efetuado com sucesso!");

    private final String mensagem;

    /**
     * Construtor para criar uma nova instância {@link MensagemSucessoEnum}.
     *
     * @param mensagem A mensagem associada ao sucesso.
     */
    MensagemSucessoEnum(String mensagem){
        this.mensagem = mensagem;
    }

    /**
     * Obtém a mensagem associada ao sucesso.
     *
     * @return A mensagem do sucesso.
     */
    public String getMensagem(){
        return mensagem;
    }

}