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
//remover as thrwos da main
public class Main {

    private static final Scanner input = new Scanner(System.in);
    private static byte opcao;
    private static final ClienteService clienteService = new ClienteService();
    private static final AgendamentoService agendamentoService = new AgendamentoService();
    private static final RelatorioService relatorioService = new RelatorioService();

    public static void main(String[] args){

        menuPrincipal();

    }


    /**
     * Método principal que percorre todo os menus para fazer o cadastro do cliente e agendamento do treino da academia.
     */
    public static void menuPrincipal() {
        System.out.println("\n|| SISTEMA PARA GERENCIAMENTO DE ACADEMIA ||");

        while (true) {
            try {
                System.out.println("\n|| MENU PRINCIPAL ||");

                System.out.println("\n(1) - Menu Cliente");
                System.out.println("(2) - Agendar um treino");
                System.out.println("(3) - Ver relatórios");
                System.out.println("(0) - Sair");
                System.out.println("\nEscolha um opção: ");

                opcao = input.nextByte();
                switch (opcao) {
                    case 1:
                        menuCliente();
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

    public static void menuCliente() throws SQLException {

        while (true) {

            System.out.println("\n|| MENU CLIENTE ||");

            System.out.println("\n(1) - Cadastrar um cliente");
            System.out.println("(2) - Listar clientes");
            System.out.println("(0) - Voltar");

            opcao = input.nextByte();
            switch (opcao) {
                case 1:
                    cadastroCliente();
                    break;
                case 2:
                    buscarClientePeloNome();
                    break;
                case 0:
                    menuPrincipal();
                default:
                    System.out.println(MensagemErro.OPCAO_INVALIDA.getMensagem());
                    break;
            }
        }
    }

    /**
     * Método que possuí um menu infinito para cadastro de cliente.
     */
    public static void cadastroCliente() {

        System.out.println("\n|| CADASTRAR CLIENTE || ");
        System.out.println("\nOBS: Siga as instruções do cadastro. Caso queira voltar ao menu, digite 0 a qualquer momento.\n");

        while (true) {
            String nome;
            String cpf;
            int idade;
            String genero;
            String telefone;
            try {
                input.nextLine();
                System.out.println("INFORME SEU NOME. O nome deve conter no mínimo 10 caracteres e não pode haver numeros.");
                nome = input.nextLine();
                if (nome.equals("0") || nome.equals("00") || nome.equals("000"))
                    break;

                System.out.println("INFORME SUA IDADE. A idade deve ser no mínimo 15 anos. ");
                idade = input.nextInt();
                if (idade == 0)
                    break;

                input.nextLine();

                System.out.println("INFORME SEU CPF. O CPF deve ser válido e conter 11 digitos. ");
                cpf = input.nextLine();
                if (cpf.equals("0") || cpf.equals("00") || cpf.equals("000"))
                    break;

                System.out.println("INFORME SEU GÊNERO (M/F ou Masculino / Feminino): ");
                genero = input.nextLine();
                if (genero.equals("0") || genero.equals("00") || genero.equals("000"))
                    break;

                System.out.println("INFORME SEU TELEFONE. O formato deve ser 119123456789: ");
                telefone = input.nextLine();
                if (telefone.equals("0") || telefone.equals("00") || telefone.equals("000"))
                    break;

                System.out.println("INFORME SEU EMAIL. O e-mail deve ser vválido e nesse formato: faluno@email.com: ");
                String email = input.nextLine();
                if (email.equals("0") || email.equals("00") || email.equals("000"))
                    break;

                System.out.println("HORA DE ESCOLHER SEU PLANO: ");
                clienteService.listarplanos();
                int plano = input.nextInt();
                if (plano == 0)
                    break;

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

    public static void buscarClientePeloNome() {
        System.out.println("\n|| BUSCAR CLIENTE PELO NOME ||\n");
        System.out.println("\nOBS: Siga as instruções para buscar o cliente. Caso queira voltar ao menu, digite 0 a qualquer momento.\n");

        while (true) {
            String nome;
            input.nextLine();
            System.out.println("INFORME O NOME DO CLIENTE A SER PROCURADO.");
            nome = input.nextLine();
            if (nome.equals("0") || nome.equals("00") || nome.equals("000")) {
                break;
            }

            clienteService.buscarClientePeloPrimeiroNome(nome);
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
        System.out.println("\nOBS: Siga as instruções para agendar seu treino. Caso queira voltar ao menu, digite 0 a qualquer momento.\n");

        while (true) {

            String nome;
            input.nextLine();
            do {
                System.out.println("INFORME o NOME. O nome deve conter no mínimo 10 caracteres e não pode haver numeros.");
                nome = input.nextLine();
                if (nome.equals("0") || nome.equals("00") || nome.equals("000"))
                    break;
            } while (agendamentoService.validarNome(nome));

            System.out.println("O que você vai querer treinar? ");
            agendamentoService.listarTreinos();
            int treino = input.nextInt();
            if (treino == 0)
                break;

            input.nextLine();

            System.out.println("Escolha a DATA do trieno: ");
            String data = input.nextLine();
            if (data.equals("0"))
                break;

            System.out.println("Escolha a HORA do trieno: ");
            String hora = input.nextLine();
            if (hora.equals("0"))
                break;

            agendamentoService.criarAgendamento(nome, treino, data, hora);
            System.out.println(MensagemSucesso.AGENDAMENTO_EFETUADO.getMensagem());
            break;
        }
    }

    public static void menuRelatorios() throws SQLException {

        System.out.println("\n|| RELATÓRIOS ||");
        System.out.println("\nOBS: Siga as instruções para gerar o relatório. Caso queira voltar ao menu, digite 0 a qualquer momento.\n");

        System.out.println("(1) - Gerar relatório da academia");
        System.out.println("(2) - Gerar relatório de um cliente especifico");
        System.out.println("(3) - Gerar relatório de todos os clientes");
        System.out.println("(0) - Volar");
        System.out.println("\nEscolha um opção: ");

        opcao = input.nextByte();
        switch (opcao) {
            case 1:
                relatorioService.gerarRelatorioAcademia();
                break;

            case 2:
                String nome;
                input.nextLine();
                do {
                    System.out.println("INFORME O NOME. O nome deve conter no mínimo 10 caracteres e não pode haver numeros.");
                    nome = input.nextLine();
                } while (relatorioService.validarNome(nome));
                relatorioService.gerarRelatorioClienteEspecifico(nome);
                break;

            case 3:
                relatorioService.gerarRelatorioDeTodosClientes();
                break;
            case 0:
                menuPrincipal();
                break;

            default:
                System.out.println(MensagemErro.OPCAO_INVALIDA.getMensagem());
                break;
        }
    }
}