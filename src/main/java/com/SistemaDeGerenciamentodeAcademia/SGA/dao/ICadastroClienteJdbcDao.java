package com.SistemaDeGerenciamentodeAcademia.SGA.dao;

import com.SistemaDeGerenciamentodeAcademia.SGA.config.BancoDadosConfig;
import com.SistemaDeGerenciamentodeAcademia.SGA.dto.BuscarClienteDto;
import com.SistemaDeGerenciamentodeAcademia.SGA.dto.ClienteDto;


import java.sql.SQLException;


public interface ICadastroClienteJdbcDao {

    void cadastrarCliente(ClienteDto clienteDto);

    void buscarPessoaPeloPrimeiroNome(BuscarClienteDto buscarClienteDto);

}
