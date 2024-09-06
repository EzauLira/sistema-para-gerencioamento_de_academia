package com.SistemaDeGerenciamentodeAcademia.SGA.utils.validadorCliente;

import com.SistemaDeGerenciamentodeAcademia.SGA.enuns.MensagemErro;
import com.SistemaDeGerenciamentodeAcademia.SGA.exception.NomeException;

public class ValidarNomeUtils {

    public static void validarNome(String nome) {

        if (nome.trim().isEmpty() || nome.length() < 10) {
            throw new NomeException(MensagemErro.NOME_INVALIDO.getMensagem());
        }
    }
}

