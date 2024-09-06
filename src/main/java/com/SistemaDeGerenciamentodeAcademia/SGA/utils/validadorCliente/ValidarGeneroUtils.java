package com.SistemaDeGerenciamentodeAcademia.SGA.utils.validadorCliente;

import com.SistemaDeGerenciamentodeAcademia.SGA.enuns.MensagemErro;
import com.SistemaDeGerenciamentodeAcademia.SGA.exception.GeneroException;

public class ValidarGeneroUtils {

    public static void validarGenero(String genero) {

        genero = genero.toLowerCase();

        if (genero.equals("m") || genero.equals("f") || genero.equals("masculino") || genero.equals("feminito")){

        } else if (genero.trim().isEmpty()) {
            throw new GeneroException(MensagemErro.GENERO_INVALIDO.getMensagem());
        }else {
            throw new GeneroException(MensagemErro.GENERO_INVALIDO.getMensagem());
        }
    }
}