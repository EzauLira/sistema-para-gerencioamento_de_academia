package com.SistemaDeGerenciamentodeAcademia.SGA.utils.validadorCliente;

import com.SistemaDeGerenciamentodeAcademia.SGA.enuns.MensagemErro;
import com.SistemaDeGerenciamentodeAcademia.SGA.exception.CpfException;

/**
 * Classe utilitária para validação de CPF.
 */
public class ValidarCpfUtils {

    /**
     * Valida o CPF fornecido.
     * Lança uma exceção se o CPF for inválido.
     *
     * @param cpf CPF a ser validado.
     */
    public static void validarCpf(String cpf) {
        if (cpf.length() != 11 || cpf.trim().isEmpty()) {
            throw new CpfException(MensagemErro.CPF_INVALIDO.getMensagem());
        }
    }
}
