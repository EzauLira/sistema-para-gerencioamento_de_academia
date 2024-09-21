package com.SistemaDeGerenciamentodeAcademia.SGA.dao;

import com.SistemaDeGerenciamentodeAcademia.SGA.dto.AdministradorDto;
import com.SistemaDeGerenciamentodeAcademia.SGA.dto.InstrutorDto;

import java.sql.SQLException;

public interface IAdmJdbcDao {

    //--------------------------------------------------------------------------------------------------------------------------------------//

    /**
     * Interface para o método que executa a consulta SQL "SELECT * FROM login_admin" para efetuar o login do administrador no sistema.
     * @param administradorDto para logar com usuario e senha.
     * @throws SQLException Lança uma SQLException que será tratada na service.
     */
    void LoginAdm(AdministradorDto administradorDto)throws SQLException;

    //--------------------------------------------------------------------------------------------------------------------------------------//

    /**
     * Interface para o método que executa a consulta SQL "SELECT * FROM cadastrar_instrutor" para cadastrar um novo instrutor no sistema.
     * @param instrutorDto objeto que contém os dados do instrutor a ser cadastrado.
     * @throws SQLException Lança uma SQLException que será tratada na service.
     */
    void cadastrarNovoInstrutor(InstrutorDto instrutorDto) throws SQLException;

    //--------------------------------------------------------------------------------------------------------------------------------------//

    /**
     * Interface para o método que executa a consulta SQL "SELECT * FROM gerar_relatorio_academia" para gerar um relatório da academia.
     * @throws SQLException Lança uma SQLException que será tratada na service.
     */
    void gerarRelatorioAcademia() throws SQLException;

    //--------------------------------------------------------------------------------------------------------------------------------------//
}
