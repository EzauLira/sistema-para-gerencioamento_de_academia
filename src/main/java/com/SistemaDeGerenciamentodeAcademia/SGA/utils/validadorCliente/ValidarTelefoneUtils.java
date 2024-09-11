package com.SistemaDeGerenciamentodeAcademia.SGA.utils.validadorCliente;

import com.SistemaDeGerenciamentodeAcademia.SGA.enuns.MensagemErro;
import com.SistemaDeGerenciamentodeAcademia.SGA.exception.TelefoneException;

/**
 * Classe utilitária para validação de telefones.
 */
public class ValidarTelefoneUtils {

    /**
     * Valida o telefone fornecido.
     * Lança uma exceção se o telefone for inválido.
     *
     * @param telefone Telefone a ser validado.
     */
    public static void validarTelefone(String telefone){

        if (telefone.trim().isEmpty() || telefone.length() != 11){
            throw new TelefoneException(MensagemErro.TELEFONE_INVALIDO.getMensagem());
        }
    }
}
