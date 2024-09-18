package com.SistemaDeGerenciamentodeAcademia.SGA.dao;

import com.SistemaDeGerenciamentodeAcademia.SGA.dto.ClienteDto;

import java.sql.SQLException;

public interface ILoginClienteJdbcDao {

    int fazerLoginCliente(String cpf, String senha) throws SQLException;
}
