package com.SistemaDeGerenciamentodeAcademia.SGA.utils.validadorCliente;

import com.SistemaDeGerenciamentodeAcademia.SGA.enuns.MensagemErroEnum;
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
    public static void validarTelefone(String telefone) {
        if (telefone == null || telefone.trim().isEmpty() || telefone.length() != 11 || !telefone.matches("\\d{11}")) {
            throw new TelefoneException("Telefone inválido. O telefone deve conter exatamente 11 dígitos numéricos.");
        }

        // Verifica se o DDD é válido (01 a 99)
        String ddd = telefone.substring(0, 2);
        if (Integer.parseInt(ddd) < 1 || Integer.parseInt(ddd) > 99) {
            throw new TelefoneException("Telefone inválido. O DDD deve estar entre 01 e 99.");
        }

        // Verifica se o primeiro dígito do número é 9 (para celulares)
        if (telefone.charAt(2) != '9') {
            throw new TelefoneException("Telefone inválido. O número de celular deve começar com 9.");
        }

        // Verifica se o número não é composto por todos os mesmos dígitos
        if (telefone.chars().distinct().count() == 1) {
            throw new TelefoneException("Telefone inválido. O número não pode conter todos os dígitos iguais.");
        }
    }

}
