package com.SistemaDeGerenciamentodeAcademia.SGA.usecase;

import com.SistemaDeGerenciamentodeAcademia.SGA.dao.impl.CadastroClienteJdbcDaoImpl;
import com.SistemaDeGerenciamentodeAcademia.SGA.dao.impl.PlanoJdbcDaoImpl;
import com.SistemaDeGerenciamentodeAcademia.SGA.dto.BuscarClienteDto;
import com.SistemaDeGerenciamentodeAcademia.SGA.dto.ClienteDto;
import com.SistemaDeGerenciamentodeAcademia.SGA.dto.PlanosDto;
import com.SistemaDeGerenciamentodeAcademia.SGA.enuns.MensagemSucesso;
import com.SistemaDeGerenciamentodeAcademia.SGA.exception.SqlException;
import com.SistemaDeGerenciamentodeAcademia.SGA.utils.validadorCliente.*;

import java.sql.SQLException;
import java.util.List;

/**
 * Serviço responsável pelo gerenciamento de clientes e planos na academia.
 * Inclui funcionalidades para listar planos, cadastrar clientes e buscar clientes pelo nome.
 */
public class ClienteService {

    /**
     * Atributos e objetos, privados e estáticos a serem usados nos métodos.
     */
    private boolean sucesso;
    private static final CadastroClienteJdbcDaoImpl cadastroClienteJdbcDaoImpl = new CadastroClienteJdbcDaoImpl();
    private static final PlanoJdbcDaoImpl planoJdbcDaoImpl = new PlanoJdbcDaoImpl();

    /**
     * Lista todos os planos disponíveis e imprime suas informações.
     * Exibe o ID, nome, descrição, duração e preço de cada plano.
     * Trata os erros vindo do banco de dados, mantados pela DAO através do (THROWS SQLEXCEPTION).
     */
    public void listarplanos() {
        try {
            List<PlanosDto> planos = planoJdbcDaoImpl.listarPlanos();

            for (PlanosDto p : planos) {
                System.out.println(p.getId() + " - " + p.getNome() + " - " + p.getDescricao() + " - " + p.getDuracao() + " - " + p.getPreco());
            }
        } catch (SQLException e) {
            SqlException.sqlException(e);
        }
    }

    /**
     * Cadastra um novo cliente com base nas informações fornecidas.
     * Se o cadastro for realizado com sucesso, uma mensagem de sucesso é exibida.
     * Trata os erros vindo do banco de dados, mantados pela DAO através do (THROWS SQLEXCEPTION).
     *
     * @param nome Nome do cliente.
     * @param idade Idade do cliente.
     * @param cpf CPF do cliente.
     * @param genero Gênero do cliente ('M' para masculino ou 'F' para feminino).
     * @param telefone Telefone do cliente.
     * @param email Email do cliente.
     * @param plano ID do plano escolhido pelo cliente.
     */
    public void cadastrarCliente(String nome, int idade, String cpf, String genero, String telefone, String email, int plano) {
        sucesso = true;

        ValidarNomeUtils.validarNome(nome);
        ValidarIDadeUtils.validarIdade(idade);
        ValidarCpfUtils.validarCpf(cpf);
        ValidarGeneroUtils.validarGenero(genero);
        ValidarTelefoneUtils.validarTelefone(telefone);
        ValidarEmailUtils.validarEmail(email);

        ClienteDto clienteDto = new ClienteDto(nome, idade, cpf, genero, telefone, email, plano);

        try {
            cadastroClienteJdbcDaoImpl.cadastrarCliente(clienteDto);
        } catch (SQLException e) {
            SqlException.sqlException(e);
            sucesso = false;
        } finally {
            if (sucesso) {
                System.out.println(MensagemSucesso.CADASTRO_EFETUADO.getMensagem());
            }
        }
    }

    /**
     * Busca um cliente pelo primeiro nome.
     * Se a busca for realizada com sucesso, uma mensagem de sucesso é exibida.
     * Trata os erros vindo do banco de dados, mantados pela DAO através do (THROWS SQLEXCEPTION).
     *
     * @param nome Nome do cliente a ser buscado.
     */
    public void buscarClientePeloPrimeiroNome(String nome) {
        sucesso = true;
        BuscarClienteDto buscarClienteDto = new BuscarClienteDto(nome);

        try {
            cadastroClienteJdbcDaoImpl.buscarPessoaPeloPrimeiroNome(buscarClienteDto);
        } catch (SQLException e) {
            SqlException.sqlException(e);
            sucesso = false;
        } finally {
            if (sucesso) {
                System.out.println(MensagemSucesso.AGENDAMENTO_EFETUADO.getMensagem());
            }
        }
    }
}
