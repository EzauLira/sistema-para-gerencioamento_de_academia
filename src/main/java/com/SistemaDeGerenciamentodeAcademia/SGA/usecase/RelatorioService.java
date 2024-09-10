package com.SistemaDeGerenciamentodeAcademia.SGA.usecase;

import com.SistemaDeGerenciamentodeAcademia.SGA.dao.impl.PegarEstatisticaJdbcDaoImpl;
import com.SistemaDeGerenciamentodeAcademia.SGA.dto.ColetarRelatorioDto;
import com.SistemaDeGerenciamentodeAcademia.SGA.exception.SqlException;
import com.SistemaDeGerenciamentodeAcademia.SGA.utils.validadorRelatoiroUtils.ValidarNomeRelatorioUtils;

import java.sql.SQLException;

public class RelatorioService {
    private static final PegarEstatisticaJdbcDaoImpl pegarEstatisticaJdbcDaoImpl = new PegarEstatisticaJdbcDaoImpl();

    public void gerarRelatorioAcademia() {

        try {
            pegarEstatisticaJdbcDaoImpl.gerarRelatorioAcademia();
        } catch (SQLException e) {
            SqlException.sqlException(e);
        }

    }

    public void gerarRelatorioDeTodosClientes() {

        try {
            pegarEstatisticaJdbcDaoImpl.gerarRelatorioTodosClientes();

        } catch (SQLException e) {
            SqlException.sqlException(e);
        }
    }

    public void gerarRelatorioClienteEspecifico(String nome) {

        ColetarRelatorioDto coletarRelatorioDto = new ColetarRelatorioDto(nome);

        try {
            pegarEstatisticaJdbcDaoImpl.gerarRelatorioClienteEspecifico(coletarRelatorioDto);
        } catch (SQLException e) {
            SqlException.sqlException(e);
        }
    }

    public boolean validarNome(String nome) {
        return ValidarNomeRelatorioUtils.validarNome(nome);
    }
}
