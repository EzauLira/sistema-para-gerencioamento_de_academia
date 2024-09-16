package com.SistemaDeGerenciamentodeAcademia.SGA.dao.impl;

import com.SistemaDeGerenciamentodeAcademia.SGA.config.BancoDadosConfig;
import com.SistemaDeGerenciamentodeAcademia.SGA.dao.IAgendamentoJdbcDao;
import com.SistemaDeGerenciamentodeAcademia.SGA.dto.AgendamentoDto;
import com.SistemaDeGerenciamentodeAcademia.SGA.mdoel.Treino;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AgendamentoJdbcDaoImpl implements IAgendamentoJdbcDao {

    /**
     *  Este método executa a consulta SQL "SELECT * FROM treino" para listar todos os treinos armazenados no banco de dados.
     *  Utiliza o bloco (try-with-resources) para garantir que a conexão com o banco de dados e outros recursos sejam fechados corretamente após o uso.
     *  A consulta é executada e através do (while) os resultados são iterados para criar objetos (Treino) com os dados de ID, nome e descrição de cada treino.
     *  Esses objetos são adicionados a uma lista, que é então retornada para o chamador do método.
     *
     * @return Retorna uma lista de objetos {@link Treino} representando todos os treinos encontrados no banco de dados.
     * @throws SQLException Lança uma SQLException que será tratada na service.
     */
    @Override
    public List<Treino> listarTreinos() throws SQLException {
        List<Treino> listarTreinos = new ArrayList<>();

        String sql = "SELECT * FROM treino";

        try (Connection connection = BancoDadosConfig.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Treino treino = new Treino(rs.getInt("id")
                        , rs.getString("nome")
                        , rs.getString("descricao"));

                listarTreinos.add(treino);
            }
        }
        return listarTreinos;
    }

    /**
     * Agenda um treino na academia chamando a função (SELECT * FROM agendar_treino) no banco de dados.
     * A função recebe os dados do usuário e os insere conforme os parâmetros especificados.
     *
     * @param agendamento Parâmetro que pega os dados do usuário para agendar um treino na academia.
     * @throws SQLException Lança uma SQLException que será tratada na service.
     */
    @Override
    public void agendarTreino(AgendamentoDto agendamento) throws SQLException {

        String sql = "SELECT * FROM agendar_treino(?, ?, ?, ?)";

        try (Connection connection = BancoDadosConfig.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setString(1, agendamento.getNome());
            ps.setInt(2, agendamento.getTreino());
            ps.setString(3, agendamento.getData());
            ps.setString(4, agendamento.getHora());

            ps.execute();
        }
    }

    public void atualizarAgendamento(AgendamentoDto agendamento) throws SQLException {
        String sql = "SELECT * FROM atualizar_agendamento(?,?,?,?)";

        try (Connection connection = BancoDadosConfig.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql)) {


            ps.setInt(1, agendamento.getTreino());
            ps.setInt(2, agendamento.getNovoTreino());
            ps.setString(3, agendamento.getData());
            ps.setString(4, agendamento.getHora());

            ps.execute();
        }
    }

    public void calcelarTreinoTreino(AgendamentoDto agendamentoDto) throws SQLException{
        String sql = "SELECT * FROM deletar_treino_ativo(?)";

        try (Connection connection = BancoDadosConfig.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setInt(1, agendamentoDto.getTreino());

            ps.execute();

        }
    }
}