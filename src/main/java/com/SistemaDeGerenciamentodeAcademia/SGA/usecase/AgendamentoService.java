package com.SistemaDeGerenciamentodeAcademia.SGA.usecase;

import com.SistemaDeGerenciamentodeAcademia.SGA.dao.impl.AgendamentoJdbcDaoImpl;
import com.SistemaDeGerenciamentodeAcademia.SGA.dto.AgendamentoDto;
import com.SistemaDeGerenciamentodeAcademia.SGA.mdoel.Treino;
import com.SistemaDeGerenciamentodeAcademia.SGA.utils.validadorAgendamento.ValidarNomeAgendamentoUtils;

import java.util.List;

public class AgendamentoService {

    private static final AgendamentoJdbcDaoImpl agendamentoJdbcDao = new AgendamentoJdbcDaoImpl();

    public void listarTreinos() {

        List<Treino> treinos = agendamentoJdbcDao.listarTreinos();

        for (Treino t : treinos) {
            System.out.println(t.getId() + " - " + t.getNome() + " - " + t.getDescricao());
        }
    }
    public void criarAgendamento(String nome, int treino, String data, String hora ) {

        AgendamentoDto agendamentoDto = new AgendamentoDto(nome, treino, data, hora);

        agendamentoJdbcDao.agendarTreino(agendamentoDto);

    }
    public boolean validarNome(String nome) {
        return ValidarNomeAgendamentoUtils.validarNome(nome);
    }


}
