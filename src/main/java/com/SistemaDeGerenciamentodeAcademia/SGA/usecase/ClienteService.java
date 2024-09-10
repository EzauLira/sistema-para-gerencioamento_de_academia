package com.SistemaDeGerenciamentodeAcademia.SGA.usecase;

import com.SistemaDeGerenciamentodeAcademia.SGA.dao.impl.CadastroClienteJdbcDaoImpl;
import com.SistemaDeGerenciamentodeAcademia.SGA.dao.impl.PlanoJdbcDaoImpl;
import com.SistemaDeGerenciamentodeAcademia.SGA.dto.BuscarClienteDto;
import com.SistemaDeGerenciamentodeAcademia.SGA.dto.ClienteDto;
import com.SistemaDeGerenciamentodeAcademia.SGA.dto.PlanosDto;
import com.SistemaDeGerenciamentodeAcademia.SGA.enuns.MensagemSucesso;
import com.SistemaDeGerenciamentodeAcademia.SGA.exception.SqlException;
import com.SistemaDeGerenciamentodeAcademia.SGA.utils.validadorCliente.*;

import java.sql.SQLException;
import java.util.List;

public class ClienteService {
    private boolean sucesso;
    private static final CadastroClienteJdbcDaoImpl cadastroClienteJdbcDaoImpl = new CadastroClienteJdbcDaoImpl();
    private static final PlanoJdbcDaoImpl planoJdbcDaoImpl = new PlanoJdbcDaoImpl();

    public void listarplanos() {
        try {
            List<PlanosDto> planos = planoJdbcDaoImpl.listarPlanos();

            for (PlanosDto p : planos) {
                System.out.println(p.getId() + " - " + p.getNome() + " - " + p.getDescricao() + " - " + p.getDuracao() + " - " + p.getPreco());
            }
        } catch (SQLException e) {
            SqlException.sqlException(e);
        }

    }

    public void cadastrarCliente(String nome, int idade, String cpf, String genero, String telefone, String email, int plano) {
        sucesso = true;
        ValidarNomeUtils.validarNome(nome);
        ValidarIDadeUtils.validarIdade(idade);
        ValidarCpfUtils.validarCpf(cpf);
        ValidarGeneroUtils.validarGenero(genero);
        ValidarTelefoneUtils.validarTelefone(telefone);
        ValidarEmailUtils.validarEmail(email);

        ClienteDto clienteDto = new ClienteDto(nome, idade, cpf, genero, telefone, email, plano);

        try {
            cadastroClienteJdbcDaoImpl.cadastrarCliente(clienteDto);
        } catch (SQLException e) {
            SqlException.sqlException(e);
            sucesso = false;
        } finally {
            if (sucesso) {
                System.out.println(MensagemSucesso.CADASTRO_EFETUADO.getMensagem());
            }
        }
    }

    public void buscarClientePeloPrimeiroNome(String nome) {
        sucesso = true;
        BuscarClienteDto buscarClienteDto = new BuscarClienteDto(nome);

        try {
            cadastroClienteJdbcDaoImpl.buscarPessoaPeloPrimeiroNome(buscarClienteDto);
        } catch (SQLException e) {
            SqlException.sqlException(e);
            sucesso = false;
        } finally {
            if (sucesso) {
                System.out.println(MensagemSucesso.AGENDAMENTO_EFETUADO.getMensagem());
            }
        }
    }
}
