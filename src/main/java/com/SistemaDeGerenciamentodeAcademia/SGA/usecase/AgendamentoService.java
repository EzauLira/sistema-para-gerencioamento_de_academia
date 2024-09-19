package com.SistemaDeGerenciamentodeAcademia.SGA.usecase;

import com.SistemaDeGerenciamentodeAcademia.SGA.dao.impl.AgendamentoJdbcDaoImpl;
import com.SistemaDeGerenciamentodeAcademia.SGA.dto.AgendamentoDto;
import com.SistemaDeGerenciamentodeAcademia.SGA.enuns.MensagemSucessoEnum;
import com.SistemaDeGerenciamentodeAcademia.SGA.exception.SqlException;
import com.SistemaDeGerenciamentodeAcademia.SGA.mdoel.Treino;
import com.SistemaDeGerenciamentodeAcademia.SGA.utils.validadorAgendamento.ValidarDataAgendamentoUtils;
import com.SistemaDeGerenciamentodeAcademia.SGA.utils.validadorAgendamento.ValidarHoraUtils;
import com.SistemaDeGerenciamentodeAcademia.SGA.utils.validadorAgendamento.ValidarNomeAgendamentoUtils;

import java.sql.SQLException;
import java.util.List;

/**
 * Serviço responsável pelo gerenciamento de agendamentos de treinos.
 * Inclui funcionalidades para listar treinos, criar agendamentos e validar entradas.
 */
public class AgendamentoService {

    private static final AgendamentoJdbcDaoImpl agendamentoJdbcDao = new AgendamentoJdbcDaoImpl();

    /**
     * Lista todos os treinos disponíveis e imprime as suas informações.
     * Exibe o ID, nome e descrição de cada treino.
     * Trata os erros vindo do banco de dados, mantados pela DAO através do (THROWS SQLEXCEPTION).
     */
    public List<Treino> listarTreinos() {
        try {
            List<Treino> treinos = agendamentoJdbcDao.listarTreinos();

            return treinos;

        } catch (SQLException e) {
            SqlException.sqlException(e);
        }
        return null;
    }

    /**
     * Cria um agendamento de treino com base nos parâmetros fornecidos.
     * Se o agendamento for criado com sucesso, uma mensagem de sucesso é exibida.
     * Trata os erros vindo do banco de dados, mantados pela DAO através do (THROWS SQLEXCEPTION).
     *
     * @param id ID do cliente que está a agendar o treino.
     * @param treino ID do treino a ser agendado.
     * @param data Data do agendamento.
     * @param hora Hora do agendamento.
     */
    public void agendarTreino(int id, int treino, String data, String hora) {
        boolean sucesso = true;

        try {
            agendamentoJdbcDao.agendarTreino(id, treino, data, hora);
        } catch (SQLException e) {
          SqlException.sqlException(e);
            sucesso = false;
        } finally {
            if (sucesso) {
                System.out.println(MensagemSucessoEnum.AGENDAMENTO_EFETUADO.getMensagem());
            }
        }
    }

    /**
     * Este método cria um objeto AgendamentoDto com os dados fornecidos e tenta atualizar o agendamento no banco de dados.
     * Utiliza um bloco try-catch-finally para garantir que exceções SQL sejam tratadas e uma mensagem de sucesso seja exibida se a operação for bem-sucedida.
     * O parâmetro (treino) contém o ID do treino atual, (novoTreino) contém o ID do novo treino, (data) contém a data do agendamento e (hora) contém a hora do agendamento.
     *
     * @param treino ID do treino atual.
     * @param novoTreino ID do novo treino.
     * @param data Data do agendamento.
     * @param hora Hora do agendamento.
     */
    public void atualizarTreino(int treino, int novoTreino, String data, String hora){
        boolean sucesso = true;
        AgendamentoDto agendamentoDto = new AgendamentoDto(treino, novoTreino, data, hora);

        try {
            agendamentoJdbcDao.atualizarAgendamento(agendamentoDto);
        }catch (SQLException e){
            SqlException.sqlException(e);
            sucesso = false;
        }finally {
            if (sucesso)
                System.out.println(MensagemSucessoEnum.AGENDAMENTO_ATIALIZADO.getMensagem());
        }
    }

    /**
     * Este método tenta cancelar um treino ativo no banco de dados com base no ID do treino fornecido.
     * Utiliza um bloco try-catch-finally para garantir que exceções SQL sejam tratadas e uma mensagem de sucesso seja exibida se a operação for bem-sucedida.
     * O parâmetro (treino) contém o ID do treino a ser cancelado.
     *
     * @param treino ID do treino a ser cancelado.
     */
    public void cancelarTreinoAtivo(int treino){
        boolean sucesso = true;
        try {
            agendamentoJdbcDao.calcelarTreino(treino);
        }catch (SQLException e){
            SqlException.sqlException(e);
            sucesso = false;
        }finally {
            if (sucesso)
                System.out.println(MensagemSucessoEnum.AGENDAMENTO_CANCELADO.getMensagem());
        }
    }

    /**
     * Valida a data fornecida para o agendamento.
     *
     * @param data Data a ser validada.
     * @return true se a data for válida, false caso contrário.
     */
    public boolean validarData(String data) {
        return ValidarDataAgendamentoUtils.validarDataAgendamento(data);
    }

    public boolean validarHora(String hora){
        return ValidarHoraUtils.validarHora(hora);
    }
}
