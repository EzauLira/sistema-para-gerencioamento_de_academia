package com.SistemaDeGerenciamentodeAcademia.SGA.utils.validadorCliente;

import com.SistemaDeGerenciamentodeAcademia.SGA.enuns.MensagemErroEnum;
import com.SistemaDeGerenciamentodeAcademia.SGA.enuns.MensagemExcecaoEnum;
import com.SistemaDeGerenciamentodeAcademia.SGA.enuns.MensagemSucessoEnum;
import com.SistemaDeGerenciamentodeAcademia.SGA.exception.CpfException;

/**
 * Classe utilitária para validação de CPF.
 */
public class ValidarCpfUtils {

    /**
     * Valida o CPF fornecido.
     * Verifica se todos os dígitos são iguais.
     * Calcula os dígitos verificadores
     * Verifica se os dígitos verificadores estão corretos
     * Lança uma exceção se o CPF for inválido.
     *
     * @param cpf CPF a ser validado.
     */
    public static void validarCpf(String cpf) {
        if (cpf == null || cpf.length() != 11 || cpf.trim().isEmpty() || !cpf.matches("\\d{11}")) {
            throw new CpfException(MensagemExcecaoEnum.CPF_INVALIDO.getMensagem());
        }

        if (cpf.chars().distinct().count() == 1) {
            throw new CpfException(MensagemExcecaoEnum.CPF_INVALIDO.getMensagem());
        }

        int[] pesos = {10, 9, 8, 7, 6, 5, 4, 3, 2};
        int soma = 0;
        for (int i = 0; i < 9; i++) {
            soma += (cpf.charAt(i) - '0') * pesos[i];
        }
        int primeiroDigitoVerificador = 11 - (soma % 11);
        if (primeiroDigitoVerificador >= 10) {
            primeiroDigitoVerificador = 0;
        }

        pesos = new int[]{11, 10, 9, 8, 7, 6, 5, 4, 3, 2};
        soma = 0;
        for (int i = 0; i < 10; i++) {
            soma += (cpf.charAt(i) - '0') * pesos[i];
        }
        int segundoDigitoVerificador = 11 - (soma % 11);
        if (segundoDigitoVerificador >= 10) {
            segundoDigitoVerificador = 0;
        }

        if (cpf.charAt(9) - '0' != primeiroDigitoVerificador || cpf.charAt(10) - '0' != segundoDigitoVerificador) {
            throw new CpfException(MensagemExcecaoEnum.CPF_INVALIDO.getMensagem());
        }
    }

}
