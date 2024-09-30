package com.SistemaDeGerenciamentodeAcademia.SGA.dao.impl;

import com.SistemaDeGerenciamentodeAcademia.SGA.config.BancoDadosConfig;
import com.SistemaDeGerenciamentodeAcademia.SGA.dao.IAgendamentoJdbcDao;
import com.SistemaDeGerenciamentodeAcademia.SGA.model.Agendamento;
import com.SistemaDeGerenciamentodeAcademia.SGA.model.Treino;

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
     *  A consulta é executada e através do (while) os resultados são iterados para criar objetos (Treino) com os dados de ‘ID’, nome e descrição de cada treino.
     *  Esses objetos são adicionados a uma lista, que é então retornada para o chamador do método.
     *
     * @return Retorna uma lista de objetos {@link Treino} representando todos os treinos encontrados no banco de dados.
     * @throws SQLException Lança uma SQLException que será tratada na service.
     */
    @Override
    public List<Treino> listarTreinos() throws SQLException {
        List<Treino> listarTreinos = new ArrayList<>();

        String sql = "SELECT * FROM listar_treinos()";

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

    //--------------------------------------------------------------------------------------------------------------------------------------//

    /**
     * Agenda um treino na academia chamando a função (SELECT * FROM agendar_treino) no banco de dados.
     * A função recebe os dados do usuário e os insere conforme os parâmetros especificados.
     *
     * @param id, treino, data, hora Parâmetro que pega os dados do usuário para agendar um treino na academia.
     * @throws SQLException Lança uma SQLException que será tratada na service.
     */
    @Override
    public void agendarTreino(int id, int treino, String data, String hora) throws SQLException {

        String sql = "SELECT * FROM agendar_treino(?, ?, ?, ?)";

        try (Connection connection = BancoDadosConfig.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.setInt(2, treino);
            ps.setString(3, data);
            ps.setString(4, hora);

            ps.execute();
        }
    }

    //--------------------------------------------------------------------------------------------------------------------------------------//

    /**
     * Este método executa a consulta SQL (SELECT * FROM atualizar_agendamento) para atualizar um agendamento no banco de dados com base nos dados fornecidos.
     * Utiliza o bloco (try-with-resources) para garantir que a conexão com o banco de dados e outros recursos sejam fechados corretamente após o uso.
     * O parâmetro (agendamento) contém os dados do agendamento a ser atualizado. Os dados incluem o treino atual, o novo treino, a data e a hora.
     *
     * @param agendamento Parâmetro que contém os dados do agendamento a ser atualizado no banco de dados.
     * @throws SQLException Lança uma SQLException que será tratada na service.
     */
    @Override
    public void atualizarAgendamento(Agendamento agendamento) throws SQLException {
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

    //--------------------------------------------------------------------------------------------------------------------------------------//

    /**
     * Este método executa a consulta SQL (SELECT * FROM deletar_treino_ativo) para cancelar um treino ativo no banco de dados com base no ID do treino fornecido.
     * Utiliza o bloco (try-with-resources) para garantir que a conexão com o banco de dados e outros recursos sejam fechados corretamente após o uso.
     * O parâmetro (treino) contém o ID do treino a ser cancelado.
     *
     * @param treino Parâmetro que contém o ID do treino a ser cancelado no banco de dados.
     * @throws SQLException Lança uma SQLException que será tratada na service.
     */
    @Override
    public void calcelarTreino(int treino) throws SQLException {
        String sql = "SELECT * FROM deletar_treino_ativo(?)";

        try (Connection connection = BancoDadosConfig.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setInt(1, treino);

            ps.execute();

        }
    }

    //--------------------------------------------------------------------------------------------------------------------------------------//
}