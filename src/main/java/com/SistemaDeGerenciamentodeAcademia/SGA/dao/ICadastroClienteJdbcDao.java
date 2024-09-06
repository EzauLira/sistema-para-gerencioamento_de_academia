package com.SistemaDeGerenciamentodeAcademia.SGA.dao;

import com.SistemaDeGerenciamentodeAcademia.SGA.dto.ClienteDto;


import java.sql.SQLException;


public interface ICadastroClienteJdbcDao {

    void CadastrarCliente(ClienteDto clienteDto) throws SQLException;

}
