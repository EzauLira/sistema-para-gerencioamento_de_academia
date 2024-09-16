package com.SistemaDeGerenciamentodeAcademia.SGA.usecase;

import com.SistemaDeGerenciamentodeAcademia.SGA.dao.impl.InstrutorJdbcDaoImpl;
import com.SistemaDeGerenciamentodeAcademia.SGA.dto.InstrutorDto;
import com.SistemaDeGerenciamentodeAcademia.SGA.enuns.MensagemSucessoEnum;
import com.SistemaDeGerenciamentodeAcademia.SGA.exception.SqlException;

import java.sql.SQLException;

public class InstrutorService {

    private static final InstrutorJdbcDaoImpl instrutorJdbcDaoImpl = new InstrutorJdbcDaoImpl();

    public void cadastrarInstrutor(String nome, String cpf, int genero, String telefone, String email, String senha ){
        boolean sucesso = true;

        InstrutorDto instrutorDto = new InstrutorDto(nome, cpf, genero, telefone, email, senha);

        try {
         instrutorJdbcDaoImpl.cadastrarInstrutor(instrutorDto);
        }catch (SQLException e){
            SqlException.sqlException(e);
            sucesso = false;
        }finally {
            if (sucesso)
                System.out.println(MensagemSucessoEnum.CADASTRO_EFETUADO.getMensagem());
        }
    }
}
