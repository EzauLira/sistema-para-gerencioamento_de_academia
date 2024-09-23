package com.SistemaDeGerenciamentodeAcademia.SGA.dao.impl;

import com.SistemaDeGerenciamentodeAcademia.SGA.config.BancoDadosConfig;
import com.SistemaDeGerenciamentodeAcademia.SGA.dao.IAdmJdbcDao;
import com.SistemaDeGerenciamentodeAcademia.SGA.model.Administrador;
import com.SistemaDeGerenciamentodeAcademia.SGA.model.Instrutor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdmJdbcDaoImpl implements IAdmJdbcDao {

    /**
     * Método que executa a consulta SQL "SELECT * FROM login_admin" para efetuar o login do administrador no sistema.
     * Utiliza o bloco (try-with-resources) para garantir que a conexão com o banco de dados e outros recursos sejam fechados corretamente após o uso.
     * Os dados do administrador são fornecidos pelos parâmetros (USUÁRIO e SENHA) e são consultados no banco de dados. Se existir, efetua o login.
     * @param administrador para logar com usuario e senha.
     * @throws SQLException Lança uma SQLException que será tratada na service.
     */
    @Override
    public void LoginAdm(Administrador administrador) throws SQLException {
        String sql = "SELECT * FROM login_admin(?,?)";
        try (Connection connection = BancoDadosConfig.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setString(1, administrador.getUsuario());
            ps.setString(2, administrador.getSenha());

            ps.execute();
        }
    }

    //------------------------------------------------------------------------------------------------------------------------------------------------------------------//

    /**
     * Método que executa a consulta SQL "SELECT * FROM cadastrar_instrutor(?, ?, ?, ?, ?, ?)" para cadastrar um novo instrutor no sistema.
     * Utiliza o bloco (try-with-resources) para garantir que a conexão com o banco de dados e outros recursos sejam fechados corretamente após o uso.
     * Os dados do instrutor são fornecidos pelo objeto InstrutorDto e são inseridos no banco de dados.
     * @param instrutor objeto que contém os dados do instrutor a ser cadastrado.
     * @throws SQLException Lança uma SQLException que será tratada na service.
     */
    @Override
    public void cadastrarNovoInstrutor(Instrutor instrutor) throws SQLException {
        String sql = "SELECT * FROM cadastrar_instrutor(?, ?, ?, ?, ?, ?)";

        try (Connection connection = BancoDadosConfig.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setString(1, instrutor.getNome());
            ps.setString(2, instrutor.getCpf());
            ps.setInt(3, instrutor.getGenero());
            ps.setString(4, instrutor.getTelefone());
            ps.setString(5, instrutor.getEmail());
            ps.setString(6, instrutor.getSenha());

            ps.execute();

        }
    }

    //------------------------------------------------------------------------------------------------------------------------------------------------------------------//

    /**
     * Este método executa a consulta SQL "SELECT * FROM gerar_relatorio_academia" para gerar um relatório geral da academia.
     * Utiliza o bloco (try-with-resources) para garantir que a conexão com o banco de dados e outros recursos sejam fechados corretamente após o uso.
     * O relatório exibe o total de clientes cadastrados e a quantidade de planos vendidos (mensal, anual e trimestral).
     *
     * @throws SQLException Lança uma SQLException que será tratada na service.
     */
    @Override
    public void gerarRelatorioAcademia() throws SQLException {

        String sql = "SELECT * FROM gerar_relatorio_academia()";

        try (Connection connection = BancoDadosConfig.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                int totalClientes = rs.getInt(1);
                String planoMensal = rs.getString(2);
                String planoAnual = rs.getString(3);
                String panoTrimestral = rs.getString(4);

                System.out.println("╔═════════════════════════════════╗");
                System.out.println("║ Informações gerias da academia: ║");
                System.out.println("║                                 ║");
                System.out.println("║ Total de cadastros: " + totalClientes + "           ║");
                System.out.println("║ Plano mensal vendidos: " + planoMensal + "        ║");
                System.out.println("║ Plano Anual vendidos: " + planoAnual + "         ║");
                System.out.println("║ Plano Trimestral vendidos: " + panoTrimestral + "    ║");
                System.out.println("╚═════════════════════════════════╝");
            }
        }
    }

    //------------------------------------------------------------------------------------------------------------------------------------------------------------------//
}
