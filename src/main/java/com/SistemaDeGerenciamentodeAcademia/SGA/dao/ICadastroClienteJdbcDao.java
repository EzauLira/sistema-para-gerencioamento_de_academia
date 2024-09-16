package com.SistemaDeGerenciamentodeAcademia.SGA.dao;

import com.SistemaDeGerenciamentodeAcademia.SGA.dto.AgendamentoDto;
import com.SistemaDeGerenciamentodeAcademia.SGA.dto.BuscarClienteDto;
import com.SistemaDeGerenciamentodeAcademia.SGA.dto.ClienteDto;


import java.sql.SQLException;


/**
 * Interface para operações relacionadas ao cadastro de clientes na academia.
 * Define os métodos para cadastrar um novo cliente e buscar clientes pelo primeiro nome.
 */
public interface ICadastroClienteJdbcDao {

    /**
     * Cadastra um novo cliente na academia com base nos dados fornecidos.
     *
     * @param clienteDto Um objeto {@link ClienteDto} contendo os dados necessários para o cadastro do cliente, como nome, e-mail, telefone, etc.
     * @throws SQLException Lança uma SQLException que será tratada na service.
     */
    void cadastrarCliente(ClienteDto clienteDto) throws SQLException;

    /**
     * Busca clientes pelo primeiro nome fornecido.
     *
     * @param buscarClienteDto Um objeto {@link BuscarClienteDto} contendo o primeiro nome do cliente a ser buscado.
     * @throws SQLException Lança uma SQLException que será tratada na service.
     */
    void buscarPessoaPeloPrimeiroNome(BuscarClienteDto buscarClienteDto) throws SQLException;
    void listaTreinosAtivos(AgendamentoDto agendamento) throws SQLException;
    void listaTreinosInativos(AgendamentoDto agendamento) throws SQLException;
    void listarGenero() throws SQLException;
}
