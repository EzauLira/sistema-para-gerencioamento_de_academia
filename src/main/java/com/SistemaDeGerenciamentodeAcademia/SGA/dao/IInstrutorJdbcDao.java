package com.SistemaDeGerenciamentodeAcademia.SGA.dao;

import com.SistemaDeGerenciamentodeAcademia.SGA.dto.InstrutorDto;

import java.sql.SQLException;

public interface IInstrutorJdbcDao {

    /**
     * Cadastra novos instrutores no banco de dados.
     * @param instrutorDto Parametro contendo os dados necessários para cadastrar um novo instrutor.
     * @throws SQLException Lança uma SQLException que será tratada na service.
     */
    void cadastrarInstrutor(InstrutorDto instrutorDto) throws SQLException;
}
