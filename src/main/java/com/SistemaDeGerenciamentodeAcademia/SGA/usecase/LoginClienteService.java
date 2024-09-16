package com.SistemaDeGerenciamentodeAcademia.SGA.usecase;

import com.SistemaDeGerenciamentodeAcademia.SGA.dao.impl.LoginClienteJdbcDaoImpl;
import com.SistemaDeGerenciamentodeAcademia.SGA.dto.ClienteDto;
import com.SistemaDeGerenciamentodeAcademia.SGA.exception.SqlException;

import java.sql.SQLException;

public class LoginClienteService {

    private static final LoginClienteJdbcDaoImpl loginClienteJdbcDaoImpl = new LoginClienteJdbcDaoImpl();

    public boolean fazerLoginCliente(String cpf, String senha){
        ClienteDto clienteDto = new ClienteDto(cpf, senha);

        try {
            loginClienteJdbcDaoImpl.fazerLoginCliente(clienteDto);
        }catch (SQLException e) {
            SqlException.sqlException(e);
            return false;
        }
        return true;
    }
}
