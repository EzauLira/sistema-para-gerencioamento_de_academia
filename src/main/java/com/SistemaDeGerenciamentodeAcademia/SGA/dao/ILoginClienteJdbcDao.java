package com.SistemaDeGerenciamentodeAcademia.SGA.dao;

import java.sql.SQLException;

public interface ILoginClienteJdbcDao {

    /**
     * Método a ser implementado, para fazer login no sistema tanto para usuário quanto para instrutor.
     * @param cpf passado para edentificar o usuário ou instrutor.
     * @param senha para acessar a conta.
     * @throws SQLException Lança uma SQLException que será tratada na service.
     */

    int fazerLoginCliente(String cpf, String senha) throws SQLException;
}
