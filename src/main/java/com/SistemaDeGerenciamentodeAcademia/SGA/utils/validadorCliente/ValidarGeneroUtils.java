//package com.SistemaDeGerenciamentodeAcademia.SGA.utils.validadorCliente;
//
//import com.SistemaDeGerenciamentodeAcademia.SGA.enuns.MensagemErro;
//import com.SistemaDeGerenciamentodeAcademia.SGA.exception.GeneroException;
//
///**
// * Classe utilitária para validação de gênero.
// */
//public class ValidarGeneroUtils {
//
//    /**
//     * Valida o gênero fornecido.
//     * Lança uma exceção se o gênero for inválido.
//     *
//     * @param genero Gênero a ser validado.
//     */
//    public static void validarGenero(String genero) {
//
//        genero = genero.toLowerCase();
//
//        if (genero.equals("m") || genero.equals("f") || genero.equals("masculino") || genero.equals("feminino")) {
//            // Gênero válido
//        } else if (genero.trim().isEmpty()) {
//            throw new GeneroException(MensagemErro.GENERO_INVALIDO.getMensagem());
//        } else {
//            throw new GeneroException(MensagemErro.GENERO_INVALIDO.getMensagem());
//        }
//    }
//}
