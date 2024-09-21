package com.SistemaDeGerenciamentodeAcademia.SGA.controller;

import com.SistemaDeGerenciamentodeAcademia.SGA.config.Timer;
import com.SistemaDeGerenciamentodeAcademia.SGA.enuns.*;
import com.SistemaDeGerenciamentodeAcademia.SGA.exception.*;
import com.SistemaDeGerenciamentodeAcademia.SGA.usecase.AdmService;
import com.SistemaDeGerenciamentodeAcademia.SGA.utils.constantesUtils.MensagensConstanteUtils;
import com.SistemaDeGerenciamentodeAcademia.SGA.view.Main;

import java.util.InputMismatchException;
import java.util.Scanner;

public class AdmControlller {

    /**
     * Atributos e objetos estáticos que estão a ser usados em mais de um método.
     */
    private static final Scanner input = new Scanner(System.in);
    private static final AdmService admService = new AdmService();

    /**
     * Método para efetuar o login do administrado
     */
    public static void loginAdmin() {

        System.out.println(OpcoesAdmEnum.OPCOES_ADM.getMensagem());
        System.out.println(MensagensConstanteUtils.ADM_INFORME_SEU_USUARIO);
        String usuario = input.nextLine();
        if (usuario.equals("0")) {
            Main.inicio();
        }

        System.out.println(MensagensConstanteUtils.ADM_INFORME_SUA_SENHA);
        String senha = input.nextLine();
        if (senha.equals("0")) {
            Main.inicio();
        }
        if (admService.loginAdm(usuario, senha)) {
            menuDoAdm();
        } else {
            do {
                try {

                    System.out.println(OpcoesAdmEnum.MSG_TENTAR_NOVAMENTE.getMensagem());
                    byte op = input.nextByte();
                    if (op == 1) {
                        input.nextLine();
                        loginAdmin();
                    } else if (op == 0) {
                        input.nextLine();
                        Main.inicio();
                    } else {
                        System.out.println(MensagemErroEnum.OPCAO_INVALIDA.getMensagem());
                    }
                } catch (InputMismatchException e) {
                    System.out.println(MensagemExcecaoEnum.ENTRADA_INVALIDA.getMensagem());
                    input.nextLine();
                }
            } while (true);
        }
    }

    /**
     * Método para cadastrar um novo instrutor.
     */
    public static void cadastrarNovoInstrutor() {
        System.out.println(OpcoesClientesEnum.MENU_DO_CADASTRO_INFORMATIVO.getMensagem());

        while (true) {
            String nome;
            String cpf;
            String genero;
            String telefone;
            String senha;

            try {
                input.nextLine();
                System.out.println(MensagensConstanteUtils.CADASTRO_INFORME_SEU_NOME);
                nome = input.nextLine();
                if (nome.equals("0") || nome.equals("00") || nome.equals("000"))
                    menuDoAdm();

                System.out.println(MensagensConstanteUtils.CADASTRO_INFORME_SEU_CPF);
                cpf = input.nextLine();
                if (cpf.equals("0") || cpf.equals("00") || cpf.equals("000"))
                    menuDoAdm();

                System.out.println(MensagensConstanteUtils.CADASTRO_INFORME_SEU_GENERO);
                System.out.println(" ");
                ClienteController.listarGenero();
                genero = input.nextLine();
                if (genero.equals("0"))
                    menuDoAdm();

                System.out.println(MensagensConstanteUtils.CADASTRO_INFORME_SEU_TELEFONE);
                telefone = input.nextLine();
                if (telefone.equals("0") || telefone.equals("00") || telefone.equals("000"))
                    menuDoAdm();

                System.out.println(MensagensConstanteUtils.CADASTRO_INFORME_SEU_EMAIL);
                String email = input.nextLine();
                if (email.equals("0") || email.equals("00") || email.equals("000"))
                    menuDoAdm();

                System.out.println(MensagensConstanteUtils.CADASTRO_INFORME_SUA_SENHA);
                senha = input.nextLine();
                if (senha.equals("0") || senha.equals("00") || senha.equals("000"))
                    menuDoAdm();

                admService.cadastrarNovoInstrutor(nome, cpf, Integer.parseInt(genero), telefone, email, senha);
            } catch (NomeException e) {
                System.out.println(MensagemExcecaoEnum.NOME_INVALIDO.getMensagem());
            } catch (CpfException e) {
                System.out.println(MensagemExcecaoEnum.CPF_INVALIDO.getMensagem());
            } catch (TelefoneException e) {
                System.out.println(MensagemExcecaoEnum.TELEFONE_INVALIDO.getMensagem());
            } catch (EmailException e) {
                System.out.println(MensagemExcecaoEnum.EMAIL_INVALIDO.getMensagem());
            } catch (InputMismatchException e) {
                System.out.println(MensagemExcecaoEnum.ENTRADA_INVALIDA.getMensagem());
            } catch (NumberFormatException e) {
                System.out.println(MensagensConstanteUtils.CADASTRO_ENTRADA_INVALIDA);
            }
            break;
        }
    }

    /**
     * Método para gerar o relatório da academia, como quantos planos vendidos.
     */
    public static void gerarRelatorioDaAcademia() {
        admService.gerarRelatorioAcademia();
    }

    /**
     * Método menu infinito do instrutor contendo todas as opções.
     */
    public static void menuDoAdm() {

        System.out.println(OpcoesAdmEnum.MENU_INFORMATIVO_ADM.getMensagem());

        while (true) {
            try {
                System.out.println(OpcoesAdmEnum.OPCOES_MENU_ADM.getMensagem());
                byte opcao = input.nextByte();
                switch (opcao) {
                    case 1:
                        gerarRelatorioDaAcademia();
                        break;

                    case 2:
                        cadastrarNovoInstrutor();
                        break;

                    case 0:
                        System.out.println(MensagensConstanteUtils.MENU_CLIENE_SAINDO);
                        Timer.tempoCorrido();
                        input.nextLine();
                        Main.inicio();
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
