package com.SistemaDeGerenciamentodeAcademia.SGA.dao;

import com.SistemaDeGerenciamentodeAcademia.SGA.dto.InstrutorDto;

import java.sql.SQLException;

public interface IAdmJdbcDao {

    void LoginAdm(String usuario, String senha)throws SQLException;

    void cadastrarNovoInstrutor(InstrutorDto instrutorDto) throws SQLException;

    void gerarRelatorioAcademia() throws SQLException;
}
