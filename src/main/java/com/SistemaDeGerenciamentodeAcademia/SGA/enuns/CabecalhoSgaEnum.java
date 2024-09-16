package com.SistemaDeGerenciamentodeAcademia.SGA.enuns;

public enum CabecalhoSgaEnum {

    CABECALHO("""
                ╔════════════════════════════╗
                ║   Sistema:                 ║
                ║                            ║
                ║   ####     ####      ##    ║
                ║  ##  ##   ##  ##    ####   ║
                ║  ##       ##       ##  ##  ║
                ║   ####    ## ###   ######  ║
                ║      ##   ##  ##   ##  ##  ║
                ║  ##  ##   ##  ##   ##  ##  ║
                ║   ####     ####    ##  ##  ║
                ║                            ║
                ║   Versão: 1.0.0            ║
                ╚════════════════════════════╝
                """);


    private final String mensagem;

    CabecalhoSgaEnum(String mensagem){
        this.mensagem = mensagem;
    }

    public String getMensagem(){
        return mensagem;
    }
}
