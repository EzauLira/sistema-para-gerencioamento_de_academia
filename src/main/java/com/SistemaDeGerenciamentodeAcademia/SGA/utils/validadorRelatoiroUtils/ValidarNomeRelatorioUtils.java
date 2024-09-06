package com.SistemaDeGerenciamentodeAcademia.SGA.utils.validadorRelatoiroUtils;

import com.SistemaDeGerenciamentodeAcademia.SGA.enuns.MensagemErro;

public class ValidarNomeRelatorioUtils {

    public static boolean validarNome(String nome) {

        if (nome.trim().isEmpty() || nome.length() < 10){
            System.out.println(MensagemErro.NOME_INVALIDO.getMensagem());
            return true;
        }else {
            return false;
        }
    }
}
