package com.SistemaDeGerenciamentodeAcademia.SGA.dao.impl;

import com.SistemaDeGerenciamentodeAcademia.SGA.config.BancoDadosConfig;
import com.SistemaDeGerenciamentodeAcademia.SGA.dao.ICadastroClienteJdbcDao;
import com.SistemaDeGerenciamentodeAcademia.SGA.dto.BuscarClienteDto;
import com.SistemaDeGerenciamentodeAcademia.SGA.dto.ClienteDto;
import com.SistemaDeGerenciamentodeAcademia.SGA.exception.SqlException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CadastroClienteJdbcDaoImpl implements ICadastroClienteJdbcDao {

    public void cadastrarCliente(ClienteDto clienteDto) {
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

    @Override
    public void buscarPessoaPeloPrimeiroNome(BuscarClienteDto buscarClienteDto) {
        try (Connection connection = BancoDadosConfig.getConnection()) {
            String sql = "SELECT * FROM buscar_pessoa_pelo_primeiro_nome(?)";
            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setString(1, buscarClienteDto.getNome());
            ps.execute();

            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                String nomeCliente = rs.getString(1);

                System.out.println("-------------------------------------");
                System.out.println("Clientes encontrados: \n");
                System.out.println("Nome do cliente: " + nomeCliente);
                System.out.println("-------------------------------------");
            }

        }catch (SQLException e){
            SqlException.sqlException(e);
        }
    }
}
