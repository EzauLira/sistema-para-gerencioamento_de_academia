package com.SistemaDeGerenciamentodeAcademia.SGA.usecase;

import com.SistemaDeGerenciamentodeAcademia.SGA.dao.impl.AgendamentoJdbcDaoImpl;
import com.SistemaDeGerenciamentodeAcademia.SGA.dto.AgendamentoDto;
import com.SistemaDeGerenciamentodeAcademia.SGA.enuns.MensagemSucesso;
import com.SistemaDeGerenciamentodeAcademia.SGA.exception.SqlException;
import com.SistemaDeGerenciamentodeAcademia.SGA.mdoel.Treino;
import com.SistemaDeGerenciamentodeAcademia.SGA.utils.validadorAgendamento.ValidarDataAgendamentoUtils;
import com.SistemaDeGerenciamentodeAcademia.SGA.utils.validadorAgendamento.ValidarNomeAgendamentoUtils;

import java.sql.SQLException;
import java.util.List;

/**
 * Serviço responsável pelo gerenciamento de agendamentos de treinos.
 * Inclui funcionalidades para listar treinos, criar agendamentos e validar entradas.
 */
public class AgendamentoService {

    private static final AgendamentoJdbcDaoImpl agendamentoJdbcDao = new AgendamentoJdbcDaoImpl();

    /**
     * Lista todos os treinos disponíveis e imprime suas informações.
     * Exibe o ID, nome e descrição de cada treino.
     * Trata os erros vindo do banco de dados, mantados pela DAO através do (THROWS SQLEXCEPTION).
     */
    public void listarTreinos() {
        try {
            List<Treino> treinos = agendamentoJdbcDao.listarTreinos();

            for (Treino t : treinos) {
                System.out.println(t.getId() + " - " + t.getNome() + " - " + t.getDescricao());
            }
        } catch (SQLException e) {
            SqlException.sqlException(e);
        }
    }

    /**
     * Cria um agendamento de treino com base nos parâmetros fornecidos.
     * Se o agendamento for criado com sucesso, uma mensagem de sucesso é exibida.
     * Trata os erros vindo do banco de dados, mantados pela DAO através do (THROWS SQLEXCEPTION).
     *
     * @param nome Nome do cliente que está agendando o treino.
     * @param treino ID do treino a ser agendado.
     * @param data Data do agendamento.
     * @param hora Hora do agendamento.
     */
    public void criarAgendamento(String nome, int treino, String data, String hora) {
        boolean sucesso = true;

        AgendamentoDto agendamentoDto = new AgendamentoDto(nome, treino, data, hora);

        try {
            agendamentoJdbcDao.agendarTreino(agendamentoDto);
        } catch (SQLException e) {
            SqlException.sqlException(e);
            sucesso = false;
        } finally {
            if (sucesso) {
                System.out.println(MensagemSucesso.AGENDAMENTO_EFETUADO.getMensagem());
            }
        }
    }

    /**
     * Valida o nome fornecido para o agendamento.
     *
     * @param nome Nome a ser validado.
     * @return true se o nome for válido, false caso contrário.
     */
    public boolean validarNome(String nome) {
        return ValidarNomeAgendamentoUtils.validarNome(nome);
    }

    /**
     * Valida a data fornecida para o agendamento.
     *
     * @param data Data a ser validada.
     * @return true se a data for válida, false caso contrário.
     */
    public boolean validarData(String data) {
        return ValidarDataAgendamentoUtils.validarDataAgendamento(data);
    }
}
