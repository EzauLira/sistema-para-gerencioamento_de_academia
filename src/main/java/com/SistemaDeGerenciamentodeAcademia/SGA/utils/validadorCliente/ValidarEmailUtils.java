package com.SistemaDeGerenciamentodeAcademia.SGA.utils.validadorCliente;

import com.SistemaDeGerenciamentodeAcademia.SGA.enuns.MensagemErro;
import com.SistemaDeGerenciamentodeAcademia.SGA.exception.EmailException;

public class ValidarEmailUtils {

    public static void validarEmail(String email){

        if (email.trim().isEmpty()){
            throw new EmailException(MensagemErro.EMAIL_INVALIDO.getMensagem());
        }
    }
}
