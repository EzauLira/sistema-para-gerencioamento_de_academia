//package com.SistemaDeGerenciamentodeAcademia.SGA.controller;
//
//import com.SistemaDeGerenciamentodeAcademia.SGA.enuns.MensagemErroEnum;
//import com.SistemaDeGerenciamentodeAcademia.SGA.enuns.MensagemExcecaoEnum;
//import com.SistemaDeGerenciamentodeAcademia.SGA.enuns.OpcoesEnum;
//import com.SistemaDeGerenciamentodeAcademia.SGA.exception.*;
//import com.SistemaDeGerenciamentodeAcademia.SGA.usecase.AgendamentoService;
//import com.SistemaDeGerenciamentodeAcademia.SGA.usecase.ClienteService;
//import com.SistemaDeGerenciamentodeAcademia.SGA.usecase.LoginClienteService;
//import com.SistemaDeGerenciamentodeAcademia.SGA.usecase.RelatorioService;
//
//import java.util.Scanner;
//
//public class ClienteController {
//
//    private static final Scanner input = new Scanner(System.in);
//    private static byte opcao;
//    private static final ClienteService clienteService = new ClienteService();
//    private static final AgendamentoService agendamentoService = new AgendamentoService();
//    private static final LoginClienteService loginClienteService = new LoginClienteService();
//
//    public static void loginCliente() {
//
//        System.out.println(OpcoesEnum.MENU_LOGIN_CLIENTE.getMensagem());
//        input.nextLine();
//        while (true) {
//
//            System.out.println(">> Digite seu CPF: ");
//            String cpf = input.nextLine();
//            if (cpf.equals("0")) {
//                break;
//            }
//
//            System.out.println(">> Digite sua SENHA: ");
//            String senha = input.nextLine();
//            if (senha.equals("0")) {
//                break;
//            }
//
//            if (loginClienteService.fazerLoginCliente(cpf, senha)) {
//                menuDoCliente();
//                break;
//            } else {
//                System.out.println("\n[1] - Para tentar logar novamente. \n[2] - Para cadastrar-se.");
//                byte op = input.nextByte();
//                if (op == 1) {
//                    input.nextLine();
//                } else {
//                    cadastroCliente();
//                }
//            }
//        }
//    }
//
//
//    /**
//     * Método que possuí um menu infinito para cadastro de cliente.
//     */
//    public static void cadastroCliente() {
//
//        System.out.println("\n|| CADASTRAR CLIENTE || ");
//        System.out.println("\nOBS: Siga as instruções do cadastro. Caso queira voltar ao menu, digite 0 a qualquer momento.\n");
//
//        while (true) {
//            String nome;
//            String cpf;
//            int idade;
//            int genero;
//            String telefone;
//            String senha;
//            try {
//                input.nextLine();
//                System.out.println("INFORME SEU NOME. O nome deve conter no mínimo 10 caracteres e não pode haver numeros.");
//                nome = input.nextLine();
//                if (nome.equals("0") || nome.equals("00") || nome.equals("000"))
//                    break;
//
//                System.out.println("INFORME SUA IDADE. A idade deve ser no mínimo 15 anos. ");
//                idade = input.nextInt();
//                if (idade == 0)
//                    break;
//
//                input.nextLine();
//
//                System.out.println("INFORME SEU CPF. O CPF deve ser válido e conter 11 digitos. ");
//                cpf = input.nextLine();
//                if (cpf.equals("0") || cpf.equals("00") || cpf.equals("000"))
//                    break;
//
//                System.out.println("INFORME SEU GÊNERO: ");
//                clienteService.listarGenero();
//                genero = input.nextInt();
//                if (genero == 0)
//                    break;
//
//                input.nextLine();
//
//                System.out.println("INFORME SEU TELEFONE. O formato deve ser 11912345678: ");
//                telefone = input.nextLine();
//                if (telefone.equals("0") || telefone.equals("00") || telefone.equals("000"))
//                    break;
//
//                System.out.println("INFORME SEU EMAIL. O e-mail deve ser válido e neste formato: faluno@email.com: ");
//                String email = input.nextLine();
//                if (email.equals("0") || email.equals("00") || email.equals("000"))
//                    break;
//
//                System.out.println("INFORME UMA SENHA.");
//                senha = input.nextLine();
//                if (senha.equals("0") || senha.equals("00") || senha.equals("000"))
//                    break;
//
//                System.out.println("HORA DE ESCOLHER O SEU PLANO: ");
//                clienteService.listarplanos();
//                int plano = input.nextInt();
//                if (plano == 0)
//                    break;
//
//                clienteService.cadastrarCliente(nome, idade, cpf, genero, telefone, email, senha, plano);
//            } catch (NomeException e) {
//                System.out.println(MensagemExcecaoEnum.NOME_INVALIDO.getMensagem());
//            } catch (IdadeException e) {
//                System.out.println(MensagemExcecaoEnum.IDADE_INVALIDA.getMensagem());
//            } catch (CpfException e) {
//                System.out.println(MensagemExcecaoEnum.CPF_INVALIDO.getMensagem());
//            } catch (TelefoneException e) {
//                System.out.println(MensagemExcecaoEnum.TELEFONE_INVALIDO.getMensagem());
//            } catch (EmailException e) {
//                System.out.println(MensagemExcecaoEnum.EMAIL_INVALIDO.getMensagem());
//            }
//            break;
//        }
//        inicio();
//
//    }
//
//
//    /**
//     * Método que possuí um menu infinito que marca um agendamento para o treino na academia.
//     */
//    public static void menuDoCliente() {
//
//        System.out.println(OpcoesEnum.MENU_CLIENTE.getMensagem());
//
//        while (true) {
//
//            System.out.println(OpcoesEnum.OPCOES_MENU_CLIENTE.getMensagem());
//
//            opcao = input.nextByte();
//            switch (opcao) {
//                case 1:
//                    System.out.println("Opção escolhida: AGENDAMENTE. Vamos agendar seu treino.");
//                    String nome;
//                    input.nextLine();
//                    do {
//                        System.out.println("INFORME o NOME. O nome deve ser o mesmo nome do cadastro.");
//                        nome = input.nextLine();
//                        if (nome.equals("0") || nome.equals("00") || nome.equals("000"))
//                            break;
//                    } while (agendamentoService.validarNome(nome));
//
//                    System.out.println("O que você vai querer treinar? ");
//                    agendamentoService.listarTreinos();
//                    int treino = input.nextInt();
//                    if (treino == 0)
//                        break;
//
//                    input.nextLine();
//
//                    String data;
//                    do {
//                        System.out.println("Escolha a DATA do treino. Atenção não poder ser uma data anterior a data atual no formato Dia/Mês/Ano.");
//                        data = input.nextLine();
//                        if (data.equals("0"))
//                            break;
//                    } while (agendamentoService.validarData(data));
//
//                    System.out.println("Escolha a HORA do treino.");
//                    String hora = input.nextLine();
//                    if (hora.equals("0"))
//                        break;
//
//                    agendamentoService.criarAgendamento(nome, treino, data, hora);
//                    break;
//                case 2:
//                    break;
//                case 3:
//                    break;
//                case 4:
//                    break;
//                case 5:
//                    break;
//                case 0:
//                    menuPrincipal();
//                    break;
//                default:
//                    System.out.println(MensagemErroEnum.OPCAO_INVALIDA.getMensagem());
//                    break;
//            }
//        }
//    }
//}
