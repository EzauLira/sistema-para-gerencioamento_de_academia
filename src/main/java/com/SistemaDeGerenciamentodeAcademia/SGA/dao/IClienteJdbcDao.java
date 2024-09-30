package com.SistemaDeGerenciamentodeAcademia.SGA.dao;

import com.SistemaDeGerenciamentodeAcademia.SGA.dto.*;
import com.SistemaDeGerenciamentodeAcademia.SGA.model.Cliente;
import com.SistemaDeGerenciamentodeAcademia.SGA.model.Genero;

import java.sql.SQLException;
import java.util.List;


/**
 * ‘Interface’ para operações relacionadas ao cadastro de clientes na academia.
 * Define os métodos para cadastrar um novo cliente e buscar clientes pelo primeiro nome.
 */
public interface IClienteJdbcDao {

    //--------------------------------------------------------------------------------------------------------------------------------------//

    /**
     * Método a ser implementado, para fazer login no sistema tanto para usuário quanto para instrutor.
     * @param cpf passado para edentificar o usuário ou instrutor.
     * @param senha para acessar a conta.
     * @throws SQLException Lança uma SQLException que será tratada na service.
     */
    int fazerLoginCliente(String cpf, String senha) throws SQLException;


    //--------------------------------------------------------------------------------------------------------------------------------------//


    /**
     * Cadastra um novo cliente na academia com base nos dados fornecidos.
     *
     * @param cliente Um objeto {@link Cliente} contendo os dados necessários para o cadastro do cliente, como nome, e-mail, telefone, etc.
     * @throws SQLException Lança uma SQLException que será tratada na service.
     */
    void cadastrarCliente(Cliente cliente) throws SQLException;


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
    List<Genero> listarGenero() throws SQLException;


    //--------------------------------------------------------------------------------------------------------------------------------------//


    /**
     * Busca os dados do cliente através do primeiro nome.
     * @throws SQLException Lança uma SQLException que será tratada na service.
     */
    List<Cliente> buscarDadosPessoaisPeloPrimeiroNome(String nome) throws SQLException;


    //--------------------------------------------------------------------------------------------------------------------------------------//
}
