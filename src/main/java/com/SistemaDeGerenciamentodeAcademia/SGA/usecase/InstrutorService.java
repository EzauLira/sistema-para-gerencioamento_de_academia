package com.SistemaDeGerenciamentodeAcademia.SGA.usecase;

import com.SistemaDeGerenciamentodeAcademia.SGA.dao.impl.InstrutorJdbcDaoImpl;
import com.SistemaDeGerenciamentodeAcademia.SGA.dto.AgendamentoDto;
import com.SistemaDeGerenciamentodeAcademia.SGA.exception.SqlException;

import java.sql.SQLException;
import java.util.List;

public class InstrutorService {
    private static final InstrutorJdbcDaoImpl instrutorJdbcDaoImpl = new InstrutorJdbcDaoImpl();

    public boolean loginInstrutor(String cpf, String senha){
        try {
            instrutorJdbcDaoImpl.LoginInstrutor(cpf, senha);
            return true;
        }catch (SQLException e){
            SqlException.sqlException(e);
        }
        return false;
    }

    public List<AgendamentoDto> listarAgendamentosDeHoje(){
        try {
            List<AgendamentoDto> agendamentoHoje = instrutorJdbcDaoImpl.listarAgendamentosDeHoje();
            return agendamentoHoje;
        }catch (SQLException e){
            SqlException.sqlException(e);
        }
        return null;
    }

    public List<AgendamentoDto> listarTreinosDeUmClienteEspecifico(String nome){
        try {
            List<AgendamentoDto> listarTreinos = instrutorJdbcDaoImpl.listarTreinosDeUmClienteEspecifico(nome);
            return listarTreinos;
        }catch (SQLException e){
            SqlException.sqlException(e);
        }
        return null;
    }

    public List<AgendamentoDto> buscarHistoricoDeUmClienteEspecifico(String nome){
        try {
            List<AgendamentoDto> listarHistoricoTreinos = instrutorJdbcDaoImpl.buscarHistoricoDeUmClienteEspecifico(nome);
            return listarHistoricoTreinos;
        }catch (SQLException e){
            SqlException.sqlException(e);
        }
        return null;
    }
}
