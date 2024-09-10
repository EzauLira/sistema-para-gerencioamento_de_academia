package com.SistemaDeGerenciamentodeAcademia.SGA.dao.impl;

import com.SistemaDeGerenciamentodeAcademia.SGA.config.BancoDadosConfig;
import com.SistemaDeGerenciamentodeAcademia.SGA.dao.IPlanoJdbcDao;
import com.SistemaDeGerenciamentodeAcademia.SGA.dto.PlanosDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PlanoJdbcDaoImpl implements IPlanoJdbcDao {

    @Override
    public List<PlanosDto> listarPlanos() throws SQLException {

        List<PlanosDto> listarPlanos = new ArrayList<>();

        Connection connection = BancoDadosConfig.getConnection();

            String sql = "SELECT * FROM plano";

            PreparedStatement ps = connection.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                PlanosDto planosDto = new PlanosDto(rs.getInt("id")
                        , rs.getString("nome")
                        , rs.getString("descricao")
                        , rs.getInt("duracao")
                        , rs.getInt("preco"));

                listarPlanos.add(planosDto);
            }

            connection.close();

        return listarPlanos;
    }
}
