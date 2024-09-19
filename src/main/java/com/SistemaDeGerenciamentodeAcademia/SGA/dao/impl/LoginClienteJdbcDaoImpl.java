package com.SistemaDeGerenciamentodeAcademia.SGA.dao.impl;

import com.SistemaDeGerenciamentodeAcademia.SGA.config.BancoDadosConfig;
import com.SistemaDeGerenciamentodeAcademia.SGA.dao.ILoginClienteJdbcDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginClienteJdbcDaoImpl implements ILoginClienteJdbcDao {

    public int fazerLoginCliente(String cpf, String senha) throws SQLException {
        String sql = "SELECT * FROM login_cliente(?,?)";
        try (Connection connection = BancoDadosConfig.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setString(1, cpf);
            ps.setString(2, senha);

            ps.execute();

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt("cliente_id");
                }
            }
        }
        return 0;
    }
}
