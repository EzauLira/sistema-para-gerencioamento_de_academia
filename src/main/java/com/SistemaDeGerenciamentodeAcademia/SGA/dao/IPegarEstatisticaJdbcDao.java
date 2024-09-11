package com.SistemaDeGerenciamentodeAcademia.SGA.dao;

import com.SistemaDeGerenciamentodeAcademia.SGA.dto.ColetarRelatorioDto;

import java.sql.SQLException;

/**
 * Interface para operações relacionadas à geração de relatórios na academia.
 * Define os métodos para gerar relatórios diversos, incluindo relatórios específicos e gerais.
 */
public interface IPegarEstatisticaJdbcDao {

    /**
     * Gera um relatório geral da academia.
     *
     * @throws SQLException Lança uma SQLException que será tratada na service.
     */
    void gerarRelatorioAcademia() throws SQLException;

    /**
     * Gera um relatório para um cliente específico com base no nome fornecido.
     *
     * @param nome Um objeto {@link ColetarRelatorioDto} contendo o nome do cliente para o qual o relatório deve ser gerado.
     * @throws SQLException Lança uma SQLException que será tratada na service.
     */
    void gerarRelatorioClienteEspecifico(ColetarRelatorioDto nome) throws SQLException;

    /**
     * Gera um relatório contendo informações sobre todos os clientes.
     *
     * @throws SQLException Lança uma SQLException que será tratada na service.
     */
    void gerarRelatorioTodosClientes() throws SQLException;
}
