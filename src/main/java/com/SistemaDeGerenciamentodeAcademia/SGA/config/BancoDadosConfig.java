package com.SistemaDeGerenciamentodeAcademia.SGA.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BancoDadosConfig {

    private BancoDadosConfig(){}

    /**
     * Construtor privado para impedir criação de instâncias.
     */
    public static Connection getConnection() {
        try {
             return DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "admin");
        } catch (SQLException e) {
           throw new RuntimeException("Erro ao conectar com o banco de dados");
        }
    }

}
