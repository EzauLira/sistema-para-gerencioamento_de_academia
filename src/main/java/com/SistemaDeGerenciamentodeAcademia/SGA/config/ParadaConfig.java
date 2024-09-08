package com.SistemaDeGerenciamentodeAcademia.SGA.config;

public class ParadaConfig {
    
    public void paradaSting(String parametro){
        while (parametro.equals("0"))
            break;
    }

    public void paradaInt(int parametro){
        while (parametro == 0)
            break;
    }
}
