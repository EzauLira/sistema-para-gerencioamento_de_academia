package com.SistemaDeGerenciamentodeAcademia.SGA.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BancoDadosConfig {

    private BancoDadosConfig(){}

    /**
     * Método que conecta e abre uma única conexão com o banco de dados.
     */
    public static Connection getConnection() {
        try {
             return DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres?ApplicationName=SGA", "postgres", "admin");
        } catch (SQLException e) {
           throw new RuntimeException("Erro ao conectar com o banco de dados");
        }
    }
}
