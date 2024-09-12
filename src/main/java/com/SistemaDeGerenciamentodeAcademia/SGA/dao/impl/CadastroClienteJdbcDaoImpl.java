package com.SistemaDeGerenciamentodeAcademia.SGA.dao.impl;

import com.SistemaDeGerenciamentodeAcademia.SGA.config.BancoDadosConfig;
import com.SistemaDeGerenciamentodeAcademia.SGA.dao.ICadastroClienteJdbcDao;
import com.SistemaDeGerenciamentodeAcademia.SGA.dto.BuscarClienteDto;
import com.SistemaDeGerenciamentodeAcademia.SGA.dto.ClienteDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CadastroClienteJdbcDaoImpl implements ICadastroClienteJdbcDao {

    /**
     * Este método executa a consulta SQL "SELECT * FROM cadastrar_cliente" para cadastrar um novo cliente no banco de dados.
     * Utiliza o bloco (try-with-resources) para garantir que a conexão com o banco de dados e outros recursos sejam fechados corretamente após o uso.
     * Os dados do cliente são fornecidos pelo parâmetro (clienteDto) e são armazenados no banco de dados.
     *
     * @param clienteDto Parametro usando para pegar os dados de cadastro do usuário e armamazenar no banco de dados.
     * @throws SQLException Lança uma SQLException que será tratada na service.
     */
    @Override
    public void cadastrarCliente(ClienteDto clienteDto) throws SQLException {

        String sql = "SELECT * FROM cadastrar_cliente(?, ?, ?, ?, ?, ?, ?)";

        try (Connection connection = BancoDadosConfig.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {


            ps.setString(1, clienteDto.getNome());
            ps.setInt(2, clienteDto.getIdade());
            ps.setString(3, clienteDto.getCpf());
            ps.setString(4, clienteDto.getGenero());
            ps.setString(5, clienteDto.getTelefone());
            ps.setString(6, clienteDto.getEmail());
            ps.setInt(7, clienteDto.getIdPlano());
            ps.execute();


        }
    }

    /**
     * Este método executa a consulta SQL (SELECT * FROM buscar_pessoa_pelo_primeiro_nome) para buscar clientes no banco de dados com base no primeiro nome fornecido.
     * Utiliza o bloco (try-with-resources) para garantir que a conexão com o banco de dados e outros recursos sejam fechados corretamente após o uso.
     * O parâmetro (buscarClienteDto) contém o nome a ser usado na busca. Se clientes correspondentes forem encontrados, seus nomes são exibidos no console.
     *
     * @param buscarClienteDto Parâmetro que pega o nome requisitado para buscar no banco de dados.
     * @throws SQLException Lança uma SQLException que será tratada na service.
     */
    @Override
    public void buscarPessoaPeloPrimeiroNome(BuscarClienteDto buscarClienteDto) throws SQLException {

        String sql = "SELECT * FROM buscar_pessoa_pelo_primeiro_nome(?)";

        try (Connection connection = BancoDadosConfig.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setString(1, buscarClienteDto.getNome());

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String nomeCliente = rs.getString("nome");

                System.out.println("-------------------------------------");
                System.out.println("Clientes encontrados: \n");
                System.out.println("Nome do cliente: " + nomeCliente);
                System.out.println("-------------------------------------");
            }
        }
    }
}
