package com.SistemaDeGerenciamentodeAcademia.SGA.utils.validadorAgendamento;

import com.SistemaDeGerenciamentodeAcademia.SGA.enuns.MensagemErro;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Classe utilitária para validação de datas de agendamento.
 */
public class ValidarDataAgendamentoUtils {

    /**
     * Valida se a data fornecida é igual à data atual formatada.
     * Exibe uma mensagem de erro se a data for inválida.
     *
     * @param data Data a ser validada no formato "dd/MM/yyyy".
     * @return {@code true} se a data for inválida, {@code false} caso contrário.
     */
    public static boolean validarDataAgendamento(String data){
        LocalDate dataAtual = LocalDate.now();
        String dataFormatada = dataAtual.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        if (!data.equals(dataFormatada)){
            System.out.println(MensagemErro.DATA_INVALIDA.getMensagem());
            return true;
        }
        return false;
    }
}
