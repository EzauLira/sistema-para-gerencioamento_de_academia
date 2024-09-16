package com.SistemaDeGerenciamentodeAcademia.SGA.utils.validadorCliente;

import com.SistemaDeGerenciamentodeAcademia.SGA.enuns.MensagemErroEnum;
import com.SistemaDeGerenciamentodeAcademia.SGA.exception.IdadeException;

/**
 * Classe utilitária para validação de idade.
 */
public class ValidarIDadeUtils {

    /**
     * Valida a idade fornecida.
     * Lança uma exceção se a idade for inválida.
     *
     * @param idade Idade a ser validada.
     */
    public static void validarIdade(int idade){

        if (idade < 15 ){
            throw new IdadeException(MensagemErroEnum.IDADE_INVALIDA.getMensagem());
        }
    }
}
