package com.SistemaDeGerenciamentodeAcademia.SGA.dao;

import com.SistemaDeGerenciamentodeAcademia.SGA.dto.ClienteDto;

import java.sql.SQLException;

public interface ILoginClienteJdbcDao {

    void fazerLoginCliente(ClienteDto clienteDto) throws SQLException;
}
