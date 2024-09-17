package com.SistemaDeGerenciamentodeAcademia.SGA.usecase;

import com.SistemaDeGerenciamentodeAcademia.SGA.dao.impl.ClienteJdbcDaoImpl;
import com.SistemaDeGerenciamentodeAcademia.SGA.dao.impl.PlanoJdbcDaoImpl;
import com.SistemaDeGerenciamentodeAcademia.SGA.dto.*;
import com.SistemaDeGerenciamentodeAcademia.SGA.enuns.MensagemSucessoEnum;
import com.SistemaDeGerenciamentodeAcademia.SGA.exception.SqlException;
import com.SistemaDeGerenciamentodeAcademia.SGA.mdoel.Treino;
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
    private static final ClienteJdbcDaoImpl clienteJdbcDaoImpl = new ClienteJdbcDaoImpl();
    private static final PlanoJdbcDaoImpl planoJdbcDaoImpl = new PlanoJdbcDaoImpl();

    /**
     * Lista todos os planos disponíveis e imprime as suas informações.
     * Exibe o ‘ID’, nome, descrição, duração e preço de cada plano.
     * Trata os erros vindo do banco de dados, mantados pela DAO através do (THROWS SQLEXCEPTION).
     */
    public List<PlanosDto> listarplanos() {
        try {
            List<PlanosDto> planos = planoJdbcDaoImpl.listarPlanos();
            return planos;
        } catch (SQLException e) {
            SqlException.sqlException(e);
        }
        return null;
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

        ClienteDto clienteDto = new ClienteDto(nome, idade, cpf, genero, telefone, email, senha, plano);

        try {
            clienteJdbcDaoImpl.cadastrarCliente(clienteDto);
        } catch (SQLException e) {
            SqlException.sqlException(e);
            sucesso = false;
        } finally {
            if (sucesso) {
                System.out.println(MensagemSucessoEnum.CADASTRO_EFETUADO.getMensagem());
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
        BuscarClienteDto buscarClienteDto = new BuscarClienteDto(nome);

        try {
            clienteJdbcDaoImpl.buscarPessoaPeloPrimeiroNome(buscarClienteDto);
        } catch (SQLException e) {
            SqlException.sqlException(e);
        }
    }

    public List<TreinosAtivosEInativosDto> listarAgendamentosAtivos(String senha){
        try {
            List<TreinosAtivosEInativosDto> treinos = clienteJdbcDaoImpl.listaTreinosAtivos(senha);
            return treinos;
        }catch (SQLException e){
            SqlException.sqlException(e);
        }
        return null;
    }

    public List<TreinosAtivosEInativosDto> listarAgendamentosInativos(String senha){
        try {
            List<TreinosAtivosEInativosDto> treinos = clienteJdbcDaoImpl.listaTreinosInativos(senha);
            return treinos;
        }catch (SQLException e){
            SqlException.sqlException(e);
        }
        return null;
    }

    public List<GeneroDto> listarGenero() {
        try {
            List<GeneroDto> generos = clienteJdbcDaoImpl.listarGenero();
            return generos;
        } catch (SQLException e) {
            SqlException.sqlException(e);
        }
        return null;
    }

    public List<ClienteDto> buscarDadosPessoaisPeloPrimeiroNome(String nome){
        try {
            List<ClienteDto> clienteDto = clienteJdbcDaoImpl.buscarDadosPessoaisPeloPrimeiroNome(nome);
            return clienteDto;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }
}
