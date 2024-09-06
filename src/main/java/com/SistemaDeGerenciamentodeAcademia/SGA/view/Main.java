package com.SistemaDeGerenciamentodeAcademia.SGA.view;

import com.SistemaDeGerenciamentodeAcademia.SGA.enuns.MensagemErro;
import com.SistemaDeGerenciamentodeAcademia.SGA.enuns.MensagemExcecao;
import com.SistemaDeGerenciamentodeAcademia.SGA.enuns.MensagemSucesso;
import com.SistemaDeGerenciamentodeAcademia.SGA.exception.*;
import com.SistemaDeGerenciamentodeAcademia.SGA.usecase.AgendamentoService;
import com.SistemaDeGerenciamentodeAcademia.SGA.usecase.ClienteService;
import com.SistemaDeGerenciamentodeAcademia.SGA.usecase.RelatorioService;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    private static final Scanner input = new Scanner(System.in);
    private static byte opcao;
    private static final ClienteService clienteService = new ClienteService();
    private static final AgendamentoService agendamentoService = new AgendamentoService();
    private static final RelatorioService relatorioService = new RelatorioService();

    public static void main(String[] args) {

        menuPrincipal();

    }

    /**
     * Método principal que percorre todo os menus para fazer o cadastro do cliente e agendamento do treino da academia.
     */
    public static void menuPrincipal() {
        System.out.println("\n|| SISTEMA PARA GERENCIAMENTO DE ACADEMIA ||\n");

        while (true) {
            try {

                System.out.println("\n(1) - Cadastrar um cliente");
                System.out.println("(2) - Agendar um treino");
                System.out.println("(3) - Ver relatórios");
                System.out.println("(0) - Sair");
                System.out.println("\nEscolha um opção: ");

                opcao = input.nextByte();
                switch (opcao) {
                    case 1:
                        cadastroCliente();
                        break;
                    case 2:
                        marcarAgendamento();
                        break;
                    case 3:
                        menuRelatorios();
                        break;
                    case 0:
                        System.out.println("Aplicação encerrada.");
                        System.exit(0);
                        break;
                    default:
                        System.out.println(MensagemErro.OPCAO_INVALIDA.getMensagem());
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println(MensagemExcecao.ENTRADA_INVALIDA.getMensagem());

                input.nextLine();
            } catch (SQLException erro) {
                SqlException.sqlException(erro);
            }
        }
    }

    /**
     * Método que possuí um menu infinito para cadastro de cliente.
     *
     * @throws SQLException Fornece informações sobre um erro de acesso ao banco de dados ou outros erros.
     */
    public static void cadastroCliente() throws SQLException {

        System.out.println("\n || CADASTRAR CLIENTE || \n");

        while (true) {
            String nome;
            String cpf;
            int idade;
            String genero;
            String telefone;
            try {
                input.nextLine();
                System.out.println("Digite seu nome. O nome deve conter no mínimo 10 caracteres e não pode haver numeros.");
                nome = input.nextLine();

                System.out.println("Digite sua idade. A idade deve ser no mínimo 15 anos. ");
                idade = input.nextInt();

                input.nextLine();

                System.out.println("Digite CPF. O CPF deve ser válido e conter 11 digitos. ");
                cpf = input.nextLine();

                System.out.println("Digite seu Gênero (M/F ou Masculino / Feminino): ");
                genero = input.nextLine();

                System.out.println("Digite seu Telefone. O formato deve ser 119123456789: ");
                telefone = input.nextLine();

                System.out.println("Digite seu Email. O e-mail deve ser vválido e nesse formato: faluno@email.com: ");
                String email = input.nextLine();

                System.out.println("Hora de escolher o seu plano: ");
                ClienteService.listarplanos();
                int plano = input.nextInt();

                clienteService.cadastrarCliente(nome, idade, cpf, genero, telefone, email, plano);
            } catch (NomeException e) {
                System.out.println(MensagemExcecao.NOME_INVALIDO.getMensagem());
            } catch (IdadeException e) {
                System.out.println(MensagemExcecao.IDADE_INVALIDA.getMensagem());
            } catch (CpfException e) {
                System.out.println(MensagemExcecao.CPF_INVALIDO.getMensagem());
            } catch (GeneroException e) {
                System.out.println(MensagemExcecao.GENERO_INVALIDO.getMensagem());
            } catch (TelefoneException e) {
                System.out.println(MensagemExcecao.TELEFONE_INVALIDO.getMensagem());
            } catch (EmailException e) {
                System.out.println(MensagemExcecao.EMAIL_INVALIDO.getMensagem());
            }
            System.out.println(MensagemSucesso.CADASTRO_EFETUADO.getMensagem());
            break;
        }

    }

    /**
     * Método que possuí um menu infinito que marca um agendamento para o treino na academia.
     *
     * @throws SQLException Fornece informações sobre um erro de acesso ao banco de dados ou outros erros.
     */
    public static void marcarAgendamento() throws SQLException {

        System.out.println("\n|| AGENDAR TREINO ||\n");

        while (true) {

            String nome;
            input.nextLine();
            do {
                System.out.println("Informe o nome. O nome deve conter no mínimo 10 caracteres e não pode haver numeros.");
                nome = input.nextLine();
            } while (agendamentoService.validarNome(nome));

            System.out.println("O que você vai querer treinar? ");
            AgendamentoService.listarTreinos();
            int treino = input.nextInt();

            input.nextLine();

            System.out.println("Escolha a data do trieno: ");
            String data = input.nextLine();

            System.out.println("Escolha a hora do trieno: ");
            String hora = input.nextLine();

            AgendamentoService.criarAgendamento(nome, treino, data, hora);
            break;
        }
    }

    public static void menuRelatorios() throws SQLException {

        System.out.println("\n|| RELATÓRIOS ||");

        System.out.println("\n(1) - Gerar relatório da academia: ");
        System.out.println("(2) - Gerar relatório de um cliente especifico: ");
        System.out.println("(3) - Gerar relatório de todos os clientes: ");
        System.out.println("\nEscolha um opção: ");

        opcao = input.nextByte();
        switch (opcao) {
            case 1:
                RelatorioService.gerarRelatorioAcademia();
                break;

            case 2:
                String nome;
                input.nextLine();
                do {
                    System.out.println("Informe o nome. O nome deve conter no mínimo 10 caracteres e não pode haver numeros.");
                    nome = input.nextLine();
                } while (relatorioService.validarNome(nome));
                RelatorioService.gerarRelatorioClienteEspecifico(nome);
                break;

            case 3:
                RelatorioService.gerarRelatorioDeTodosClientes();
                break;

            default:
                System.out.println(MensagemErro.OPCAO_INVALIDA.getMensagem());
                break;
        }
    }
}