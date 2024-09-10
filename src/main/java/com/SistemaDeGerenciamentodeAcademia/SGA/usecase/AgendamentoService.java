package com.SistemaDeGerenciamentodeAcademia.SGA.usecase;

import com.SistemaDeGerenciamentodeAcademia.SGA.dao.impl.AgendamentoJdbcDaoImpl;
import com.SistemaDeGerenciamentodeAcademia.SGA.dto.AgendamentoDto;
import com.SistemaDeGerenciamentodeAcademia.SGA.enuns.MensagemSucesso;
import com.SistemaDeGerenciamentodeAcademia.SGA.exception.SqlException;
import com.SistemaDeGerenciamentodeAcademia.SGA.mdoel.Treino;
import com.SistemaDeGerenciamentodeAcademia.SGA.utils.validadorAgendamento.ValidarNomeAgendamentoUtils;

import java.sql.SQLException;
import java.util.List;

public class AgendamentoService {

    private static final AgendamentoJdbcDaoImpl agendamentoJdbcDao = new AgendamentoJdbcDaoImpl();

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

    public boolean validarNome(String nome) {
        return ValidarNomeAgendamentoUtils.validarNome(nome);
    }

}
