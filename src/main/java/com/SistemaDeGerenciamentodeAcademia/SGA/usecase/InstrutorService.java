package com.SistemaDeGerenciamentodeAcademia.SGA.usecase;

import com.SistemaDeGerenciamentodeAcademia.SGA.dao.impl.InstrutorJdbcDaoImpl;
import com.SistemaDeGerenciamentodeAcademia.SGA.model.Agendamento;
import com.SistemaDeGerenciamentodeAcademia.SGA.exception.SqlException;

import java.sql.SQLException;
import java.util.Collections;
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
            return instrutorJdbcDaoImpl.listarAgendamentosDeHoje();
        }catch (SQLException e){
            SqlException.sqlException(e);
        }
        return Collections.emptyList();
    }

    public List<Agendamento> listarTreinosDeUmClienteEspecifico(String nome){
        try {
            return instrutorJdbcDaoImpl.listarTreinosDeUmClienteEspecifico(nome);

        }catch (SQLException e){
            SqlException.sqlException(e);
        }
        return Collections.emptyList();
    }

    public List<Agendamento> buscarHistoricoDeUmClienteEspecifico(String nome){
        try {
            return instrutorJdbcDaoImpl.buscarHistoricoDeUmClienteEspecifico(nome);

        }catch (SQLException e){
            SqlException.sqlException(e);
        }
        return Collections.emptyList();
    }
}
