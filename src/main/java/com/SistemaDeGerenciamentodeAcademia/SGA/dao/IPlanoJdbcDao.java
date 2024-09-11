package com.SistemaDeGerenciamentodeAcademia.SGA.dao;

import com.SistemaDeGerenciamentodeAcademia.SGA.dto.PlanosDto;

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
     * @return Uma lista de objetos {@link PlanosDto}, cada um representando um plano disponível na academia.
     * @throws SQLException Lança uma SQLException que será tratada na service.
     */
    List<PlanosDto> listarPlanos() throws SQLException;
}
