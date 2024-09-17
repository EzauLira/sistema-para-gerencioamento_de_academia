package com.SistemaDeGerenciamentodeAcademia.SGA.dao.impl;

import com.SistemaDeGerenciamentodeAcademia.SGA.config.BancoDadosConfig;
import com.SistemaDeGerenciamentodeAcademia.SGA.dao.ICadastroClienteJdbcDao;
import com.SistemaDeGerenciamentodeAcademia.SGA.dto.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClienteJdbcDaoImpl implements ICadastroClienteJdbcDao {

    /**
     * Este método executa a consulta SQL "SELECT * FROM cadastrar_cliente" para cadastrar um novo cliente no banco de dados.
     * Utiliza o bloco (try-with-resources) para garantir que a conexão com o banco de dados e outros recursos sejam fechados corretamente após o uso.
     * Os dados do cliente são fornecidos pelo parâmetro (clienteDto) e armazenados no banco de dados.
     *
     * @param clienteDto Parametro usando para pegar os dados de cadastro do usuário e armamazenar no banco de dados.
     * @throws SQLException Lança uma SQLException que será tratada na service.
     */
    @Override
    public void cadastrarCliente(ClienteDto clienteDto) throws SQLException {

        String sql = "SELECT * FROM cadastrar_cliente(?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection connection = BancoDadosConfig.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {


            ps.setString(1, clienteDto.getNome());
            ps.setInt(2, clienteDto.getIdade());
            ps.setString(3, clienteDto.getCpf());
            ps.setInt(4, clienteDto.getGenero());
            ps.setString(5, clienteDto.getTelefone());
            ps.setString(6, clienteDto.getEmail());
            ps.setString(7, clienteDto.getSenha());
            ps.setInt(8, clienteDto.getIdPlano());

            ps.execute();
        }
    }

    /**
     * Este método executa a consulta SQL (SELECT * FROM buscar_pessoa_pelo_primeiro_nome) para buscar clientes no banco de dados com base no primeiro nome fornecido.
     * Utiliza o bloco (try-with-resources) para garantir que a conexão com o banco de dados e outros recursos sejam fechados corretamente após o uso.
     * O parâmetro (buscarClienteDto) contém o nome a ser usado na busca. Se clientes correspondentes forem encontrados, os seus nomes são exibidos no console.
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
                String nomeCliente = rs.getString(1);

                System.out.println("-------------------------------------");
                System.out.println("Clientes encontrados: \n");
                System.out.println("Nome do cliente: " + nomeCliente);
                System.out.println("-------------------------------------");
            }
        }
    }


    /**
     * Este método executa a consulta SQL (SELECT * FROM listar_treinos_ativos) para buscar treinos ativos no banco de dados com base na senha fornecida.
     * Utiliza o bloco (try-with-resources) para garantir que a conexão com o banco de dados e outros recursos sejam fechados corretamente após o uso.
     * O parâmetro (senha) contém a senha a ser usada na busca. Se treinos correspondentes forem encontrados, os seus detalhes são adicionados à lista de treinos ativos.
     *
     * @param senha Parâmetro que pega a senha requisitada para buscar no banco de dados.
     * @return Lista de treinos ativos encontrados.
     * @throws SQLException Lança uma SQLException que será tratada na service.
     */
    @Override
    public List<TreinosAtivosEInativosDto> listaTreinosAtivos(String senha) throws SQLException {
        List<TreinosAtivosEInativosDto> treinosAtivos = new ArrayList<>();
        String sql = "SELECT * FROM listar_treinos_ativos(?)";

        try (Connection connection = BancoDadosConfig.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setString(1, senha);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                TreinosAtivosEInativosDto treino = new TreinosAtivosEInativosDto(rs.getInt("agendamento_id")
                        , rs.getString("treino_nome")
                        , rs.getString("data")
                        , rs.getString("hora"));

                treinosAtivos.add(treino);
            }
        }
        return treinosAtivos;
    }


    /**
     * Este método executa a consulta SQL (SELECT * FROM listar_treinos_inativos) para buscar treinos inativos no banco de dados com base na senha fornecida.
     * Utiliza o bloco (try-with-resources) para garantir que a conexão com o banco de dados e outros recursos sejam fechados corretamente após o uso.
     * O parâmetro (senha) contém a senha a ser usada na busca. Se treinos correspondentes forem encontrados, os seus detalhes são adicionados à lista de treinos inativos.
     *
     * @param senha Parâmetro que pega a senha requisitada para buscar no banco de dados.
     * @return Lista de treinos inativos encontrados.
     * @throws SQLException Lança uma SQLException que será tratada na service.
     */
    @Override
    public List<TreinosAtivosEInativosDto> listaTreinosInativos(String senha) throws SQLException {
        List<TreinosAtivosEInativosDto> treinosInativos = new ArrayList<>();

        String sql = "SELECT * FROM listar_treinos_inativos(?)";

        try (Connection connection = BancoDadosConfig.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setString(1, senha);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                TreinosAtivosEInativosDto treino = new TreinosAtivosEInativosDto(rs.getInt("agendamento_id")
                        , rs.getString("treino_nome")
                        , rs.getString("data")
                        , rs.getString("hora"));

                treinosInativos.add(treino);
            }
        }
        return treinosInativos;
    }


    /**
     * Este método executa a consulta SQL (SELECT * FROM genero) para listar todos os gêneros no banco de dados.
     * Utiliza o bloco (try-with-resources) para garantir que a conexão com o banco de dados e outros recursos sejam fechados corretamente após o uso.
     * Se gêneros correspondentes forem encontrados, os seus detalhes são adicionados à lista de gêneros.
     *
     * @return Lista de gêneros encontrados.
     * @throws SQLException Lança uma SQLException que será tratada na service.
     */
    @Override
    public List<GeneroDto> listarGenero() throws SQLException {
        List<GeneroDto> generos = new ArrayList<>();
        String sql = "SELECT * FROM genero";

        try (Connection connection = BancoDadosConfig.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                GeneroDto genero = new GeneroDto(rs.getInt("id"), rs.getString("nome"));

                generos.add(genero);
            }
        }
        return generos;
    }

    /**
     * Este método executa a consulta SQL (SELECT * FROM buscar_dados_pessoais_pelo_primeiro_nome) para buscar dados pessoais de clientes no banco de dados com base no primeiro nome fornecido.
     * Utiliza o bloco (try-with-resources) para garantir que a conexão com o banco de dados e outros recursos sejam fechados corretamente após o uso.
     * O parâmetro (nome) contém o nome a ser usado na busca. Se clientes correspondentes forem encontrados, os seus detalhes são adicionados à lista de clientes.
     *
     * @param nome Parâmetro que pega o nome requisitado para buscar no banco de dados.
     * @return Lista de clientes encontrados.
     * @throws SQLException Lança uma SQLException que será tratada na service.
     */
    @Override
    public List<ClienteDto> buscarDadosPessoaisPeloPrimeiroNome(String nome) throws SQLException {
        List<ClienteDto> cliente = new ArrayList<>();
        String sql = "SELECT * FROM buscar_dados_pessoais_pelo_primeiro_nome(?)";

        try (Connection connection = BancoDadosConfig.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setString(1, nome);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                ClienteDto clienteDto = new ClienteDto(
                        rs.getString(1)
                        , rs.getString(2)
                        , rs.getString(3)
                        , rs.getString(4)
                        , rs.getString(5)
                        , rs.getString(6));

                cliente.add(clienteDto);
            }
        }
        return cliente;
    }
}
