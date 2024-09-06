package com.SistemaDeGerenciamentodeAcademia.SGA.exception;

import com.SistemaDeGerenciamentodeAcademia.SGA.enuns.ErroBancoDados;

public class SqlException extends RuntimeException {

    public static void sqlException(Exception e) {
        ErroBancoDados erroBancoDados = ErroBancoDados.novaMensagem(e.getMessage());
        System.out.println(erroBancoDados.getMensagemCustom());
    }
}
