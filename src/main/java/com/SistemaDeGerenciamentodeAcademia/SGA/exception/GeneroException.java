package com.SistemaDeGerenciamentodeAcademia.SGA.exception;

/**
 * Exceção lançada quando um gênero inválido é encontrado ou quando ocorre um erro relacionado ao gênero.
 */
public class GeneroException extends RuntimeException{

    /**
     * Construtor para criar uma nova instância {@link GeneroException}.
     *
     * @param mensagem A mensagem detalhando o erro relacionado ao gênero.
     */
    public GeneroException(String mensagem){
        super(mensagem);
    }
}
