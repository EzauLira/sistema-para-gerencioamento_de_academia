package com.SistemaDeGerenciamentodeAcademia.SGA.dao.impl;


import com.SistemaDeGerenciamentodeAcademia.SGA.config.BancoDadosConfig;
import com.SistemaDeGerenciamentodeAcademia.SGA.dao.IAgendamentoJdbcDao;
import com.SistemaDeGerenciamentodeAcademia.SGA.dto.AgendamentoDto;
import com.SistemaDeGerenciamentodeAcademia.SGA.exception.SqlException;
import com.SistemaDeGerenciamentodeAcademia.SGA.mdoel.Treino;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AgendamentoJdbcDaoImpl implements IAgendamentoJdbcDao {

    @Override
    public List<Treino> listarTreinos() {
        List<Treino> listarTreinos = new ArrayList<>();

        try(Connection connection = BancoDadosConfig.getConnection()) {

        String sql = "SELECT * FROM treino";

        PreparedStatement ps = connection.prepareStatement(sql);

        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            Treino treino = new Treino(rs.getInt("id")
                    , rs.getString("nome")
                    , rs.getString("descricao"));

            listarTreinos.add(treino);
        }
        }catch (SQLException e){
            SqlException.sqlException(e);
        }

        return listarTreinos;
    }

    @Override
    public void agendarTreino(AgendamentoDto agendamento) {

        try (Connection connection = BancoDadosConfig.getConnection()) {


            String sql = "SELECT * FROM agendar_treino(?, ?, ?, ?)";

            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setString(1, agendamento.getNome());
            ps.setInt(2, agendamento.getTreino());
            ps.setString(3, agendamento.getData());
            ps.setString(4, agendamento.getHora());

            ps.execute();
        }catch (SQLException e){
            SqlException.sqlException(e);
        }
    }

}