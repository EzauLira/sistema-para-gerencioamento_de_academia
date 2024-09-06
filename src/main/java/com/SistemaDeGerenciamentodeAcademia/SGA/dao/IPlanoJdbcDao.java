package com.SistemaDeGerenciamentodeAcademia.SGA.dao;

import com.SistemaDeGerenciamentodeAcademia.SGA.dto.PlanosDto;

import java.sql.SQLException;
import java.util.List;

public interface IPlanoJdbcDao {

    List<PlanosDto> listarPlanos() throws SQLException;
}
