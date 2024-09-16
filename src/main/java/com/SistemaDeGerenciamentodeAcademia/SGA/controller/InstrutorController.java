package com.SistemaDeGerenciamentodeAcademia.SGA.controller;

import com.SistemaDeGerenciamentodeAcademia.SGA.enuns.MensagemExcecaoEnum;
import com.SistemaDeGerenciamentodeAcademia.SGA.exception.*;
import com.SistemaDeGerenciamentodeAcademia.SGA.usecase.ClienteService;
import com.SistemaDeGerenciamentodeAcademia.SGA.usecase.InstrutorService;
import com.SistemaDeGerenciamentodeAcademia.SGA.usecase.LoginClienteService;
import com.SistemaDeGerenciamentodeAcademia.SGA.usecase.RelatorioService;
import com.SistemaDeGerenciamentodeAcademia.SGA.view.Main;

import java.util.Scanner;

public class InstrutorController {

    /**
     * Atributos e objetos estáticos que estão a ser usados em mais de um método.
     */
    private static final Scanner input = new Scanner(System.in);
    private static byte opcao;
    private static final ClienteService clienteService = new ClienteService();
    private static final RelatorioService relatorioService = new RelatorioService();
    private static final LoginClienteService loginClienteService = new LoginClienteService();
    private static final InstrutorService instrutorService = new InstrutorService();
    private static final Main main = new Main();

    public void loginInstrutor() {

        while (true) {

            System.out.println(">> Digite seu CPF: ");
            String cpf = input.nextLine();
            if (cpf.equals("0")) {
                break;
            }

            System.out.println(">> Digite sua SENHA: ");
            String senha = input.nextLine();
            if (senha.equals("0")) {
                break;
            }
        }
    }

    public void cadastroInstrutor(){
        System.out.println("\n|| CADASTRAR INSTRUTOR || ");
        System.out.println("\nOBS: Siga as instruções do cadastro. Caso queira voltar ao menu, digite 0 a qualquer momento.\n");

        while (true) {
            String nome;
            String cpf;
            int genero;
            String telefone;
            String senha;
            try {
                input.nextLine();
                System.out.println("INFORME SEU NOME. O nome deve conter no mínimo 10 caracteres e não pode haver numeros.");
                nome = input.nextLine();
                if (nome.equals("0") || nome.equals("00") || nome.equals("000"))
                    break;

                System.out.println("INFORME SEU CPF. O CPF deve ser válido e conter 11 digitos. ");
                cpf = input.nextLine();
                if (cpf.equals("0") || cpf.equals("00") || cpf.equals("000"))
                    break;

                System.out.println("INFORME SEU GÊNERO: ");
                clienteService.listarGenero();
                genero = input.nextInt();
                if (genero == 0)
                    break;

                input.nextLine();

                System.out.println("INFORME SEU TELEFONE. O formato deve ser 11912345678: ");
                telefone = input.nextLine();
                if (telefone.equals("0") || telefone.equals("00") || telefone.equals("000"))
                    break;

                System.out.println("INFORME SEU EMAIL. O e-mail deve ser válido e neste formato: faluno@email.com: ");
                String email = input.nextLine();
                if (email.equals("0") || email.equals("00") || email.equals("000"))
                    break;

                System.out.println("INFORME UMA SENHA.");
                senha = input.nextLine();
                if (senha.equals("0") || senha.equals("00") || senha.equals("000"))
                    break;

                instrutorService.cadastrarInstrutor(nome, cpf, genero, telefone, email, senha);
            } catch (NomeException e) {
                System.out.println(MensagemExcecaoEnum.NOME_INVALIDO.getMensagem());
            } catch (IdadeException e) {
                System.out.println(MensagemExcecaoEnum.IDADE_INVALIDA.getMensagem());
            } catch (CpfException e) {
                System.out.println(MensagemExcecaoEnum.CPF_INVALIDO.getMensagem());
            } catch (TelefoneException e) {
                System.out.println(MensagemExcecaoEnum.TELEFONE_INVALIDO.getMensagem());
            } catch (EmailException e) {
                System.out.println(MensagemExcecaoEnum.EMAIL_INVALIDO.getMensagem());
            }
            break;
        }
        main.inicio();
    }
}
