package com.SistemaDeGerenciamentodeAcademia.SGA.view;

import com.SistemaDeGerenciamentodeAcademia.SGA.controller.ClienteController;
import com.SistemaDeGerenciamentodeAcademia.SGA.controller.InstrutorController;
import com.SistemaDeGerenciamentodeAcademia.SGA.dto.ClienteDto;
import com.SistemaDeGerenciamentodeAcademia.SGA.enuns.*;
import com.SistemaDeGerenciamentodeAcademia.SGA.usecase.ClienteService;
import com.SistemaDeGerenciamentodeAcademia.SGA.usecase.RelatorioService;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {

    /**
     * Atributos e objetos estáticos que estão a ser usados em mais de um método.
     */
    private static final Scanner input = new Scanner(System.in);
    private static byte opcao;
    private static final ClienteService clienteService = new ClienteService();
    private static final RelatorioService relatorioService = new RelatorioService();
    private static final ClienteController clienteController = new ClienteController();
    private static final InstrutorController instrutorController = new InstrutorController();

    public static void main(String[] args) {

        inicio();

    }

    public static void inicio() {
        System.out.printf(CabecalhoSgaEnum.CABECALHO.getMensagem());

        while (true) {
            try {
                System.out.println(OpcoesClientesEnum.OPCOES_ENUM.getMensagem());
                byte opcao = input.nextByte();
                switch (opcao) {

                    case 1:
                        cliente();
                        break;

                    case 2:
                        System.out.println(OpcoesInstrutorEnum.OPCOES_INSTRUTOR.getMensagem());
                        instrutorController.loginInstrutor();
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

    public static void cliente() {
        System.out.println(OpcoesClientesEnum.OPCOES_CLIENTE_LOGIN_OU_CADASTRO.getMensagem());
        do {
            System.out.print("");
            if (input.hasNextByte()) {
                byte loginCadastrar = input.nextByte();
                if (loginCadastrar == 1) {
                    clienteController.loginCliente();
                } else if (loginCadastrar == 2) {
                    clienteController.cadastroCliente();
                }else if (loginCadastrar == 0 ){
                    inicio();
                }else {
                    System.out.println(MensagemExcecaoEnum.ENTRADA_INVALIDA.getMensagem());
                }
            } else {
                System.out.println(MensagemExcecaoEnum.ENTRADA_INVALIDA.getMensagem());
                input.next();
            }
        } while (true);
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

    public static void listaRetornadaDaBuscaDocliente(String nome){
        List<ClienteDto> cliente = clienteService.buscarClientePeloPrimeiroNome(nome);
        for (ClienteDto c : cliente){
            System.out.println("-------------------------------------");
            System.out.println("Clientes encontrados: \n");
            System.out.println("Nome do cliente: " + c.getNome());
            System.out.println("-------------------------------------");
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