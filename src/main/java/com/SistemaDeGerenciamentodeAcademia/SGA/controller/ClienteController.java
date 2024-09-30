package com.SistemaDeGerenciamentodeAcademia.SGA.controller;

import com.SistemaDeGerenciamentodeAcademia.SGA.config.Timer;
import com.SistemaDeGerenciamentodeAcademia.SGA.model.Cliente;
import com.SistemaDeGerenciamentodeAcademia.SGA.model.Genero;
import com.SistemaDeGerenciamentodeAcademia.SGA.dto.TreinosAtivosEInativosDto;
import com.SistemaDeGerenciamentodeAcademia.SGA.enuns.MensagemErroEnum;
import com.SistemaDeGerenciamentodeAcademia.SGA.enuns.MensagemExcecaoEnum;
import com.SistemaDeGerenciamentodeAcademia.SGA.enuns.OpcoesClientesEnum;
import com.SistemaDeGerenciamentodeAcademia.SGA.exception.*;
import com.SistemaDeGerenciamentodeAcademia.SGA.model.Planos;
import com.SistemaDeGerenciamentodeAcademia.SGA.model.Treino;
import com.SistemaDeGerenciamentodeAcademia.SGA.usecase.AgendamentoService;
import com.SistemaDeGerenciamentodeAcademia.SGA.usecase.ClienteService;
import com.SistemaDeGerenciamentodeAcademia.SGA.utils.constantesUtils.MensagensConstanteUtils;
import com.SistemaDeGerenciamentodeAcademia.SGA.view.Main;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class ClienteController {

    private static final Scanner input = new Scanner(System.in);
    private static final ClienteService clienteService = new ClienteService();
    private static final AgendamentoService agendamentoService = new AgendamentoService();

    /**
     * Esté métodoto tem por sua finalidade cadastrar um cliente ou logar.
     */
    public static void clienteLogarOuCadastrar() {
        System.out.println(OpcoesClientesEnum.OPCOES_CLIENTE_LOGIN_OU_CADASTRO.getMensagem());
        do {
            System.out.print("");
            if (input.hasNextByte()) {
                byte loginCadastrar = input.nextByte();
                if (loginCadastrar == 1) {
                    input.nextLine();
                    loginCliente();
                } else if (loginCadastrar == 2) {
                    cadastroCliente();
                } else if (loginCadastrar == 0) {
                    Main.inicio();
                } else {
                    System.out.println(MensagemExcecaoEnum.ENTRADA_INVALIDA.getMensagem());
                }
            } else {
                System.out.println(MensagemExcecaoEnum.ENTRADA_INVALIDA.getMensagem());
                input.nextLine();
            }
        } while (true);
    }

    /**
     * Métod para fazer login como cliente.
     */
    public static void loginCliente() {
        System.out.println(OpcoesClientesEnum.MENU_LOGIN_CLIENTE.getMensagem());
        while (true) {

            System.out.println(MensagensConstanteUtils.LOGIN_DIGITE_CPF);
            String cpf = input.nextLine();
            if (cpf.equals("0")) {
                clienteLogarOuCadastrar();
            }

            System.out.println(MensagensConstanteUtils.LOGIN_DIGITE_SENHA);
            String senha = input.nextLine();
            if (senha.equals("0")) {
                clienteLogarOuCadastrar();
            }

            int id = clienteService.fazerLoginCliente(cpf, senha);

            if (id != MensagensConstanteUtils.ID_NAO_ENCONTRADO) {
                menuDoCliente(id);
                break;
            } else {
                do {
                    try {
                        System.out.println(OpcoesClientesEnum.MSG_TENTAR_NOVAMENTE.getMensagem());
                        byte op = input.nextByte();
                        if (op == 1) {
                            input.nextLine();
                            loginCliente();
                        } else if (op == 2) {
                            cadastroCliente();
                        } else if (op == 0) {
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

    /**
     * Método que possuí um menu infinito para cadastro de cliente.
     */
    public static void cadastroCliente() {

        System.out.println(OpcoesClientesEnum.MENU_DO_CADASTRO_INFORMATIVO.getMensagem());

        while (true) {
            String nome;
            String cpf;
            String idade;
            String genero;
            String telefone;
            String senha;

            try {
                input.nextLine();
                System.out.println(MensagensConstanteUtils.CADASTRO_INFORME_SEU_NOME);
                nome = input.nextLine();
                if (nome.equals("0") || nome.equals("00") || nome.equals("000"))
                    clienteLogarOuCadastrar();

                System.out.println(MensagensConstanteUtils.CADASTRO_INFORME_SUA_IDADE);
                idade = input.nextLine();
                if (idade.equals("0"))
                    clienteLogarOuCadastrar();

                System.out.println(MensagensConstanteUtils.CADASTRO_INFORME_SEU_CPF);
                cpf = input.nextLine();
                if (cpf.equals("0") || cpf.equals("00") || cpf.equals("000"))
                    clienteLogarOuCadastrar();

                System.out.println(MensagensConstanteUtils.CADASTRO_INFORME_SEU_GENERO);
                System.out.println(" ");
                listarGenero();
                genero = input.nextLine();
                if (genero.equals("0"))
                    clienteLogarOuCadastrar();

                System.out.println(MensagensConstanteUtils.CADASTRO_INFORME_SEU_TELEFONE);
                telefone = input.nextLine();
                if (telefone.equals("0") || telefone.equals("00") || telefone.equals("000"))
                    clienteLogarOuCadastrar();

                System.out.println(MensagensConstanteUtils.CADASTRO_INFORME_SEU_EMAIL);
                String email = input.nextLine();
                if (email.equals("0") || email.equals("00") || email.equals("000"))
                    clienteLogarOuCadastrar();

                System.out.println(MensagensConstanteUtils.CADASTRO_INFORME_SUA_SENHA);
                senha = input.nextLine();
                if (senha.equals("0") || senha.equals("00") || senha.equals("000"))
                    clienteLogarOuCadastrar();

                System.out.println(MensagensConstanteUtils.CADASTRO_ESCOLHA_SEU_PLANO);
                System.out.println(" ");
                listarPlanos();
                String plano = input.nextLine();
                if (plano.equals("0"))
                    clienteLogarOuCadastrar();

                clienteService.cadastrarCliente(nome, Integer.parseInt(idade), cpf, Integer.parseInt(genero), telefone, email, senha, Integer.parseInt(plano));
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
            } catch (InputMismatchException e) {
                System.out.println(MensagemExcecaoEnum.ENTRADA_INVALIDA.getMensagem());
            } catch (NumberFormatException e) {
                System.out.println(MensagensConstanteUtils.CADASTRO_ENTRADA_INVALIDA);
            }
            break;
        }
        clienteLogarOuCadastrar();
    }

    /**
     * Método usado para Agendar um treino.2
     *
     * @param id é passado como parâmetro para agendar um treino.
     */
    public static void agendatTreino(int id) {

        System.out.println(OpcoesClientesEnum.OP_ESCOLHIDA_AGENDADMENTO.getMensagem());
        System.out.println(OpcoesClientesEnum.MENU_AGENDAR_TREINO_INFORMATIVO.getMensagem());
        while (true) {

            System.out.println(MensagensConstanteUtils.AGENDA_OQUE_VAI_TREINAR);
            listarTreinos();
            int treino = input.nextInt();
            if (treino == 0)
                break;

            input.nextLine();

            String data;
            do {
                System.out.println(MensagensConstanteUtils.AGENDA_ESCOLHA_DATA);
                data = input.nextLine();
                if (data.equals("0"))
                    break;
            } while (agendamentoService.validarData(data));

            String hora;
            do {
                System.out.println(MensagensConstanteUtils.AGENDA_ESCOLHA_HORA);
                hora = input.nextLine();
                if (hora.equals("0"))
                    break;
            } while (agendamentoService.validarHora(hora));


            agendamentoService.agendarTreino(id, treino, data, hora);
            break;
        }
    }

    /**
     * Método usado para listar uma agenda ativa.
     *
     * @param id para listar uma agenda ativa.
     */
    public static void listarAgendaAtiva(int id) {
        System.out.println(OpcoesClientesEnum.OP_ESCOLHIDA_LISTA_ATIVA.getMensagem());
        listarAgendamentoAtivo(id);
    }

    /**
     * Métodopara listar uma agenda inativa.
     *
     * @param id como parâmetro para listar a agenda inativa do cliente.
     */
    public static void listarAgendaInativa(int id) {
        System.out.println(OpcoesClientesEnum.OP_ESCOLHIDA_LISTA_INATIVA.getMensagem());
        listarAgendamentoInativo(id);
    }

    /**
     * Método usado atualizar os treinos ativos do cliente.
     * @param id usado como parâmetro para atualizar treinos ativo.
     */
    public static void atualizarTreinoAtivo(int id) {
        boolean sucesso = true;

        while (true) {
            System.out.println(OpcoesClientesEnum.OP_ESCOLHIDA_TREINO_ATIVO.getMensagem());

            int trieinoEscolhido;
            int novoTreino;
            String data;
            String hora;
            System.out.println(" ");
            listarAgendamentoAtivo(id);
            System.out.println(MensagensConstanteUtils.ATUALIZAR_TREINO_QUE_DESEJA_ATUALIZAR);
            trieinoEscolhido = input.nextInt();
            if (trieinoEscolhido == 0)
                break;

            System.out.println(" ");
            listarTreinos();
            System.out.println(MensagensConstanteUtils.ATUALIZAR_NOVO_TREINO);
            novoTreino = input.nextInt();
            if (novoTreino == 0)
                break;

            input.nextLine();
            do {
                System.out.println(MensagensConstanteUtils.ATUALIZAR_ESCOLHA_DATA_TREINO);
                data = input.nextLine();
                if (data.equals("0"))
                    sucesso = false;
                    break;
            } while (agendamentoService.validarData(data));

            do {
                System.out.println(MensagensConstanteUtils.ATUALIZAR_ESCOLHA_HORA_TREINO);
                hora = input.nextLine();
                if (hora.equals("0"))
                    sucesso = false;
                    break;
            } while (agendamentoService.validarHora(hora));
            if (sucesso){
                agendamentoService. atualizarTreino(trieinoEscolhido, novoTreino, data, hora);
            }else {
                break;
            }
        }
    }

    /**
     * Método que cancela um treino especifico.
     *
     * @param id usado como parâmetro para atualizar treinos ativo.
     */
    public static void cancelarTreino(int id) {
        while (true) {
            System.out.println(OpcoesClientesEnum.OP_ESCOLHIDA_CANCELAR_TREINO.getMensagem());

            System.out.println(" ");

            int trieinoEscolhido;
            listarAgendamentoAtivo(id);

            System.out.println(MensagensConstanteUtils.CANCELAR_ESCOLHA_UM_TREINO_PARA_CANCELAR);
            trieinoEscolhido = input.nextInt();
            if (trieinoEscolhido == 0)
                break;
            agendamentoService.cancelarTreinoAtivo(trieinoEscolhido);
            break;
        }
    }

    /**
     * Método que busca dados de um cliente passando o primeiro nome.
     */
    public static void buscarDadosPessoaisPeloPrimeiroNome() {
        System.out.println(OpcoesClientesEnum.MENU_BUSCAR_CLIENTE_INFORMATIVO.getMensagem());

        while (true) {
            String nome;
            input.nextLine();
            System.out.println(MensagensConstanteUtils.DADOS_PESSOAIS);
            nome = input.nextLine();
            System.out.println(" ");
            if (nome.equals("0") || nome.equals("00") || nome.equals("000")) {
                break;
            }
            buscarDadosPessoaisPeloNome(nome);
            break;
        }
    }

    /**
     * Método que possuí um menu infinito que marca um agendamento para o treino na academia.
     */
    public static void menuDoCliente(int id) {

        System.out.println(OpcoesClientesEnum.MENU_INFORMATIVO_CLIENTE.getMensagem());

        while (true) {
            try {
                System.out.println(OpcoesClientesEnum.OPCOES_MENU_CLIENTE.getMensagem());
                byte opcao = input.nextByte();
                switch (opcao) {
                    case 1:
                        agendatTreino(id);
                        break;

                    case 2:
                        listarAgendaAtiva(id);
                        break;

                    case 3:
                        listarAgendaInativa(id);
                        break;

                    case 4:
                        atualizarTreinoAtivo(id);
                        break;
                    case 5:
                        cancelarTreino(id);
                        break;
                    case 6:
                        buscarDadosPessoaisPeloPrimeiroNome();
                        break;
                    case 0:
                        System.out.println(MensagensConstanteUtils.MENU_CLIENE_SAINDO);
                        Timer.tempoCorrido();
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

    /**
     * Método que lista os treinos.
     */
    public static void listarTreinos() {
        List<Treino> treinos = agendamentoService.listarTreinos();
        for (Treino t : treinos) {
            System.out.println("║" + t.getId() + " - " + t.getNome() + " - " + t.getDescricao());
        }
    }

    /**
     * Método para listar agendamentos ativos do cliente.
     *
     * @param id usado como parâmetro para listar o agendamento do cliente.
     */
    public static void listarAgendamentoAtivo(int id) {
        List<TreinosAtivosEInativosDto> treino = clienteService.listarAgendamentosAtivos(id);
        for (TreinosAtivosEInativosDto t : treino) {
            System.out.println("║" + "[" + t.getId() + "] - " + t.getNome() + " - " + t.getData() + " - " + t.getHora());
        }
    }

    /**
     * Método para listar agendamentos inativos do cliente.
     *
     * @param id para buscar a lista do cliente expecífico.
     */
    public static void listarAgendamentoInativo(int id) {
        List<TreinosAtivosEInativosDto> treino = clienteService.listarAgendamentosInativos(id);
        for (TreinosAtivosEInativosDto t : treino) {
            System.out.println("║" + "[" + t.getId() + "] - " + t.getNome() + " - " + t.getData() + " - " + t.getHora());
        }
    }

    /**
     * Método para listar os generos.
     */
    public static void listarGenero() {
        List<Genero> generos = clienteService.listarGenero();
        for (Genero g : generos) {
            System.out.println("║" + "[" + g.getId() + "] - " + g.getNome());
        }
    }

    /**
     * Método para listar os planos.
     */
    public static void listarPlanos() {
        List<Planos> planos = clienteService.listarplanos();
        for (Planos p : planos) {
            System.out.println("║" + "[" + p.getId() + "] - " + p.getNome() + " - " + p.getDescricao() + " - " + p.getDuracao() + " - " + p.getPreco());
        }
    }

    /**
     * Método para buscar os dados pessoais do cliente pessando o nome.
     *
     * @param nome é o parâmetro que será usado.
     */
    public static void buscarDadosPessoaisPeloNome(String nome) {
        List<Cliente> clientes = clienteService.buscarDadosPessoaisPeloPrimeiroNome(nome);
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
}