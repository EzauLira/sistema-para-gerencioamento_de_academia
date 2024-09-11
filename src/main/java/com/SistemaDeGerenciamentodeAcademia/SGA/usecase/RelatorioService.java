package com.SistemaDeGerenciamentodeAcademia.SGA.usecase;

import com.SistemaDeGerenciamentodeAcademia.SGA.dao.impl.PegarEstatisticaJdbcDaoImpl;
import com.SistemaDeGerenciamentodeAcademia.SGA.dto.ColetarRelatorioDto;
import com.SistemaDeGerenciamentodeAcademia.SGA.exception.SqlException;
import com.SistemaDeGerenciamentodeAcademia.SGA.utils.validadorRelatoiroUtils.ValidarNomeRelatorioUtils;

import java.sql.SQLException;

/**
 * Serviço responsável pela geração de relatórios na academia.
 * Inclui funcionalidades para gerar relatórios gerais, de todos os clientes e de um cliente específico.
 */
public class RelatorioService {

    private static final PegarEstatisticaJdbcDaoImpl pegarEstatisticaJdbcDaoImpl = new PegarEstatisticaJdbcDaoImpl();

    /**
     * Gera um relatório geral da academia.
     * Se ocorrer uma exceção SQL, ela será tratada e exibida.
     * Trata os erros vindo do banco de dados, mantados pela DAO através do (THROWS SQLEXCEPTION).
     */
    public void gerarRelatorioAcademia() {
        try {
            pegarEstatisticaJdbcDaoImpl.gerarRelatorioAcademia();
        } catch (SQLException e) {
            SqlException.sqlException(e);
        }
    }

    /**
     * Gera um relatório de todos os clientes.
     * Se ocorrer uma exceção SQL, ela será tratada e exibida.
     * Trata os erros vindo do banco de dados, mantados pela DAO através do (THROWS SQLEXCEPTION).
     */
    public void gerarRelatorioDeTodosClientes() {
        try {
            pegarEstatisticaJdbcDaoImpl.gerarRelatorioTodosClientes();
        } catch (SQLException e) {
            SqlException.sqlException(e);
        }
    }

    /**
     * Gera um relatório de um cliente específico baseado no nome fornecido.
     * Se ocorrer uma exceção SQL, ela será tratada e exibida.
     * Trata os erros vindo do banco de dados, mantados pela DAO através do (THROWS SQLEXCEPTION).
     *
     * @param nome Nome do cliente para o qual o relatório será gerado.
     */
    public void gerarRelatorioClienteEspecifico(String nome) {
        ColetarRelatorioDto coletarRelatorioDto = new ColetarRelatorioDto(nome);

        try {
            pegarEstatisticaJdbcDaoImpl.gerarRelatorioClienteEspecifico(coletarRelatorioDto);
        } catch (SQLException e) {
            SqlException.sqlException(e);
        }
    }

    /**
     * Valida o nome fornecido para gerar relatórios.
     * Utiliza uma classe utilitária para garantir que o nome está em um formato adequado.
     *
     * @param nome Nome a ser validado.
     * @return {@code true} se o nome for válido, {@code false} caso contrário.
     */
    public boolean validarNome(String nome) {
        return ValidarNomeRelatorioUtils.validarNome(nome);
    }
}
