package com.SistemaDeGerenciamentodeAcademia.SGA.dao;

import com.SistemaDeGerenciamentodeAcademia.SGA.dto.InstrutorDto;
import com.SistemaDeGerenciamentodeAcademia.SGA.mdoel.Treino;

import java.sql.SQLException;

public interface IInstrutorJdbcDao {

    /**
     * Cadastra novos instrutores no banco de dados.
     *
     * @return Um objetos {@link InstrutorDto}, cada um representando um instrutor.
     * @throws SQLException Lança uma SQLException que será tratada na service..
     */
    void cadastrarInstrutor(InstrutorDto instrutorDto) throws SQLException;
}
