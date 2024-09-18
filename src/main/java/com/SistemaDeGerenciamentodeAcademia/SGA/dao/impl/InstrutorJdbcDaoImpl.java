package com.SistemaDeGerenciamentodeAcademia.SGA.dao.impl;

import com.SistemaDeGerenciamentodeAcademia.SGA.config.BancoDadosConfig;
import com.SistemaDeGerenciamentodeAcademia.SGA.dao.IInstrutorJdbcDao;
import com.SistemaDeGerenciamentodeAcademia.SGA.dto.InstrutorDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InstrutorJdbcDaoImpl implements IInstrutorJdbcDao {


    /**
     *  Este método executa a consulta SQL "SELECT * FROM cadastrar_instrutor" para novos instrutores no banco de dados.
     *  Utiliza o bloco (try-with-resources) para garantir que a conexão com o banco de dados e outros recursos sejam fechados corretamente após o uso.
     *
     * @throws SQLException Lança uma SQLException que será tratada na service.
     */
    public void cadastrarInstrutor(InstrutorDto instrutorDto) throws SQLException {
        String sql = "SELECT * FROM cadastrar_instrutor(?, ?, ?, ?, ?, ?)";
        try (Connection connection = BancoDadosConfig.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setString(1, instrutorDto.getNome());
            ps.setString(2, instrutorDto.getCpf());
            ps.setInt(3, instrutorDto.getGenero());
            ps.setString(4, instrutorDto.getTelefone());
            ps.setString(5, instrutorDto.getEmail());
            ps.setString(6, instrutorDto.getSenha());

            ps.execute();

        }
    }
}
