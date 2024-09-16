package com.SistemaDeGerenciamentodeAcademia.SGA.exception;

import com.SistemaDeGerenciamentodeAcademia.SGA.enuns.ErroBancoDadosEnum;

/**
 * Exceção lançada para tratamento de erros relacionados a operações SQL.
 * Inclui um método estático para mapear e exibir mensagens de erro específicas do banco de dados.
 */
public class SqlException extends RuntimeException {

    /**
     * Mapeia e exibe uma mensagem personalizada para erros SQL com base na mensagem da exceção fornecida.
     *
     * @param e A exceção que contém a mensagem de erro SQL.
     */
    public static void sqlException(Exception e) {
        ErroBancoDadosEnum erroBancoDadosEnum = ErroBancoDadosEnum.mensagemDoBanco(e.getMessage());
        System.out.println(erroBancoDadosEnum.getMensagemCustom());
    }
}
