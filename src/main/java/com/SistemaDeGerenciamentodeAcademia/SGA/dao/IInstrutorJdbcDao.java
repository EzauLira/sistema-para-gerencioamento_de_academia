package com.SistemaDeGerenciamentodeAcademia.SGA.dao;

import com.SistemaDeGerenciamentodeAcademia.SGA.model.Agendamento;

import java.sql.SQLException;
import java.util.List;

/**
 * ‘Interface’ para operações relacionadas ao instrutor.
 * Define os métodos para listar agendamentos, treinos e buscar históricos dos clientes.
 */
public interface IInstrutorJdbcDao {

    //-------------------------------------------------------------------------------------------------------------------------------------------------------------------//

    /**
     * Método que executa a consulta SQL "SELECT * FROM login_instrutor" para efetuar o login do cliente no sistema.
     * Utiliza o bloco (try-with-resources) para garantir que a conexão com o banco de dados e outros recursos sejam fechados corretamente após o uso.
     * Os dados do instrutor são fornecidos pelos parâmetros (CPF e SENHA) e são consultados no banco de dados. Se existir, efetua o login.
     *
     * @param cpf   CPF do instrutor para login. Através deste CPF, o sistema coleta o ID do instrutor para acessar as demais opções do menu automaticamente.
     * @param senha Senha para logar na conta.
     * @throws SQLException Lança uma SQLException que será tratada na camada de serviço.
     */
    void LoginInstrutor(String cpf, String senha) throws SQLException;


    //-------------------------------------------------------------------------------------------------------------------------------------------------------------------//


    /**
     * Método que lista os agendamentos de hoje.
     * Utiliza o bloco (try-with-resources) para garantir que a conexão com o banco de dados e outros recursos sejam fechados corretamente após o uso.
     *
     * @return Lista de agendamentos de hoje.
     * @throws SQLException Lança uma SQLException que será tratada na service.
     */
    List<Agendamento> listarAgendamentosDeHoje() throws SQLException;


    //-------------------------------------------------------------------------------------------------------------------------------------------------------------------//


    /**
     * Método que lista os treinos de um cliente específico.
     * Utiliza o bloco (try-with-resources) para garantir que a conexão com o banco de dados e outros recursos sejam fechados corretamente após o uso.
     *
     * @param nome Nome do cliente para listar os treinos.
     * @return Lista de treinos do cliente específico.
     * @throws SQLException Lança uma SQLException que será tratada na service.
     */
    List<Agendamento> listarTreinosDeUmClienteEspecifico(String nome) throws SQLException;


    //-------------------------------------------------------------------------------------------------------------------------------------------------------------------//


    /**
     * Método que busca o histórico de treinos de um cliente específico.
     * Utiliza o bloco (try-with-resources) para garantir que a conexão com o banco de dados e outros recursos sejam fechados corretamente após o uso.
     *
     * @param nome Nome do cliente para buscar o histórico de treinos.
     * @return Lista de histórico de treinos do cliente específico.
     * @throws SQLException Lança uma SQLException que será tratada na service.
     */
    List<Agendamento> buscarHistoricoDeUmClienteEspecifico(String nome) throws SQLException;


    //-------------------------------------------------------------------------------------------------------------------------------------------------------------------//
}
