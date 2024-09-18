package com.SistemaDeGerenciamentodeAcademia.SGA.dao;

import com.SistemaDeGerenciamentodeAcademia.SGA.dto.*;

import java.sql.SQLException;
import java.util.List;


/**
 * ‘Interface’ para operações relacionadas ao cadastro de clientes na academia.
 * Define os métodos para cadastrar um novo cliente e buscar clientes pelo primeiro nome.
 */
public interface ICadastroClienteJdbcDao {

    //--------------------------------------------------------------------------------------------------------------------------------------//


    /**
     * Cadastra um novo cliente na academia com base nos dados fornecidos.
     *
     * @param clienteDto Um objeto {@link ClienteDto} contendo os dados necessários para o cadastro do cliente, como nome, e-mail, telefone, etc.
     * @throws SQLException Lança uma SQLException que será tratada na service.
     */
    void cadastrarCliente(ClienteDto clienteDto) throws SQLException;


    //--------------------------------------------------------------------------------------------------------------------------------------//


    /**
     * Busca clientes pelo primeiro nome fornecido.
     *
     * @param nome Um objeto contendo o primeiro nome do cliente a ser buscado.
     * @throws SQLException Lança uma SQLException que será tratada na service.
     */
    List<ClienteDto> buscarPessoaPeloPrimeiroNome(String nome) throws SQLException;


    //--------------------------------------------------------------------------------------------------------------------------------------//

    /**
     * Lista Treinos ativos do cliente.
     *
     * @param id Um parametro {@link String} contendo a senha do cliente através dela todos os treinos ativos serão buscados.
     * @throws SQLException Lança uma SQLException que será tratada na service.
     */
    List<TreinosAtivosEInativosDto> listaTreinosAtivos(int id) throws SQLException;


    //--------------------------------------------------------------------------------------------------------------------------------------//

    /**
     * Lista Treinos inativos do cliente.
     *
     * @param id Um parametro {@link String} contendo a senha do cliente através dela todos os treinos inativos serão buscados.
     * @throws SQLException Lança uma SQLException que será tratada na service.
     */
    List<TreinosAtivosEInativosDto> listaTreinosInativos(int id) throws SQLException;


    //--------------------------------------------------------------------------------------------------------------------------------------//

    /**
     * Lista gêneros disponíveis.
     * @throws SQLException Lança uma SQLException que será tratada na service.
     */
    List<GeneroDto> listarGenero() throws SQLException;


    //--------------------------------------------------------------------------------------------------------------------------------------//


    /**
     * Busca os dados do cliente através do primeiro nome.
     * @throws SQLException Lança uma SQLException que será tratada na service.
     */
    List<ClienteDto> buscarDadosPessoaisPeloPrimeiroNome(String nome) throws SQLException;


    //--------------------------------------------------------------------------------------------------------------------------------------//
}
