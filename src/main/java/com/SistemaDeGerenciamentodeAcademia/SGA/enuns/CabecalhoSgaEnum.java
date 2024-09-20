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
                """),
    OPCAO_PRINCIPAL("""
            ╔═════════════════════════════════════════════╗
            ║ Você é cliente, instrutor ou administrador? ║
            ║ [1] - CLIENTE                               ║
            ║ [2] - INSTRUTOR                             ║
            ║ [3] - ADMINISTRADOR                         ║
            ╚═════════════════════════════════════════════╝
            Digite uma opção:""");


    private final String mensagem;

    CabecalhoSgaEnum(String mensagem){
        this.mensagem = mensagem;
    }

    public String getMensagem(){
        return mensagem;
    }
}
