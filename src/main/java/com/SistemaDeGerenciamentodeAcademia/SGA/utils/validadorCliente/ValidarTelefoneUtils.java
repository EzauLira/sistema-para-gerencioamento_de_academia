package com.SistemaDeGerenciamentodeAcademia.SGA.utils.validadorCliente;

import com.SistemaDeGerenciamentodeAcademia.SGA.enuns.MensagemErro;
import com.SistemaDeGerenciamentodeAcademia.SGA.exception.TelefoneException;

public class ValidarTelefoneUtils {

    public static void validarTelefone(String telefone){

        if (telefone.trim().isEmpty() || telefone.length() != 12){
            throw new TelefoneException(MensagemErro.TELEFONE_INVALIDO.getMensagem());
        }
    }
}
