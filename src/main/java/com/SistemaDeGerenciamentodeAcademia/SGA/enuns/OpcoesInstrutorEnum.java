package com.SistemaDeGerenciamentodeAcademia.SGA.enuns;

public enum OpcoesInstrutorEnum {

    OPCOES_INSTRUTOR("""
              ╔═══════════════════════════════════════════════════════════════╗
              ║                          Olá instrutor!                       ║
              ║ Insira seu CPF e Senha para efetuar login, digite 0 para sair ║
              ╚═══════════════════════════════════════════════════════════════╝"""),
    MENU_PRINCIPAL_INFORMATIVO_INSTRUTOR("""
              ╔══════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╗
              ║                                                  Bem-Vindo(a), instrutor! O que deseja fazer?                                                    ║
              ║ ATENÇÃO: Siga as instruções para cada opção escolhida, a fim de evitar possíveis erros. Caso queira voltar ao menu, digite 0 a qualquer momento. ║
              ╚══════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╝"""),
    MSG_TENTAR_NOVAMENTE("""
            ╔════════════════════════════════════╗
            ║ [1] - Para tentar logar novamente. ║
            ║ [0] - Para sair.                   ║
            ╚════════════════════════════════════╝
            Digite uma opção:"""),
    MENU_BUSCAR_TREINO_INFORMATIVO("""
              ╔═══════════════════════════════════════════════════════════════════════════════════════════════════════╗
              ║                                 LISTAR TREINOS DE UM CLIENTE ESPECÍFICO                               ║
              ║ ATENÇÃO: Siga as instruções para está opção. Caso queira voltar ao menu, digite 0 a qualquer momento. ║
              ╚═══════════════════════════════════════════════════════════════════════════════════════════════════════╝
              """),

    OP_ESCOLHIDA_AGENDADMENTO_DO_DIA("""
              ╔══════════════════════════════════════════════════════════════════════════╗
              ║ Opção escolhida: AGENDAMENTOS DO DIA. Vamos listar os treinos para hoje. ║
              ╚══════════════════════════════════════════════════════════════════════════╝
              """),
    OP_ESCOLHIDA_LISTAR_TREINOS_ATIVOS("""
              ╔═══════════════════════════════════════════════════════════════════════════════════════════════╗
              ║ Opção escolhida: BUSCAR TREINOS DE UM CLIENTE ESPECÍFICO. Vamos listar os treinos do cliente. ║
              ╚═══════════════════════════════════════════════════════════════════════════════════════════════╝"""),
    OP_ESCOLHIDA_BUSCAR_HISTORICO("""
              ╔══════════════════════════════════════════════════════════════════════════════════════════════════╗
              ║ Opção escolhida: BUSCAR HISTÓRICO DE UM CLIENTE ESPECÍFICO. Vamos buscar o histórico do cliente. ║
              ╚══════════════════════════════════════════════════════════════════════════════════════════════════╝"""),
    MENU_BUSCAR_HISTORICO_TREINO_INFORMATIVO("""
              ╔═══════════════════════════════════════════════════════════════════════════════════════════════════════╗
              ║                                BUSCAR HISTÓRICO DE UM CLIENTE ESPECÍFICO                              ║
              ║ ATENÇÃO: Siga as instruções para está opção. Caso queira voltar ao menu, digite 0 a qualquer momento. ║
              ╚═══════════════════════════════════════════════════════════════════════════════════════════════════════╝
              """),

    MENU_BUSCAR_CLIENTE_INFORMATIVO("""
              ╔═══════════════════════════════════════════════════════════════════════════════════════════════════════╗
              ║                                    BUSCAR DADOS PESSOAIS PELO NOME                                    ║
              ║ ATENÇÃO: Siga as instruções para está opção. Caso queira voltar ao menu, digite 0 a qualquer momento. ║
              ╚═══════════════════════════════════════════════════════════════════════════════════════════════════════╝"""),
    OP_ESCOLHIDA_BUSCAR_DADOS_PESSOAIS("""
              ╔═════════════════════════════════════════════════════════════════════════════════════════╗
              ║ Opção escolhida: BUSCAR DADOS PESSOAIS DE UM CLIENT . Vamos buscar os dados do cliente. ║
              ╚═════════════════════════════════════════════════════════════════════════════════════════╝"""),
    OPCOES_MENU_INSTRUTOR("""
              
              ╔══════════════════════════════════════════════╗
              ║ [1] - Listar agendamentos do dia             ║
              ║ [2] - Listar treino de um cliente específico ║
              ║ [3] - Histórico de um cliente específico     ║
              ║ [4] - Buscar dados de um cliente             ║
              ║ [0] - Sair                                   ║
              ╚══════════════════════════════════════════════╝
              Digite uma opção:""");


    private final String mensagem;

    OpcoesInstrutorEnum(String mensagem){
        this.mensagem = mensagem;
    }

    public String getMensagem(){
        return mensagem;
    }
}
