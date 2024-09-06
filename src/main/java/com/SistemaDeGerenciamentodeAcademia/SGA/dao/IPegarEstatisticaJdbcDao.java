package com.SistemaDeGerenciamentodeAcademia.SGA.dao;

import com.SistemaDeGerenciamentodeAcademia.SGA.dto.ColetarRelatorioDto;

import java.sql.SQLException;

public interface IPegarEstatisticaJdbcDao {

    void gerarRelatorioAcademia() throws SQLException;

    void gerarRelatorioClienteEspecifico(ColetarRelatorioDto nome) throws SQLException;
    void gerarRelatorioTodosClientes() throws SQLException;
}
