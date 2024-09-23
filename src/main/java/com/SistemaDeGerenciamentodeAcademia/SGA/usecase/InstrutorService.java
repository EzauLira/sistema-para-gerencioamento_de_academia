package com.SistemaDeGerenciamentodeAcademia.SGA.usecase;

import com.SistemaDeGerenciamentodeAcademia.SGA.dao.impl.InstrutorJdbcDaoImpl;
import com.SistemaDeGerenciamentodeAcademia.SGA.model.Agendamento;
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

    public List<Agendamento> listarAgendamentosDeHoje(){
        try {
            List<Agendamento> agendamentoHoje = instrutorJdbcDaoImpl.listarAgendamentosDeHoje();
            return agendamentoHoje;
        }catch (SQLException e){
            SqlException.sqlException(e);
        }
        return null;
    }

    public List<Agendamento> listarTreinosDeUmClienteEspecifico(String nome){
        try {
            List<Agendamento> listarTreinos = instrutorJdbcDaoImpl.listarTreinosDeUmClienteEspecifico(nome);
            return listarTreinos;
        }catch (SQLException e){
            SqlException.sqlException(e);
        }
        return null;
    }

    public List<Agendamento> buscarHistoricoDeUmClienteEspecifico(String nome){
        try {
            List<Agendamento> listarHistoricoTreinos = instrutorJdbcDaoImpl.buscarHistoricoDeUmClienteEspecifico(nome);
            return listarHistoricoTreinos;
        }catch (SQLException e){
            SqlException.sqlException(e);
        }
        return null;
    }
}
