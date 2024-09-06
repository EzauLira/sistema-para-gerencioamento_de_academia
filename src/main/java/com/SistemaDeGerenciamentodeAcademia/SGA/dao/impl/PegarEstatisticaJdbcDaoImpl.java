package com.SistemaDeGerenciamentodeAcademia.SGA.dao.impl;

import com.SistemaDeGerenciamentodeAcademia.SGA.config.BancoDadosConfig;
import com.SistemaDeGerenciamentodeAcademia.SGA.dao.IPegarEstatisticaJdbcDao;
import com.SistemaDeGerenciamentodeAcademia.SGA.dto.ColetarRelatorioDto;
import com.SistemaDeGerenciamentodeAcademia.SGA.exception.SqlException;

import java.sql.*;

public class PegarEstatisticaJdbcDaoImpl implements IPegarEstatisticaJdbcDao {
    @Override
    public void gerarRelatorioAcademia() {

        try (Connection connection = BancoDadosConfig.getConnection()) {

            String sql = "SELECT * FROM gerar_relatorio_academia()";

            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

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

        } catch (SQLException e) {
            SqlException.sqlException(e);
        }

    }

    @Override
    public void gerarRelatorioClienteEspecifico(ColetarRelatorioDto nome) {

        try (Connection connection = BancoDadosConfig.getConnection()) {

            String sql = "SELECT * FROM gerar_relatorio_cliente_especifico(?)";

            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setString(1, nome.getNome());
            ps.execute();

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
        } catch (SQLException e) {
            SqlException.sqlException(e);
        }

    }

    @Override
    public void gerarRelatorioTodosClientes() {

        try (Connection connection = BancoDadosConfig.getConnection()) {
            String sql = "SELECT * FROM gerar_relatorio_cliente()";

            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

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
        } catch (SQLException e) {
            SqlException.sqlException(e);
        }
    }
}
