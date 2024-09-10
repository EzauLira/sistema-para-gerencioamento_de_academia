package com.SistemaDeGerenciamentodeAcademia.SGA.utils.validadorCliente;

import com.SistemaDeGerenciamentodeAcademia.SGA.enuns.MensagemErro;
import com.SistemaDeGerenciamentodeAcademia.SGA.exception.IdadeException;

public class ValidarIDadeUtils {

    public static void validarIdade(int idade){

        if (idade < 15 ){
         throw new IdadeException(MensagemErro.IDADE_INVALIDA.getMensagem());
        }
    }
}
