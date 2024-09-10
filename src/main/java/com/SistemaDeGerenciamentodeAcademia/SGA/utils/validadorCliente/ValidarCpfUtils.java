package com.SistemaDeGerenciamentodeAcademia.SGA.utils.validadorCliente;

import com.SistemaDeGerenciamentodeAcademia.SGA.enuns.MensagemErro;
import com.SistemaDeGerenciamentodeAcademia.SGA.exception.CpfException;

public class ValidarCpfUtils {

    public static void validarCpf(String cpf) {
        if (cpf.length() != 11 || cpf.trim().isEmpty()) {
            throw new CpfException(MensagemErro.CPF_INVALIDO.getMensagem());
        }
    }
}
