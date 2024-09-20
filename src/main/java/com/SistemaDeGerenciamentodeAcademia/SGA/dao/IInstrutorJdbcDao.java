package com.SistemaDeGerenciamentodeAcademia.SGA.dao;

import com.SistemaDeGerenciamentodeAcademia.SGA.dto.AgendamentoDto;

import java.sql.SQLException;
import java.util.List;

public interface IInstrutorJdbcDao {

    void LoginInstrutor(String cpf, String senha) throws SQLException;

    List<AgendamentoDto> listarAgendamentosDeHoje() throws SQLException;

    List<AgendamentoDto> listarTreinosDeUmClienteEspecifico(String nome) throws SQLException;

    List<AgendamentoDto> buscarHistoricoDeUmClienteEspecifico(String nome) throws SQLException;
}
