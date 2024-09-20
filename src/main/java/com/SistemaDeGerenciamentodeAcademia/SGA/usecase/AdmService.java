package com.SistemaDeGerenciamentodeAcademia.SGA.usecase;

import com.SistemaDeGerenciamentodeAcademia.SGA.dao.impl.AdmJdbcDaoImpl;
import com.SistemaDeGerenciamentodeAcademia.SGA.dto.InstrutorDto;
import com.SistemaDeGerenciamentodeAcademia.SGA.enuns.MensagemSucessoEnum;
import com.SistemaDeGerenciamentodeAcademia.SGA.exception.SqlException;
import com.SistemaDeGerenciamentodeAcademia.SGA.utils.validadores.ValidarCpfUtils;
import com.SistemaDeGerenciamentodeAcademia.SGA.utils.validadores.ValidarEmailUtils;
import com.SistemaDeGerenciamentodeAcademia.SGA.utils.validadores.ValidarNomeUtils;
import com.SistemaDeGerenciamentodeAcademia.SGA.utils.validadores.ValidarTelefoneUtils;

import java.sql.SQLException;

public class AdmService {

    private static final AdmJdbcDaoImpl admJadbcDaoImpl = new AdmJdbcDaoImpl();

    public boolean loginAdm(String usuario, String senha){
        try {
            admJadbcDaoImpl.LoginAdm(usuario, senha);
            return true;
        }catch (SQLException e){
          SqlException.sqlException(e);
        }
        return false;
    }

    public void cadastrarNovoInstrutor(String nome, String cpf, int genero, String telefone, String email, String senha){
        boolean sucesso = true;

        InstrutorDto instrutorDto = new InstrutorDto(nome, cpf, genero, telefone, email, senha);

        ValidarNomeUtils.validarNome(nome);
        ValidarCpfUtils.validarCpf(cpf);
        ValidarTelefoneUtils.validarTelefone(telefone);
        ValidarEmailUtils.validarEmail(email);

        try {
            admJadbcDaoImpl.cadastrarNovoInstrutor(instrutorDto);
        }catch (SQLException e){
            sucesso = false;
            SqlException.sqlException(e);
        }finally {
            if (sucesso)
                System.out.println(MensagemSucessoEnum.CADASTRO_EFETUADO.getMensagem());
        }
    }

    /**
     * Gera um relatório geral da academia.
     * Se ocorrer uma exceção SQL, ela será tratada e exibida.
     * Trata os erros vindo do banco de dados, mantados pela DAO através do (THROWS SQLEXCEPTION).
     */
    public void gerarRelatorioAcademia() {
        try {
            admJadbcDaoImpl.gerarRelatorioAcademia();
        } catch (SQLException e) {
            SqlException.sqlException(e);
        }
    }
}
