package com.SistemaDeGerenciamentodeAcademia.SGA.utils.validadores;

import com.SistemaDeGerenciamentodeAcademia.SGA.enuns.MensagemExcecaoEnum;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class ValidarHoraUtils {

    public static boolean validarHora(String hora) {
        try {
            DateTimeFormatter formatoHora = DateTimeFormatter.ofPattern("HH:mm");
            LocalTime.parse(hora, formatoHora);
            return true;
        } catch (DateTimeParseException e) {
            System.out.println(MensagemExcecaoEnum.HORA_INVALIDA.getMensagem());
            return false;
        }
    }
}
