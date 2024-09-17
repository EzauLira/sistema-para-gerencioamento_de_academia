package com.SistemaDeGerenciamentodeAcademia.SGA.controller;

import com.SistemaDeGerenciamentodeAcademia.SGA.config.Timer;
import com.SistemaDeGerenciamentodeAcademia.SGA.dto.ClienteDto;
import com.SistemaDeGerenciamentodeAcademia.SGA.dto.GeneroDto;
import com.SistemaDeGerenciamentodeAcademia.SGA.dto.PlanosDto;
import com.SistemaDeGerenciamentodeAcademia.SGA.dto.TreinosAtivosEInativosDto;
import com.SistemaDeGerenciamentodeAcademia.SGA.enuns.MensagemErroEnum;
import com.SistemaDeGerenciamentodeAcademia.SGA.enuns.MensagemExcecaoEnum;
import com.SistemaDeGerenciamentodeAcademia.SGA.enuns.OpcoesClientesEnum;
import com.SistemaDeGerenciamentodeAcademia.SGA.exception.*;
import com.SistemaDeGerenciamentodeAcademia.SGA.mdoel.Treino;
import com.SistemaDeGerenciamentodeAcademia.SGA.usecase.AgendamentoService;
import com.SistemaDeGerenciamentodeAcademia.SGA.usecase.ClienteService;
import com.SistemaDeGerenciamentodeAcademia.SGA.usecase.LoginClienteService;
import com.SistemaDeGerenciamentodeAcademia.SGA.view.Main;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class ClienteController {

    private static final Scanner input = new Scanner(System.in);
    private static final ClienteService clienteService = new ClienteService();
    private static final AgendamentoService agendamentoService = new AgendamentoService();
    private static final LoginClienteService loginClienteService = new LoginClienteService();

    public void loginCliente() {

        System.out.println(OpcoesClientesEnum.MENU_LOGIN_CLIENTE.getMensagem());
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

    public static void agendatTreino() {

        System.out.println("Opção escolhida: AGENDAMENTE. Vamos agendar seu treino.\n");
        while (true) {
            String nome;
            input.nextLine();
            do {
                System.out.println("INFORME o NOME. O nome deve ser o mesmo nome do cadastro. Digite 0 para voltar");
                nome = input.nextLine();
                if (nome.equals("0") || nome.equals("00") || nome.equals("000"))
                    break;
            } while (agendamentoService.validarNome(nome));

            System.out.println("\nO que você vai querer treinar? \n");
            listarTreinos();
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

            agendamentoService.agendarTreino(nome, treino, data, hora);
            break;
        }
    }

    public static void listarAgendaAtiva() {
        System.out.println("Opção escolhida: LISTAR AGENDA ATIVA. Vamos listar seus treinos ativos.\n");
        while (true) {
            input.nextLine();
            System.out.println("INFORME SUA SENHA");
            String senha = input.nextLine();
            if (senha.equals("0") || senha.equals("00") || senha.equals("000"))
                break;
            System.out.println("\n");
            listarAgendamentoAtivo(senha);
            break;
        }
    }

    public static void listarAgendaInativa() {
        while (true) {
            System.out.println("Opção escolhida: LISTAR AGENDA INATIVA. Vamos listar seus treinos inativos.\n");

            input.nextLine();
            System.out.println("INFORME SUA SENHA");
            String senha = input.nextLine();
            if (senha.equals("0") || senha.equals("00") || senha.equals("000"))
                break;

            System.out.println("\n");
            listarAgendamentoInativo(senha);
            break;
        }
    }

    public static void atualizarTreinoAtivo() {
        while (true) {
            System.out.println("Opção escolhida: ATUALIZAR TREINO ATIVO. Vamos atualizar seus treinos ativos.\n");

            input.nextLine();
            System.out.println("INFORME SUA SENHA");
            String senha = input.nextLine();
            if (senha.equals("0") || senha.equals("00") || senha.equals("000"))
                break;

            int trieinoEscolhido;
            int novoTreino;
            String data;
            String hora;
            System.out.println(" ");
            listarAgendamentoAtivo(senha);
            System.out.println("\nFavor, escolha um treino que deseja atualizar");
            trieinoEscolhido = input.nextInt();
            if (trieinoEscolhido == 0)
                break;

            System.out.println(" ");
            listarTreinos();
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
            agendamentoService.atualizarTreino(trieinoEscolhido, novoTreino, data, hora);
            break;
        }
    }

    public static void cancelarTreino() {
        while (true) {
            System.out.println("Opção escolhida: CANCELAR TREINO. Vamos cancelar seu treino.\n");

            input.nextLine();
            System.out.println("INFORME SUA SENHA");
            String senha = input.nextLine();
            if (senha.equals("0") || senha.equals("00") || senha.equals("000"))
                break;
            System.out.println(" ");

            int trieinoEscolhido;
            listarAgendamentoAtivo(senha);

            System.out.println("\nFavor, escolha um treino que deseja cancelar");
            trieinoEscolhido = input.nextInt();
            if (trieinoEscolhido == 0)
                break;
            agendamentoService.cancelarTreinoAtivo(trieinoEscolhido);
            break;
        }
    }

    /**
     * Método que possuí um menu infinito para cadastro de cliente.
     */
    public void cadastroCliente() {

        System.out.println(OpcoesClientesEnum.MENU_DO_CADASTRO_INFORMATIVO.getMensagem());

        while (true) {
            String nome;
            String cpf;
            int idade;
            int genero;
            String telefone;
            String senha;
            try {

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
                System.out.println(" ");
                listarGenero();
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
                System.out.println(" ");
                listarPlanos();
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
        Main.cliente();
    }

    /**
     * Método que possuí um menu infinito que marca um agendamento para o treino na academia.
     */
    public static void menuDoCliente() {

        System.out.println(OpcoesClientesEnum.MENU_INFORMATIVO_CLIENTE.getMensagem());

        while (true) {
            try {
                System.out.println(OpcoesClientesEnum.OPCOES_MENU_CLIENTE.getMensagem());
                byte opcao = input.nextByte();
                switch (opcao) {
                    case 1:
                        agendatTreino();
                        break;

                    case 2:
                        listarAgendaAtiva();
                        break;

                    case 3:
                        listarAgendaInativa();
                        break;

                    case 4:
                        atualizarTreinoAtivo();
                        break;
                    case 5:
                        cancelarTreino();
                        break;
                    case 6:
                        buscarDadosPessoaisPeloPrimeiroNome();
                        break;
                    case 0:
                        System.out.println("Saindo da conta...");
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

    public static void buscarDadosPessoaisPeloPrimeiroNome() {
        System.out.println(OpcoesClientesEnum.MENU_BUSCAR_CLIENTE_INFORMATIVO.getMensagem());

        while (true) {
            String nome;
            input.nextLine();
            System.out.println("INFORME SEU PRIMEIRO NOME.");
            nome = input.nextLine();
            System.out.println(" ");
            if (nome.equals("0") || nome.equals("00") || nome.equals("000")) {
                break;
            }
            buscarDadosPessoaisPeloNome(nome);
            break;
        }
    }

    public static void listarTreinos() {
        List<Treino> treinos = agendamentoService.listarTreinos();
        for (Treino t : treinos) {
            System.out.println("║" + t.getId() + " - " + t.getNome() + " - " + t.getDescricao());
        }
    }

    public static void listarAgendamentoAtivo(String senha) {
        List<TreinosAtivosEInativosDto> treino = clienteService.listarAgendamentosAtivos(senha);
        for (TreinosAtivosEInativosDto t : treino) {
            System.out.println("║" + "[" + t.getId() + "] - " + t.getNome() + " - " + t.getData() + " - " + t.getHora());
        }
    }

    public static void listarAgendamentoInativo(String senha) {
        List<TreinosAtivosEInativosDto> treino = clienteService.listarAgendamentosInativos(senha);
        for (TreinosAtivosEInativosDto t : treino) {
            System.out.println("║" + "[" + t.getId() + "] - " + t.getNome() + " - " + t.getData() + " - " + t.getHora());
        }
    }

    public static void listarGenero() {
        List<GeneroDto> generos = clienteService.listarGenero();
        for (GeneroDto g : generos) {
            System.out.println("║" + "[" + g.getId() + "] - " + g.getNome());
        }
    }

    public static void listarPlanos() {
        List<PlanosDto> planos = clienteService.listarplanos();
        for (PlanosDto p : planos) {
            System.out.println("║" + "[" + p.getId() + "] - " + p.getNome() + " - " + p.getDescricao() + " - " + p.getDuracao() + " - " + p.getPreco());
        }
    }

    public static void buscarDadosPessoaisPeloNome(String nome) {
        List<ClienteDto> clienteDto = clienteService.buscarDadosPessoaisPeloPrimeiroNome(nome);
        for (ClienteDto c : clienteDto) {
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
