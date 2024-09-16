package com.SistemaDeGerenciamentodeAcademia.SGA.controller;

import com.SistemaDeGerenciamentodeAcademia.SGA.usecase.ClienteService;
import com.SistemaDeGerenciamentodeAcademia.SGA.usecase.LoginClienteService;
import com.SistemaDeGerenciamentodeAcademia.SGA.usecase.RelatorioService;

import java.util.Scanner;

public class InstrutorController {

    /**
     * Atributos e objetos estáticos que estão a ser usados em mais de um método.
     */
    private static final Scanner input = new Scanner(System.in);
    private static byte opcao;
    private static final ClienteService clienteService = new ClienteService();
    private static final RelatorioService relatorioService = new RelatorioService();
    private static final LoginClienteService loginClienteService = new LoginClienteService();
    private static final ClienteController clienteController = new ClienteController();

    public void loginInstrutor() {

        while (true) {

            System.out.println(">> Digite seu CPF: ");
            String cpf = input.nextLine();
            if (cpf.equals("0")) {
                break;
            }

            System.out.println(">> Digite sua SENHA: ");
            String senha = input.nextLine();
            if (senha.equals("0")) {
                break;
            }
        }
    }
}
