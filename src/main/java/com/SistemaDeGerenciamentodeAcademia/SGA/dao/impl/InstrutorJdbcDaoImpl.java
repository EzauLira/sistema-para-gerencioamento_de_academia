package com.SistemaDeGerenciamentodeAcademia.SGA.dao.impl;

import com.SistemaDeGerenciamentodeAcademia.SGA.config.BancoDadosConfig;
import com.SistemaDeGerenciamentodeAcademia.SGA.dao.IInstrutorJdbcDao;
import com.SistemaDeGerenciamentodeAcademia.SGA.model.Agendamento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class InstrutorJdbcDaoImpl implements IInstrutorJdbcDao {


    /**
     * Método que executa a colsulta SQL "SELECT * FROM login_instrutor" para efetuar o login do cliente no sistema.
     * Utiliza o bloco (try-with-resources) para garantir que a conexão com o banco de dados e outros recursos sejam fechados corretamente após o uso.
     * Os dados do instrutor são fornecidos pelos parâmetros (CPF e SENHA) são consultados no banco de dados se existir efetua o login.
     *
     * @param cpf   para login do instrutor. Através deste CPF eu coleto o id do instrutot para acessar as demais opções do menu automaticamente.
     * @param senha para logar na conta.
     * @throws SQLException Lança uma SQLException que será tratada na service.
     */
    @Override
    public void LoginInstrutor(String cpf, String senha) throws SQLException {
        String sql = "SELECT * FROM login_instrutor(?,?)";
        try (Connection connection = BancoDadosConfig.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setString(1, cpf);
            ps.setString(2, senha);

            ps.execute();

        }
    }

    //-------------------------------------------------------------------------------------------------------------------------------------------------------------------//

    /**
     * Método que lista os agendamentos de hoje.
     * Utiliza o bloco (try-with-resources) para garantir que a conexão com o banco de dados e outros recursos sejam fechados corretamente após o uso.
     *
     * @return Lista de agendamentos de hoje.
     * @throws SQLException Lança uma SQLException que será tratada na service.
     */
    @Override
    public List<Agendamento> listarAgendamentosDeHoje() throws SQLException {
        List<Agendamento> agendamentosHoje = new ArrayList<>();
        String sql = "SELECT * FROM listar_agendamentos_hoje()";
        try (Connection connection = BancoDadosConfig.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Agendamento agendamentoHoje = new Agendamento(
                        rs.getString("cliente_nome")
                        , rs.getString("treino_nome"));

                agendamentosHoje.add(agendamentoHoje);
            }

        }
        return agendamentosHoje;
    }

    //-------------------------------------------------------------------------------------------------------------------------------------------------------------------//

    /**
     * Método que lista os treinos de um cliente específico.
     * Utiliza o bloco (try-with-resources) para garantir que a conexão com o banco de dados e outros recursos sejam fechados corretamente após o uso.
     *
     * @param nome Nome do cliente para listar os treinos.
     * @return Lista de treinos do cliente específico.
     * @throws SQLException Lança uma SQLException que será tratada na service.
     */
    @Override
    public List<Agendamento> listarTreinosDeUmClienteEspecifico(String nome) throws SQLException {
        List<Agendamento> listarTreinosEspecifico = new ArrayList<>();

        String sql = "SELECT * FROM listar_treinos_de_um_cliente_especifico(?)";

        try (Connection connection = BancoDadosConfig.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setString(1, nome);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Agendamento listarAgendamentosEspecifico = new Agendamento(
                        rs.getString("treino_nome")
                        , rs.getString("data")
                        , rs.getString("hora")
                );
                    listarTreinosEspecifico.add(listarAgendamentosEspecifico);
            }
        }
        return listarTreinosEspecifico;
    }

    //-------------------------------------------------------------------------------------------------------------------------------------------------------------------//

    /**
     * Método que busca o histórico de treinos de um cliente específico.
     * Utiliza o bloco (try-with-resources) para garantir que a conexão com o banco de dados e outros recursos sejam fechados corretamente após o uso.
     *
     * @param nome Nome do cliente para buscar o histórico de treinos.
     * @return Lista de histórico de treinos do cliente específico.
     * @throws SQLException Lança uma SQLException que será tratada na service.
     */
    @Override
    public List<Agendamento> buscarHistoricoDeUmClienteEspecifico(String nome) throws SQLException {
        List<Agendamento> listarHistoricoTreinosEspecifico = new ArrayList<>();

        String sql = "SELECT * FROM listar_todos_treinos_por_cliente(?)";

        try (Connection connection = BancoDadosConfig.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setString(1, nome);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Agendamento listarHistoricoAgendamentosEspecifico = new Agendamento(
                        rs.getString("treino_nome")
                        , rs.getString("data")
                        , rs.getString("hora")
                );
                listarHistoricoTreinosEspecifico.add(listarHistoricoAgendamentosEspecifico);
            }
        }
        return listarHistoricoTreinosEspecifico;
    }

    //-------------------------------------------------------------------------------------------------------------------------------------------------------------------//
}
