package com.SistemaDeGerenciamentodeAcademia.SGA.utils.validadorAgendamento;

import com.SistemaDeGerenciamentodeAcademia.SGA.enuns.MensagemErroEnum;

/**
 * Classe utilitária para validação de nomes de agendamento.
 */
public class ValidarNomeAgendamentoUtils {

    /**
     * Valida o nome fornecido para agendamento.
     * Exibe uma mensagem de erro se o nome for inválido.
     *
     * @param nome Nome a ser validado.
     * @return {@code true} se o nome for inválido, {@code false} caso contrário.
     */
    public static boolean validarNome(String nome) {

        if (nome.trim().isEmpty() || nome.length() < 10){
            System.out.println(MensagemErroEnum.NOME_INVALIDO.getMensagem());
            return true;
        }else {
            return false;
        }
    }
}
