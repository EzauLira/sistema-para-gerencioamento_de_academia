package com.SistemaDeGerenciamentodeAcademia.SGA.usecase;

import com.SistemaDeGerenciamentodeAcademia.SGA.dao.impl.ClienteJdbcDaoImpl;
import com.SistemaDeGerenciamentodeAcademia.SGA.dao.impl.PlanoJdbcDaoImpl;
import com.SistemaDeGerenciamentodeAcademia.SGA.dto.*;
import com.SistemaDeGerenciamentodeAcademia.SGA.enuns.MensagemSucessoEnum;
import com.SistemaDeGerenciamentodeAcademia.SGA.exception.SqlException;
import com.SistemaDeGerenciamentodeAcademia.SGA.model.Cliente;
import com.SistemaDeGerenciamentodeAcademia.SGA.model.Genero;
import com.SistemaDeGerenciamentodeAcademia.SGA.model.Planos;
import com.SistemaDeGerenciamentodeAcademia.SGA.utils.validadores.*;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

/**
 * Serviço responsável pelo gerenciamento de clientes e planos na academia.
 * Inclui funcionalidades para listar planos, cadastrar clientes e buscar clientes pelo nome.
 */
public class ClienteService {

    /**
     * Atributos e objetos, privados e estáticos a serem usados nos métodos.
     */
    private static final ClienteJdbcDaoImpl clienteJdbcDaoImpl = new ClienteJdbcDaoImpl();
    private static final PlanoJdbcDaoImpl planoJdbcDaoImpl = new PlanoJdbcDaoImpl();

    /**
     * Método usando para fazer login com cliente no sistema.
     * @param cpf usasdo para ser o método de login do usuário.
     * @param senha usada para logar na conta.
     * @return retorna 0 caso o id do cliente não for encontrado.
     */
    public int fazerLoginCliente(String cpf, String senha){
        try {
            return clienteJdbcDaoImpl.fazerLoginCliente(cpf, senha);
        }catch (SQLException e) {
            SqlException.sqlException(e);
        }
        return 0;
    }

    /**
     * Lista todos os planos disponíveis e imprime as suas informações.
     * Exibe o ‘ID’, nome, descrição, duração e preço de cada plano.
     * Trata os erros vindo do banco de dados, mantados pela DAO através do (THROWS SQLEXCEPTION).
     */
    public List<Planos> listarplanos() {
        try {
            return planoJdbcDaoImpl.listarPlanos();
        } catch (SQLException e) {
            SqlException.sqlException(e);
        }
        return Collections.emptyList();
    }

    /**
     * Cadastra um novo cliente com base nas informações fornecidas.
     * Se o cadastro for realizado com sucesso, uma mensagem de sucesso é exibida.
     * Trata os erros vindo do banco de dados, mantados pela DAO através do (THROWS SQLEXCEPTION).
     *
     * @param nome     Nome do cliente.
     * @param idade    Idade do cliente.
     * @param cpf      CPF do cliente.
     * @param genero   Gênero do cliente (Masculino, Feminino ou Outros).
     * @param telefone Telefone do cliente.
     * @param email    Email do cliente.
     * @param senha    Senha para login futuro.
     * @param plano    ID do plano escolhido pelo cliente.
     */
    public void cadastrarCliente(String nome, int idade, String cpf, int genero, String telefone, String email, String senha, int plano) {
        boolean sucesso = true;

        ValidarNomeUtils.validarNome(nome);
        ValidarIDadeUtils.validarIdade(idade);
        ValidarCpfUtils.validarCpf(cpf);
        ValidarTelefoneUtils.validarTelefone(telefone);
        ValidarEmailUtils.validarEmail(email);

        Cliente cliente = new Cliente(nome, idade, cpf, genero, telefone, email, senha, plano);

        try {
            clienteJdbcDaoImpl.cadastrarCliente(cliente);
        } catch (SQLException e) {
            SqlException.sqlException(e);
            sucesso = false;
        } finally {
            if (sucesso) {
                System.out.println(MensagemSucessoEnum.CADASTRO_EFETUADO.getMensagem());
            }
        }
    }

    public List<TreinosAtivosEInativosDto> listarAgendamentosAtivos(int id) {
        try {
            return clienteJdbcDaoImpl.listaTreinosAtivos(id);
        } catch (SQLException e) {
            SqlException.sqlException(e);
        }
        return Collections.emptyList();
    }

    public List<TreinosAtivosEInativosDto> listarAgendamentosInativos(int id) {
        try {
            return clienteJdbcDaoImpl.listaTreinosInativos(id);
        } catch (SQLException e) {
            SqlException.sqlException(e);
        }
        return Collections.emptyList();
    }

    public List<Genero> listarGenero() {
        try {
            return clienteJdbcDaoImpl.listarGenero();
        } catch (SQLException e) {
            SqlException.sqlException(e);
        }
        return Collections.emptyList();
    }

    public List<Cliente> buscarDadosPessoaisPeloPrimeiroNome(String nome) {
        try {
            return clienteJdbcDaoImpl.buscarDadosPessoaisPeloPrimeiroNome(nome);

        } catch (SQLException e) {
            SqlException.sqlException(e);
        }
        return Collections.emptyList();
    }
}
