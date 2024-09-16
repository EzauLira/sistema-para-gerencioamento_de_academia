package com.SistemaDeGerenciamentodeAcademia.SGA.view;

import com.SistemaDeGerenciamentodeAcademia.SGA.enuns.MensagemErroEnum;
import com.SistemaDeGerenciamentodeAcademia.SGA.enuns.MensagemExcecaoEnum;
import com.SistemaDeGerenciamentodeAcademia.SGA.enuns.OpcoesEnum;
import com.SistemaDeGerenciamentodeAcademia.SGA.exception.*;
import com.SistemaDeGerenciamentodeAcademia.SGA.usecase.AgendamentoService;
import com.SistemaDeGerenciamentodeAcademia.SGA.usecase.ClienteService;
import com.SistemaDeGerenciamentodeAcademia.SGA.usecase.LoginClienteService;
import com.SistemaDeGerenciamentodeAcademia.SGA.usecase.RelatorioService;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    /**
     * Atributos e objetos estáticos que estão a ser usados em mais de um método.
     */
    private static final Scanner input = new Scanner(System.in);
    private static byte opcao;
    private static final ClienteService clienteService = new ClienteService();
    private static final AgendamentoService agendamentoService = new AgendamentoService();
    private static final RelatorioService relatorioService = new RelatorioService();
    private static final LoginClienteService loginClienteService = new LoginClienteService();

    public static void main(String[] args) {

        inicio();

        //menuPrincipal();

    }

    public static void inicio() {
        System.out.printf(OpcoesEnum.SISTEMA.getMensagem());;

        while (true) {
            try {
                System.out.println(OpcoesEnum.OPCOES_ENUM.getMensagem());
                byte resposta = input.nextByte();

                switch (resposta) {
                    case 1:
                        System.out.println(OpcoesEnum.OPCOES_CLIENTE.getMensagem());
                        byte loginCadastrar = input.nextByte();
                        if (loginCadastrar == 1){
                            loginCliente();
                        }else{
                            cadastroCliente();
                        }

                        //CAMINHO DA ALEGRIA:
                        //Mostrar opção de ‘login’ para cliente;
                        //Após fazer o ‘login’ como cliente passar para uma verificação para ver se o cliente existe no banco de dados.
                        //Se o cliente exister de fato, mostrar as opções de: AGENDAMENTO DE TREINO COM OS INSTRUTORES DISPINÍVEIS, CANCELAR ALGUM TREINO, ATUALIZAR A DATA OU A HORA,
                        //LISTAR OS ÚLTIMOS TREINOS FEITOS, LISTAR OS TREINOS QUE AINDA ESTARÃO PARA ACONTECER.

                        //CAMINHO DA TRISTEZA:
                        //Mostrar opção de ‘login’ para cliente;
                        //Após fazer o ‘login’ como cliente passar para uma verificação para ver se o cliente existe no banco de dados.
                        //Se esse cliente não exister, mostrar uma mensagem dizendo que o cliente não foi encontrado, primeiro pedir para ele verificar os dados digitados ou cadastrar-se.
                        //Mosrar uma opção para que essa pessoa possa escolher se deseja se cadastrar, tentar novamente ou simplismente sair.
                        break;
                    case 2:
                        loginInstrutor();
                        //CAMINHO DA ALEGRIA:
                        //Mostrar opção de ‘login’ para cliente;
                        //Após fazer o ‘login’ como instrutor passar para uma verificação para ver se o instrutor existe no banco de dados.
                        //Se o instrutor exister de fato, mostrar as opções de: CANCELAR ALGUM TREINO QUE MARCARAM COM O ISNTRUTOR, ATUALIZAR A DATA OU A HORA DO TREINO QUE MARCARARAM,
                        //LISTAR OS TREINOS CONLUÍDOS, LISTAR OS TREINOS QUE AINDA ESTARÃO PARA ACONTECER.

                        //CAMINHO DA TRISTEZA:
                        //Mostrar opção de ‘login’ para instrutor;
                        //Após fazer o ‘login’ como instrutor passar para uma verificação para ver se o instrutor existe no banco de dados.
                        //Se esse instrutor não exister, mostrar uma mensagem dizendo que o instrutor não foi encontrado, primeiro pedir para ele verificar os dados digitados ou cadastrar-se.
                        //Mosrar uma opção para que essa pessoa possa escolher se deseja se cadastrar, tentar novamente ou simplismente sair.
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

    public static void loginCliente() {

        System.out.println(OpcoesEnum.MENU_LOGIN_CLIENTE.getMensagem());
        input.nextLine();
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

            if (loginClienteService.fazerLoginCliente(cpf, senha)) {
                menuDoCliente();
                break;
            } else {
                System.out.println("\n[1] - Para tentar logar novamente. \n[2] - Para cadastrar-se.");
                byte op = input.nextByte();
                if (op == 1) {
                    input.nextLine();
                } else {
                    cadastroCliente();
                }
            }
        }
    }

    public static void loginInstrutor() {

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

//    /**
//     * Método principal que percorre todo os menus, para fazer o cadastro e agendamento do treino da academia.
//     */
//    public static void menuPrincipal() {
//        System.out.println("\n|| SISTEMA PARA GERENCIAMENTO DE ACADEMIA ||");
//
//        while (true) {
//            try {
//                System.out.println("\n|| MENU PRINCIPAL ||");
//
//                System.out.println("\n(1) - Menu Cliente");
//                System.out.println("(3) - Ver relatórios");
//                System.out.println("(0) - Sair");
//                System.out.println("\nEscolha uma opção: ");
//
//                opcao = input.nextByte();
//                switch (opcao) {
//                    case 1:
//                        menuCliente();
//                        break;
//                    case 3:
//                        menuRelatorios();
//                        break;
//                    case 0:
//                        System.out.println("Aplicação encerrada.");
//                        System.exit(0);
//                        break;
//                    default:
//                        System.out.println(MensagemErroEnum.OPCAO_INVALIDA.getMensagem());
//                        break;
//                }
//            } catch (InputMismatchException e) {
//                System.out.println(MensagemExcecaoEnum.ENTRADA_INVALIDA.getMensagem());
//
//                input.nextLine();
//            }
//        }
//    }

//    /**
//     * Método que possuí um menu com as opções do cliente.
//     */
//    public static void menuCliente() {
//
//        while (true) {
//
//            System.out.println("\n|| MENU CLIENTE ||");
//
//            System.out.println("\n(1) - Cadastrar um cliente");
//            System.out.println("(2) - Buscar cliente");
//            System.out.println("(0) - Voltar");
//
//            opcao = input.nextByte();
//            switch (opcao) {
//                case 1:
//                    cadastroCliente();
//                    break;
//                case 2:
//                    buscarClientePeloNome();
//                    break;
//                case 0:
//                    menuPrincipal();
//                default:
//                    System.out.println(MensagemErroEnum.OPCAO_INVALIDA.getMensagem());
//                    break;
//            }
//        }
//    }

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
            int genero;
            String telefone;
            String senha;
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

                System.out.println("HORA DE ESCOLHER O SEU PLANO: ");
                clienteService.listarplanos();
                int plano = input.nextInt();
                if (plano == 0)
                    break;

                clienteService.cadastrarCliente(nome, idade, cpf, genero, telefone, email, senha, plano);
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
        inicio();

    }

    /**
     * Método que possuí um menu infinito que busca um cliente específico.
     */
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
     */
    public static void menuDoCliente() {

        System.out.println(OpcoesEnum.MENU_CLIENTE.getMensagem());

        while (true) {

            System.out.println(OpcoesEnum.OPCOES_MENU_CLIENTE.getMensagem());

            opcao = input.nextByte();
            switch (opcao) {
                case 1:
                    System.out.println("Opção escolhida: AGENDAMENTE. Vamos agendar seu treino.\n");
                    String nome;
                    input.nextLine();
                    do {
                        System.out.println("INFORME o NOME. O nome deve ser o mesmo nome do cadastro.");
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

                    String data;
                    do {
                        System.out.println("Escolha a DATA do treino. Atenção não poder ser uma data anterior a data atual no formato Dia/Mês/Ano.");
                        data = input.nextLine();
                        if (data.equals("0"))
                            break;
                    } while (agendamentoService.validarData(data));

                    System.out.println("Escolha a HORA do treino.");
                    String hora = input.nextLine();
                    if (hora.equals("0"))
                        break;

                    agendamentoService.criarAgendamento(nome, treino, data, hora);
                    break;

                case 2:
                    System.out.println("Opção escolhida: LISTAR AGENDA ATIVA. Vamos listar seus treinos ativos.\n");

                    input.nextLine();
                    System.out.println("INFORME SUA SENHA");
                    String senha = input.nextLine();
                    if (senha.equals("0") || senha.equals("00") || senha.equals("000"))
                        break;
                    System.out.println("\n");
                    clienteService.listarAgendamentosAtivos(senha);
                    break;

                case 3:
                    System.out.println("Opção escolhida: LISTAR AGENDA INATIVA. Vamos listar seus treinos inativos.\n");

                    input.nextLine();
                    System.out.println("INFORME SUA SENHA");
                    senha = input.nextLine();
                    if (senha.equals("0") || senha.equals("00") || senha.equals("000"))
                        break;

                    System.out.println("\n");
                    clienteService.listarAgendamentosInativos(senha);
                    break;

                case 4:
                    System.out.println("Opção escolhida: ATUALIZAR TREINO ATIVO. Vamos atualizar seus treinos ativos.\n");

                    input.nextLine();
                    System.out.println("INFORME SUA SENHA");
                    senha = input.nextLine();
                    if (senha.equals("0") || senha.equals("00") || senha.equals("000"))
                        break;

                    int trieinoEscolhido = 0;
                    int novoTreino = 0;
                    if (clienteService.listarAgendamentosAtivos(senha)){
                        System.out.println("\nFavor, escolha um treino que deseja atualizar");
                        trieinoEscolhido = input.nextInt();
                        if (trieinoEscolhido == 0)
                            break;

                        System.out.println("\n");
                        agendamentoService.listarTreinos();
                        System.out.println("\nEscolha seu novo treino");
                        novoTreino = input.nextInt();
                        if (novoTreino == 0)
                            break;

                        input.nextLine();
                        do {
                            System.out.println("Escolha a DATA do treino. Atenção não poder ser uma data anterior a data atual no formato Dia/Mês/Ano.");
                            data = input.nextLine();
                            if (data.equals("0"))
                                break;
                        } while (agendamentoService.validarData(data));

                        System.out.println("Escolha a HORA do treino.");
                        hora = input.nextLine();
                        if (hora.equals("0"))
                            break;
                    }else {
                        break;
                    }
                    agendamentoService.atualizarTreino(trieinoEscolhido, novoTreino, data, hora);

                    break;
                case 5:
                    System.out.println("Opção escolhida: CANCELAR TREINO. Vamos cancelar seu treino.\n");

                    input.nextLine();
                    System.out.println("INFORME SUA SENHA");
                    senha = input.nextLine();
                    if (senha.equals("0") || senha.equals("00") || senha.equals("000"))
                        break;

                    System.out.println("\n");
                    if (clienteService.listarAgendamentosAtivos(senha)) {
                        System.out.println("Favor, escolha um treino que deseja cancelar");
                        trieinoEscolhido = input.nextInt();
                        if (trieinoEscolhido == 0)
                            break;

                    }else {
                        break;
                    }
                    agendamentoService.cancelarTreinoAtivo(trieinoEscolhido);
                    break;
                case 0:
                    System.out.println("Saindo da conta...");
                    inicio();
                    break;
                default:
                    System.out.println(MensagemErroEnum.OPCAO_INVALIDA.getMensagem());
                    break;
            }
        }
    }

    /**
     * Método que possuí um menu infinito que mostra o relatório para o treino na academia.
     */
    public static void menuRelatorios() {

        System.out.println("\n|| RELATÓRIOS ||");
        System.out.println("\nOBS: Siga as instruções para gerar o relatório. Caso queira voltar ao menu, digite 0 a qualquer momento.\n");

        System.out.println("(1) - Gerar relatório da academia");
        System.out.println("(2) - Gerar relatório de um cliente específico");
        System.out.println("(3) - Gerar relatório de todos os clientes");
        System.out.println("(0) - Voltar");
        System.out.println("\nEscolha uma opção: ");

        opcao = input.nextByte();
        switch (opcao) {
            case 1:
                relatorioService.gerarRelatorioAcademia();
                break;

            case 2:
                String nome;
                input.nextLine();
                do {
                    System.out.println("INFORME O NOME. O nome deve conter no mínimo 10 caracteres e não pode haver números.");
                    nome = input.nextLine();
                } while (relatorioService.validarNome(nome));
                relatorioService.gerarRelatorioClienteEspecifico(nome);
                break;

            case 3:
                relatorioService.gerarRelatorioDeTodosClientes();
                break;
            case 0:
                //menuPrincipal();
                break;

            default:
                System.out.println(MensagemErroEnum.OPCAO_INVALIDA.getMensagem());
                break;
        }
    }
}