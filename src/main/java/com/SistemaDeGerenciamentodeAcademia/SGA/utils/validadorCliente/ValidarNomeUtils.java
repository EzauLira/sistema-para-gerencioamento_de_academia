package com.SistemaDeGerenciamentodeAcademia.SGA.utils.validadorCliente;

import com.SistemaDeGerenciamentodeAcademia.SGA.enuns.MensagemErroEnum;
import com.SistemaDeGerenciamentodeAcademia.SGA.exception.NomeException;

/**
 * Classe utilitária para validação de nomes.
 */
public class ValidarNomeUtils {

    /**
     * Valida o nome fornecido.
     * Lança uma exceção se o nome for inválido.
     *
     * @param nome Nome a ser validado.
     */
    public static void validarNome(String nome) {

        if (nome.trim().isEmpty() || nome.length() < 10 || nome.matches(".*\\d.*")) {
            throw new NomeException(MensagemErroEnum.NOME_INVALIDO.getMensagem());
        }
    }
}
