package com.SistemaDeGerenciamentodeAcademia.SGA.view;

import com.SistemaDeGerenciamentodeAcademia.SGA.controller.AdmControlller;
import com.SistemaDeGerenciamentodeAcademia.SGA.controller.ClienteController;
import com.SistemaDeGerenciamentodeAcademia.SGA.controller.InstrutorController;
import com.SistemaDeGerenciamentodeAcademia.SGA.enuns.*;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    /**
     * Atributos e objetos estáticos que estão a ser usados em mais de um método.
     */
    private static final Scanner input = new Scanner(System.in);
    private static final InstrutorController instrutorController = new InstrutorController();

    public static void main(String[] args) {

        inicio();

    }

    public static void inicio() {
        System.out.printf(CabecalhoSgaEnum.CABECALHO.getMensagem());

        while (true) {
            try {
                System.out.println(CabecalhoSgaEnum.OPCAO_PRINCIPAL.getMensagem());
                byte opcao = input.nextByte();
                switch (opcao) {

                    case 1:
                        ClienteController.clienteLogarOuCadastrar();
                        break;

                    case 2:
                        instrutorController.loginInstrutor();
                        break;
                    case 3:
                        AdmControlller.loginAdmin();
                        break;
                    default:
                        System.out.println(MensagemErroEnum.OPCAO_INVALIDA.getMensagem());
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println(MensagemExcecaoEnum.ENTRADA_INVALIDA.getMensagem());

                input.nextLine();
            }
        }
    }
}