package com.SistemaDeGerenciamentodeAcademia.SGA.exception;

/**
 * Exceção lançada quando um nome inválido é encontrado ou quando ocorre um erro relacionado ao nome.
 */
public class NomeException extends RuntimeException {

    /**
     * Construtor para criar uma nova instância {@link NomeException}.
     *
     * @param mensagem A mensagem detalhando o erro relacionado ao nome.
     */
    public NomeException(String mensagem) {
        super(mensagem);
    }
}
