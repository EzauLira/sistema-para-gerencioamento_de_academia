package com.SistemaDeGerenciamentodeAcademia.SGA.utils.validadorAgendamento;

import com.SistemaDeGerenciamentodeAcademia.SGA.enuns.MensagemErroEnum;
import com.SistemaDeGerenciamentodeAcademia.SGA.enuns.MensagemExcecaoEnum;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;


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
    public static boolean validarDataAgendamento(String data) {
        try {

            DateTimeFormatter dataFormatada = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate dataAtual = LocalDate.now();
            LocalDate dataVinda = LocalDate.parse(data, dataFormatada);

            if (dataVinda.isBefore(dataAtual)){
                System.out.println(MensagemErroEnum.DATA_INVALIDA.getMensagem());
                return true;
            }else {
                return false;
            }
        } catch (DateTimeParseException e) {
            System.out.println(MensagemExcecaoEnum.DATA_INVALIDA.getMensagem());
        }
        return true;
    }
}
