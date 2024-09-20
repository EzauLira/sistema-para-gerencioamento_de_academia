package com.SistemaDeGerenciamentodeAcademia.SGA.dao.impl;

import com.SistemaDeGerenciamentodeAcademia.SGA.config.BancoDadosConfig;
import com.SistemaDeGerenciamentodeAcademia.SGA.dao.IAdmJdbcDao;
import com.SistemaDeGerenciamentodeAcademia.SGA.dto.InstrutorDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdmJdbcDaoImpl implements IAdmJdbcDao {

    @Override
    public void LoginAdm(String usuario, String senha) throws SQLException {
        String sql = "SELECT * FROM login_ad" +
                "min(?,?)";
        try (Connection connection = BancoDadosConfig.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setString(1, usuario);
            ps.setString(2, senha);

            ps.execute();
        }
    }

    @Override
    public void cadastrarNovoInstrutor(InstrutorDto instrutorDto) throws SQLException {
        String sql = "SELECT * FROM cadastrar_instrutor(?, ?, ?, ?, ?, ?)";

        try (Connection connection = BancoDadosConfig.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setString(1, instrutorDto.getNome());
            ps.setString(2, instrutorDto.getCpf());
            ps.setInt(3, instrutorDto.getGenero());
            ps.setString(4, instrutorDto.getTelefone());
            ps.setString(5, instrutorDto.getEmail());
            ps.setString(6, instrutorDto.getSenha());

            ps.execute();

        }
    }

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
}
