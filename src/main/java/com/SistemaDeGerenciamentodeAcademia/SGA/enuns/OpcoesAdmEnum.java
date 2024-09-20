package com.SistemaDeGerenciamentodeAcademia.SGA.enuns;

public enum OpcoesAdmEnum {

    OPCOES_ADM("""
              ╔═══════════════════════════════════════════════════════════════════╗
              ║                         Olá, administrador!                       ║
              ║ Insira seu usuário e Senha para efetuar login. digite 0 para sair ║
              ╚═══════════════════════════════════════════════════════════════════╝"""),
    MENU_INFORMATIVO_ADM("""
              ╔══════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╗
              ║                                                                 Olá, Chefe!                                                                      ║
              ║ ATENÇÃO: Siga as instruções para cada opção escolhida, a fim de evitar possíveis erros. Caso queira voltar ao menu, digite 0 a qualquer momento. ║
              ╚══════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╝"""),

    MSG_TENTAR_NOVAMENTE("""
            ╔════════════════════════════════════╗
            ║ [1] - Para tentar logar novamente. ║
            ║ [0] - Para voltar.                 ║
            ╚════════════════════════════════════╝
            Digite uma opção:"""),

    OPCOES_MENU_ADM("""
              ╔══════════════════════════════════════════════╗
              ║ [1] - Listar relatório da academia           ║
              ║ [2] - cadastrar um novo instrutor            ║
              ║ [0] - Sair                                   ║
              ╚══════════════════════════════════════════════╝
              Digite uma opção:""");
    private final String mensagem;

    OpcoesAdmEnum(String mensagem){
        this.mensagem = mensagem;
    }

    public String getMensagem(){
        return mensagem;
    }
}
