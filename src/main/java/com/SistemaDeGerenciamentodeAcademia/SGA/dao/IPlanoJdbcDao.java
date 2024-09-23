package com.SistemaDeGerenciamentodeAcademia.SGA.dao;

import com.SistemaDeGerenciamentodeAcademia.SGA.model.Planos;

import java.sql.SQLException;
import java.util.List;

/**
 * Interface para operações relacionadas aos planos na academia.
 * Define o método para listar todos os planos disponíveis.
 */
public interface IPlanoJdbcDao {

    /**
     * Lista todos os planos disponíveis no banco de dados.
     *
     * @return Uma lista de objetos {@link Planos}, cada um representando um plano disponível na academia.
     * @throws SQLException Lança uma SQLException que será tratada na service.
     */
    List<Planos> listarPlanos() throws SQLException;
}
