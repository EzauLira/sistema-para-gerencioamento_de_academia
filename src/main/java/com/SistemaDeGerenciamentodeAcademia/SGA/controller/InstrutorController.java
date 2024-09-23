package com.SistemaDeGerenciamentodeAcademia.SGA.controller;

import com.SistemaDeGerenciamentodeAcademia.SGA.config.Timer;
import com.SistemaDeGerenciamentodeAcademia.SGA.model.Agendamento;
import com.SistemaDeGerenciamentodeAcademia.SGA.enuns.MensagemErroEnum;
import com.SistemaDeGerenciamentodeAcademia.SGA.enuns.MensagemExcecaoEnum;
import com.SistemaDeGerenciamentodeAcademia.SGA.enuns.OpcoesInstrutorEnum;
import com.SistemaDeGerenciamentodeAcademia.SGA.model.Cliente;
import com.SistemaDeGerenciamentodeAcademia.SGA.usecase.ClienteService;
import com.SistemaDeGerenciamentodeAcademia.SGA.usecase.InstrutorService;
import com.SistemaDeGerenciamentodeAcademia.SGA.utils.constantesUtils.MensagensConstanteUtils;
import com.SistemaDeGerenciamentodeAcademia.SGA.utils.validadores.ValidarNomeRelatorioUtils;
import com.SistemaDeGerenciamentodeAcademia.SGA.view.Main;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class InstrutorController {

    /**
     * Atributos e objetos estáticos que estão a ser usados em mais de um método.
     */
    private static final Scanner input = new Scanner(System.in);
    private static final ClienteService clienteService = new ClienteService();
    private static final InstrutorService instrutorService = new InstrutorService();

    //-------------------------------------------------------------------------------------------------------------------------------------------------------------------//

    /**
     * Método responsável por efetuar login do instrutor.
     */
    public void loginInstrutor() {
        System.out.println(OpcoesInstrutorEnum.OPCOES_INSTRUTOR.getMensagem());
        System.out.println(" ");
        while (true) {
            System.out.println(MensagensConstanteUtils.LOGIN_DIGITE_CPF);
            String cpf = input.nextLine();
            if (cpf.equals("0")) {
                break;
            }

            System.out.println(MensagensConstanteUtils.LOGIN_DIGITE_SENHA);
            String senha = input.nextLine();
            if (senha.equals("0")) {
                break;
            }

            if (instrutorService.loginInstrutor(cpf, senha)) {
                menuDoInstrutor();
            } else {
                do {
                    try {

                        System.out.println(OpcoesInstrutorEnum.MSG_TENTAR_NOVAMENTE.getMensagem());
                        byte op = input.nextByte();
                        if (op == 1) {
                            input.nextLine();
                            loginInstrutor();
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
    }


    //-------------------------------------------------------------------------------------------------------------------------------------------------------------------//

    /**
     * Método que possuí um menu infinito com as opções de menu principal do instrutor.
     */
    public static void menuDoInstrutor() {

        System.out.println(OpcoesInstrutorEnum.MENU_PRINCIPAL_INFORMATIVO_INSTRUTOR.getMensagem());

        while (true) {
            try {
                System.out.println(OpcoesInstrutorEnum.OPCOES_MENU_INSTRUTOR.getMensagem());
                byte opcao = input.nextByte();
                switch (opcao) {
                    case 1:
                        listarAgendamentosDeHoje();
                        break;

                    case 2:
                        listarTreinosAtivosDeUmClienteEspecifico();
                        break;

                    case 3:
                        buscarHistoricoTreinosDeUmClienteEspecifico();
                        break;
                    case 4:
                        buscarDadosPessoaisPeloPrimeiroNome();
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

    //-------------------------------------------------------------------------------------------------------------------------------------------------------------------//

    /**
     * Este método lista todos os agendamentos que os clientes fizerem, ele busca os agendamentos com base na data local da máquina.
     * Ele verifica se a lista está vazia se estiver ele retorna um "Erro" informativo que vem do bando de dados.
     */
    public static void listarAgendamentosDeHoje() {
        System.out.println(OpcoesInstrutorEnum.OP_ESCOLHIDA_AGENDADMENTO_DO_DIA.getMensagem());
        System.out.println(" ");
        List<Agendamento> agendamentoHoje = instrutorService.listarAgendamentosDeHoje();
        if (agendamentoHoje == null) {
            return;
        }
        for (Agendamento a : agendamentoHoje) {
            System.out.println("║" + a.getNome() + " - " + a.getTreinoNome());
        }
    }

    //-------------------------------------------------------------------------------------------------------------------------------------------------------------------//

    /**
     * Este método lista todos os treinos que estão ativos de um cliente específico, através do nome ele busca os agendamentos ativos dos clientes.
     * Enquanto digitar o nome errado, retorna uma mensagem pedindo para colocar o nome correto, se digitar "0" ele volta para o menu de opções.
     */
    public static void listarTreinosAtivosDeUmClienteEspecifico() {
        System.out.println(OpcoesInstrutorEnum.OP_ESCOLHIDA_LISTAR_TREINOS_ATIVOS.getMensagem());
        System.out.println(OpcoesInstrutorEnum.MENU_BUSCAR_TREINO_INFORMATIVO.getMensagem());

        String nome;
        input.nextLine();
        do {
            System.out.println(MensagensConstanteUtils.BUSCAR_TREINOS_ATIVOS_NOME_DO_CLIENTE);
            nome = input.nextLine();
            if (nome.equals("0")) {
                menuDoInstrutor();
            }
        } while (ValidarNomeRelatorioUtils.validarNome(nome));
        imprimelistarTreinosAtivosDeUmClienteEspecifico(nome);
    }

    /**
     * Este método é a impressão do método [listar treinos ativos de um cliente específico].
     * Ele verifica se a lista está vazia se estiver ele retorna um "Erro" informativo que vem do bando de dados
     */
    public static void imprimelistarTreinosAtivosDeUmClienteEspecifico(String nome) {
        System.out.println(" ");
        List<Agendamento> listarTreinos = instrutorService.listarTreinosDeUmClienteEspecifico(nome);
        if (listarTreinos == null) {
            return;
        }
        for (Agendamento a : listarTreinos) {
            System.out.println("║" + a.getTreinoNome() + " - " + a.getData() + " - " + a.getHora());
        }
    }

    //-------------------------------------------------------------------------------------------------------------------------------------------------------------------//

    /**
     * Este método busca todos os treinos que estão ativos e inativos de um cliente específico, através do nome ele busca os agendamentos ativos dos clientes.
     * Enquanto digitar o nome errado, retorna uma mensagem pedindo para colocar o nome correto, se digitar "0" ele volta para o menu de opções.
     */
    public static void buscarHistoricoTreinosDeUmClienteEspecifico() {
        System.out.println(OpcoesInstrutorEnum.OP_ESCOLHIDA_BUSCAR_HISTORICO.getMensagem());
        System.out.println(OpcoesInstrutorEnum.MENU_BUSCAR_HISTORICO_TREINO_INFORMATIVO.getMensagem());

        System.out.println();
        String nome;
        input.nextLine();
        do {
            System.out.println(MensagensConstanteUtils.BUSCAR_HISTORICO_NOME_DO_CLIENTE);
            nome = input.nextLine();
            if (nome.equals("0")) {
                menuDoInstrutor();
            }
        } while (ValidarNomeRelatorioUtils.validarNome(nome));
        imprimeHistoricoTreinosDeUmClienteEspecifico(nome);
    }

    /**
     * Este método é a impressão do método [buscar Historico Treinos D eUm Cliente Específico].
     * Ele verifica se a lista está vazia se estiver ele retorna um "Erro" informativo que vem do bando de dados
     */
    public static void imprimeHistoricoTreinosDeUmClienteEspecifico(String nome) {
        System.out.println(" ");
        List<Agendamento> listarHistoricoTreinos = instrutorService.buscarHistoricoDeUmClienteEspecifico(nome);
        if (listarHistoricoTreinos == null) {
            return;
        }
        System.out.println(" ");
        for (Agendamento a : listarHistoricoTreinos) {
            System.out.println("║" + a.getTreinoNome() + " - " + a.getData() + " - " + a.getHora());
        }
    }


//-------------------------------------------------------------------------------------------------------------------------------------------------------------------//
    /**
     * Este método busca todos os dados pessoais de um cliente específico, através do nome ele busca os dados completos do cliente.
     * Se digitar "0" ele volta para o menu de opções.
     */
    public static void buscarDadosPessoaisPeloPrimeiroNome() {
        System.out.println(OpcoesInstrutorEnum.OP_ESCOLHIDA_BUSCAR_DADOS_PESSOAIS.getMensagem());
        System.out.println(OpcoesInstrutorEnum.MENU_BUSCAR_CLIENTE_INFORMATIVO.getMensagem());


        while (true) {
            String nome;
            input.nextLine();
            System.out.println(MensagensConstanteUtils.DADOS_PESSOAIS);
            nome = input.nextLine();
            System.out.println(" ");
            if (nome.equals("0") || nome.equals("00") || nome.equals("000")) {
                menuDoInstrutor();
            }
            imprimeBuscarDadosPessoaisPeloPrimeiroNome(nome);
            break;
        }
    }

    /**
     * Este método é a impressão do método [buscar Dados Pessoais Pelo Primeiro Nome].
     * Ele verifica se a lista está vazia se estiver ele retorna um "Erro" informativo que vem do bando de dados
     */
    public static void imprimeBuscarDadosPessoaisPeloPrimeiroNome(String nome) {
        List<Cliente> clientes = clienteService.buscarDadosPessoaisPeloPrimeiroNome(nome);
        if (clientes == null) {
            return;
        }
        for (Cliente c : clientes) {
            System.out.println(
                    "║ Nome: " + c.getNome() +
                            "\n║ CPF: " + c.getCpf() +
                            "\n║ Telefone: " + c.getTelefone() +
                            "\n║ Email: " + c.getEmail() +
                            "\n║ Senha: " + c.getSenha() +
                            "\n║ Plano: " + c.getPlano_nome());
        }
    }

    //-------------------------------------------------------------------------------------------------------------------------------------------------------------------//
}
