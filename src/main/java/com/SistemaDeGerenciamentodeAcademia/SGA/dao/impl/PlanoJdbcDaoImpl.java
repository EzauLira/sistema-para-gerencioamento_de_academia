package com.SistemaDeGerenciamentodeAcademia.SGA.dao.impl;

import com.SistemaDeGerenciamentodeAcademia.SGA.config.BancoDadosConfig;
import com.SistemaDeGerenciamentodeAcademia.SGA.dao.IPlanoJdbcDao;
import com.SistemaDeGerenciamentodeAcademia.SGA.model.Planos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PlanoJdbcDaoImpl implements IPlanoJdbcDao {

    /**
     * Este método executa a consulta SQL "SELECT * FROM plano" para listar todos os planos disponíveis no banco de dados.
     * Utiliza o bloco (try-with-resources) para garantir que a conexão com o banco de dados e outros recursos sejam fechados corretamente após o uso.
     * Para cada plano encontrado na base de dados, um objeto (PlanosDto) é criado e adicionado a uma lista, que é retornada ao final.
     *
     * @return Uma lista de objetos (PlanosDto), onde cada objeto representa um plano com detalhes como ID, nome, descrição, duração e preço.
     * @throws SQLException Lança uma SQLException que será tratada na service.
     */
    @Override
    public List<Planos> listarPlanos() throws SQLException {
        List<Planos> listarPlanos = new ArrayList<>();

        String sql = "SELECT * FROM plano";

        try (Connection connection = BancoDadosConfig.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Planos planosDto = new Planos(rs.getInt("id")
                        , rs.getString("nome")
                        , rs.getString("descricao")
                        , rs.getInt("duracao")
                        , rs.getInt("preco"));

                listarPlanos.add(planosDto);
            }
        }
        return listarPlanos;
    }
}
