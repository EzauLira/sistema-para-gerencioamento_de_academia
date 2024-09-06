package com.SistemaDeGerenciamentodeAcademia.SGA.dao.impl;

import com.SistemaDeGerenciamentodeAcademia.SGA.config.BancoDadosConfig;
import com.SistemaDeGerenciamentodeAcademia.SGA.dao.ICadastroClienteJdbcDao;
import com.SistemaDeGerenciamentodeAcademia.SGA.dto.ClienteDto;
import com.SistemaDeGerenciamentodeAcademia.SGA.exception.SqlException;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CadastroClienteJdbcDaoImpl implements ICadastroClienteJdbcDao {

    @Override
    public void CadastrarCliente(ClienteDto clienteDto) {
        try (Connection connection = BancoDadosConfig.getConnection()) {

            String sql = "SELECT * FROM cadastrar_cliente(?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setString(1, clienteDto.getNome());
            ps.setInt(2, clienteDto.getIdade());
            ps.setString(3, clienteDto.getCfp());
            ps.setString(4, clienteDto.getGenero());
            ps.setString(5, clienteDto.getTelefone());
            ps.setString(6, clienteDto.getEmail());
            ps.setInt(7, clienteDto.getIdPlano());
            ps.execute();
        } catch (SQLException e) {
            SqlException.sqlException(e);
        }
    }

}
