package com.SistemaDeGerenciamentodeAcademia.SGA.dao;

import com.SistemaDeGerenciamentodeAcademia.SGA.dto.AgendamentoDto;
import com.SistemaDeGerenciamentodeAcademia.SGA.mdoel.Treino;

import java.sql.SQLException;
import java.util.List;

/**
 * Interface para operações relacionadas ao agendamento de treinos na academia.
 * Define os métodos para listar treinos e agendar um novo treino.
 */
public interface IAgendamentoJdbcDao {

    /**
     * Lista todos os treinos disponíveis no banco de dados.
     *
     * @return Uma lista de objetos {@link Treino}, cada um representando um treino disponível.
     * @throws SQLException Lança uma SQLException que será tratada na service..
     */
    List<Treino> listarTreinos() throws SQLException;

    /**
     * Agenda um novo treino na academia com base nos dados fornecidos.
     *
     * @param agendamento Um objeto {@link AgendamentoDto} contendo os dados necessários para agendar o treino, como nome, tipo de treino, data e hora.
     * @throws SQLException Lança uma SQLException que será tratada na service.
     */
    void agendarTreino(AgendamentoDto agendamento) throws SQLException;
}
