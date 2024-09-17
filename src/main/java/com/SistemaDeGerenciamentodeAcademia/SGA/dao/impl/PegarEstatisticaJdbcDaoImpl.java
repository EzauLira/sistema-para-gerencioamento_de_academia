package com.SistemaDeGerenciamentodeAcademia.SGA.dao.impl;

import com.SistemaDeGerenciamentodeAcademia.SGA.config.BancoDadosConfig;
import com.SistemaDeGerenciamentodeAcademia.SGA.dao.IPegarEstatisticaJdbcDao;
import com.SistemaDeGerenciamentodeAcademia.SGA.dto.ColetarRelatorioDto;

import java.sql.*;

public class PegarEstatisticaJdbcDaoImpl implements IPegarEstatisticaJdbcDao {

    /**
     * Este método executa a consulta SQL "SELECT * FROM gerar_relatorio_academia" para gerar um relatório geral da academia.
     * Utiliza o bloco (try-with-resources) para garantir que a conexão com o banco de dados e outros recursos sejam fechados corretamente após o uso.
     * O relatório exibe o total de clientes cadastrados e a quantidade de planos vendidos (mensal, anual e trimestral).
     *
     * @throws SQLException Lança uma SQLException que será tratada na service.
     */
    @Override
    public void gerarRelatorioAcademia() throws SQLException {

        String sql = "SELECT * FROM gerar_relatorio_academia()";

        try (Connection connection = BancoDadosConfig.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                int totalClientes = rs.getInt(1);
                String planoMensal = rs.getString(2);
                String planoAnual = rs.getString(3);
                String panoTrimestral = rs.getString(4);

                System.out.println("-------------------------------------------");
                System.out.println("Informações gerias da academia: \n");
                System.out.println("Total de cadastros: " + totalClientes);
                System.out.println("Plano mensal vendidos: " + planoMensal);
                System.out.println("Plano Anual vendido: " + planoAnual);
                System.out.println("Plano Trimestral vendido: " + panoTrimestral);
                System.out.println("-------------------------------------------");
            }

        }
    }

    /**
     * Este método executa a consulta SQL "SELECT * FROM gerar_relatorio_cliente_especifico" para gerar um relatório específico de um cliente com base no nome fornecido.
     * Utiliza o bloco (try-with-resources) para garantir que a conexão com o banco de dados e outros recursos sejam fechados corretamente após o uso.
     * O relatório inclui informações sobre o plano escolhido, o último treino feito, e a data e hora desse treino.
     *
     * @param nome Objeto (ColetarRelatorioDto) que contém o nome do cliente para gerar o relatório específico.
     * @throws SQLException Lança uma SQLException que será tratada na service.
     */
    @Override
    public void gerarRelatorioClienteEspecifico(ColetarRelatorioDto nome) throws SQLException {

        String sql = "SELECT * FROM gerar_relatorio_cliente_especifico(?)";

        try (Connection connection = BancoDadosConfig.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setString(1, nome.getNome());
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String nomeCliente = rs.getString(1);
                String nomePlano = rs.getString(2);
                String nomeTreino = rs.getString(3);
                String dataTreino = rs.getString(4);
                String horaTreino = rs.getString(5);

                System.out.println("-------------------------------------");
                System.out.println("Informações do cliente solicidado: \n");
                System.out.println("Nome do cliente: " + nomeCliente);
                System.out.println("Plano escolhido: " + nomePlano);
                System.out.println("Último treino feito: " + nomeTreino);
                System.out.println("Data do treino: " + dataTreino);
                System.out.println("Hora do treino: " + horaTreino);
                System.out.println("-------------------------------------");
            }
        }
    }

    /**
     * Este método executa a consulta SQL "SELECT * FROM gerar_relatorio_cliente()" para gerar um relatório com informações de todos os clientes.
     * Utiliza o bloco (try-with-resources) para garantir que a conexão com o banco de dados e outros recursos sejam fechados corretamente após o uso.
     * O relatório inclui o nome do cliente, o plano escolhido, o último treino feito, e a data e hora desse treino.
     *
     * @throws SQLException Lança uma SQLException que será tratada na service.
     */
    @Override
    public void gerarRelatorioTodosClientes() throws SQLException {

        String sql = "SELECT * FROM gerar_relatorio_cliente()";

        try (Connection connection = BancoDadosConfig.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                String nomeCliente = rs.getString(1);
                String nomePlano = rs.getString(2);
                String nomeTreino = rs.getString(3);
                String dataTreino = rs.getString(4);
                String horaTreino = rs.getString(5);

                System.out.println("-------------------------------------");
                System.out.println("Informações de todos os clientes: \n");
                System.out.println("Nome do cliente: " + nomeCliente);
                System.out.println("Plano escolhido: " + nomePlano);
                System.out.println("Último treino feito: " + nomeTreino);
                System.out.println("Data do treino: " + dataTreino);
                System.out.println("Hora do treino: " + horaTreino);
                System.out.println("-------------------------------------");
            }
        }
    }
}
