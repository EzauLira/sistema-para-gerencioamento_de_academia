package com.SistemaDeGerenciamentodeAcademia.SGA.dao.impl;

import com.SistemaDeGerenciamentodeAcademia.SGA.config.BancoDadosConfig;
import com.SistemaDeGerenciamentodeAcademia.SGA.dao.ILoginClienteJdbcDao;
import com.SistemaDeGerenciamentodeAcademia.SGA.dto.ClienteDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginClienteJdbcDaoImpl implements ILoginClienteJdbcDao {

    public void fazerLoginCliente(ClienteDto clienteDto) throws SQLException {
        String sql = "SELECT * FROM login_cliente(?,?)";
        try (Connection connection = BancoDadosConfig.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setString(1, clienteDto.getCpf());
            ps.setString(2, clienteDto.getSenha());

            ps.execute();

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    String retorno = rs.getString(1);
                    System.out.println("\n"+retorno+"\n");
                }
            }
        }
    }
}
