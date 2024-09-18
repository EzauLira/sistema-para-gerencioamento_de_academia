package com.SistemaDeGerenciamentodeAcademia.SGA.usecase;

import com.SistemaDeGerenciamentodeAcademia.SGA.dao.impl.LoginClienteJdbcDaoImpl;
import com.SistemaDeGerenciamentodeAcademia.SGA.dto.ClienteDto;
import com.SistemaDeGerenciamentodeAcademia.SGA.exception.SqlException;

import java.sql.SQLException;

public class LoginClienteService {

    private static final LoginClienteJdbcDaoImpl loginClienteJdbcDaoImpl = new LoginClienteJdbcDaoImpl();

    public int fazerLoginCliente(String cpf, String senha){
        try {
            return loginClienteJdbcDaoImpl.fazerLoginCliente(cpf, senha);
        }catch (SQLException e) {
            SqlException.sqlException(e);
        }
      return 0;
    }
}
