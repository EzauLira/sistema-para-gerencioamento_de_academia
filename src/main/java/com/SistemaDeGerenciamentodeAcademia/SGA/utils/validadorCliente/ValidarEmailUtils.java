package com.SistemaDeGerenciamentodeAcademia.SGA.utils.validadorCliente;

import com.SistemaDeGerenciamentodeAcademia.SGA.enuns.MensagemErroEnum;
import com.SistemaDeGerenciamentodeAcademia.SGA.exception.EmailException;

/**
 * Classe utilitária para validação de e-mails.
 */
public class ValidarEmailUtils {

    /**
     * Valida o e-mail fornecido.
     * Lança uma exceção se o e-mail for inválido.
     *
     * @param email E-mail a ser validado.
     */
    public static void validarEmail(String email){

        if (email.trim().isEmpty() || !email.contains("@") && !email.contains(".com")){
            throw new EmailException(MensagemErroEnum.EMAIL_INVALIDO.getMensagem());
        }
    }
}
