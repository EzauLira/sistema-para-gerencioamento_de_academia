package com.SistemaDeGerenciamentodeAcademia.SGA.dao;

import com.SistemaDeGerenciamentodeAcademia.SGA.dto.AgendamentoDto;
import com.SistemaDeGerenciamentodeAcademia.SGA.mdoel.Treino;


import java.sql.SQLException;
import java.util.List;

public interface IAgendamentoJdbcDao {

    List<Treino> listarTreinos() throws SQLException;

    void agendarTreino(AgendamentoDto agendamento) throws SQLException;
}
