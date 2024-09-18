package com.SistemaDeGerenciamentodeAcademia.SGA.utils.validadorCliente;

import com.SistemaDeGerenciamentodeAcademia.SGA.enuns.MensagemExcecaoEnum;
import com.SistemaDeGerenciamentodeAcademia.SGA.exception.TelefoneException;

/**
 * Classe utilitária para validação de telefones.
 */
public class ValidarTelefoneUtils {

    /**
     * Valida o telefone fornecido.
     * Verifica se o DDD é válido (01 a 99)
     * Verifica se o primeiro dígito do número é 9 (para celulares)
     * Verifica se o número não é composto por todos os mesmos dígitos
     * Lança uma exceção se o telefone for inválido.
     *
     * @param telefone Telefone a ser validado.
     */
    public static void validarTelefone(String telefoneSemFormatacao) {

        String telefone = telefoneSemFormatacao.replaceAll("[\\s\\-()]","");

        if (telefone == null || telefone.trim().isEmpty()) {
            throw new TelefoneException(MensagemExcecaoEnum.TELEFONE_INVALIDO.getMensagem());
        }

        String ddd = telefone.substring(0, 2);
        if (Integer.parseInt(ddd) < 1 || Integer.parseInt(ddd) > 99) {
            throw new TelefoneException(MensagemExcecaoEnum.TELEFONE_INVALIDO.getMensagem());
        }

        if (telefone.charAt(2) != '9') {
            throw new TelefoneException(MensagemExcecaoEnum.TELEFONE_INVALIDO.getMensagem());
        }

        if (telefone.chars().distinct().count() == 1) {
            throw new TelefoneException(MensagemExcecaoEnum.TELEFONE_INVALIDO.getMensagem());
        }
    }
}
