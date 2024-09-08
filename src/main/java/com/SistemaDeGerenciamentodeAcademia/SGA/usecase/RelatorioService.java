package com.SistemaDeGerenciamentodeAcademia.SGA.usecase;

import com.SistemaDeGerenciamentodeAcademia.SGA.dao.impl.PegarEstatisticaJdbcDaoImpl;
import com.SistemaDeGerenciamentodeAcademia.SGA.dto.ColetarRelatorioDto;
import com.SistemaDeGerenciamentodeAcademia.SGA.utils.validadorRelatoiroUtils.ValidarNomeRelatorioUtils;

public class RelatorioService {

    private static final PegarEstatisticaJdbcDaoImpl pegarEstatisticaJdbcDaoImpl = new PegarEstatisticaJdbcDaoImpl();
    public void gerarRelatorioAcademia() {

        pegarEstatisticaJdbcDaoImpl.gerarRelatorioAcademia();
    }
    public void gerarRelatorioDeTodosClientes() {

        pegarEstatisticaJdbcDaoImpl.gerarRelatorioTodosClientes();
    }
    public void gerarRelatorioClienteEspecifico(String nome) {

        ColetarRelatorioDto coletarRelatorioDto = new ColetarRelatorioDto(nome);

        pegarEstatisticaJdbcDaoImpl.gerarRelatorioClienteEspecifico(coletarRelatorioDto);
    }
    public boolean validarNome(String nome) {
        return ValidarNomeRelatorioUtils.validarNome(nome);
    }
}
