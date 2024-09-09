package com.SistemaDeGerenciamentodeAcademia.SGA.usecase;


import com.SistemaDeGerenciamentodeAcademia.SGA.dao.impl.CadastroClienteJdbcDaoImpl;
import com.SistemaDeGerenciamentodeAcademia.SGA.dao.impl.PlanoJdbcDaoImpl;
import com.SistemaDeGerenciamentodeAcademia.SGA.dto.BuscarClienteDto;
import com.SistemaDeGerenciamentodeAcademia.SGA.dto.ClienteDto;
import com.SistemaDeGerenciamentodeAcademia.SGA.dto.PlanosDto;
import com.SistemaDeGerenciamentodeAcademia.SGA.utils.validadorCliente.*;

import java.sql.SQLException;
import java.util.List;

public class ClienteService {
    private static final CadastroClienteJdbcDaoImpl cadastroClienteJdbcDaoImpl = new CadastroClienteJdbcDaoImpl();
    private static final PlanoJdbcDaoImpl planoJdbcDaoImpl = new PlanoJdbcDaoImpl();

    public void listarplanos() {

        List<PlanosDto> planos = planoJdbcDaoImpl.listarPlanos();

        for (PlanosDto p : planos) {
            System.out.println(p.getId() + " - " + p.getNome() + " - " + p.getDescricao() + " - " + p.getDuracao() + " - " + p.getPreco());
        }
    }

    public void cadastrarCliente(String nome, int idade, String cpf, String genero, String telefone, String email, int plano) {

        ValidarNomeUtils.validarNome(nome);
        ValidarIDadeUtils.validarIdade(idade);
        ValidarCpfUtils.validarCpf(cpf);
        ValidarGeneroUtils.validarGenero(genero);
        ValidarTelefoneUtils.validarTelefone(telefone);
        ValidarEmailUtils.validarEmail(email);

       ClienteDto clienteDto = new ClienteDto(nome, idade, cpf, genero, telefone, email, plano);

        cadastroClienteJdbcDaoImpl.cadastrarCliente(clienteDto);
    }

    public void buscarClientePeloPrimeiroNome(String nome){

        BuscarClienteDto buscarClienteDto = new BuscarClienteDto(nome);

        cadastroClienteJdbcDaoImpl.buscarPessoaPeloPrimeiroNome(buscarClienteDto);
    }
}
