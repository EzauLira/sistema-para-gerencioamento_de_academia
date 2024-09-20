package com.SistemaDeGerenciamentodeAcademia.SGA.enuns;

public enum OpcoesClientesEnum {

    MSG_TENTAR_NOVAMENTE("""
            ╔════════════════════════════════════╗
            ║ [1] - Para tentar logar novamente. ║
            ║ [2] - Para cadastrar-se.           ║
            ║ [0] - Voltar                       ║
            ╚════════════════════════════════════╝
            Digite uma opção:"""),
    OPCOES_CLIENTE_LOGIN_OU_CADASTRO("""
              ╔════════════════════════════════════════════╗
              ║ Você deseja Fazer login ou se cadastrar?   ║
              ║ [1] - LOGIN                                ║
              ║ [2] - CADASTRAR                            ║
              ║ [0] - VOLTAR                               ║
              ╚════════════════════════════════════════════╝
              Digite uma opção:"""),
    MENU_LOGIN_CLIENTE("""
              ╔════════════════════════════════════════════════════════════════════════════════════════════╗
              ║                                     LOGIN CLIENTE                                          ║
              ║ ATENÇÃO: Siga as instruções de ligIn. Caso queira voltar, digite 0 a qualquer momento.     ║
              ╚════════════════════════════════════════════════════════════════════════════════════════════╝
              """),
    MENU_INFORMATIVO_CLIENTE("""
              ╔══════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╗
              ║                                                      Bem-Vindo(a)! O que deseja fazer?                                                           ║
              ║ ATENÇÃO: Siga as instruções para cada opção escolhida, a fim de evitar possíveis erros. Caso queira voltar ao menu, digite 0 a qualquer momento. ║
              ╚══════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╝"""),
    MENU_BUSCAR_CLIENTE_INFORMATIVO("""
              ╔═════════════════════════════════════════════════════════════════════════════════════════════════════════════╗
              ║                                       BUSCAR DADOS PESSOAIS PELO NOME                                       ║
              ║ ATENÇÃO: Siga as instruções para buscar o cliente. Caso queira voltar ao menu, digite 0 a qualquer momento. ║
              ╚═════════════════════════════════════════════════════════════════════════════════════════════════════════════╝"""),
    MENU_DO_CADASTRO_INFORMATIVO("""
              ╔═══════════════════════════════════════════════════════════════════════════════════════════════════╗
              ║                                          CADASTRAR CLIENTE                                        ║
              ║ ATENÇÃO: Siga as instruções do cadastro. Caso queira voltar ao menu, digite 0 a qualquer momento. ║
              ╚═══════════════════════════════════════════════════════════════════════════════════════════════════╝
              """),
    MENU_AGENDAR_TREINO_INFORMATIVO("""
              ╔═══════════════════════════════════════════════════════════════════════════════════════════════════════╗
              ║                                         AGENDAR NOVO TREINO                                           ║
              ║ ATENÇÃO: Siga as instruções para está opção. Caso queira voltar ao menu, digite 0 a qualquer momento. ║
              ╚═══════════════════════════════════════════════════════════════════════════════════════════════════════╝
              """),
    OP_ESCOLHIDA_AGENDADMENTO("""
              ╔═════════════════════════════════════════════════════════╗
              ║ Opção escolhida: AGENDAMENTO. Vamos agendar seu treino. ║
              ╚═════════════════════════════════════════════════════════╝"""),
    OP_ESCOLHIDA_LISTA_ATIVA("""
              ╔═════════════════════════════════════════════════════════════════════════╗
              ║ Opção escolhida: LISTAR AGENDA ATIVA. Vamos listar seus treinos ativos. ║
              ╚═════════════════════════════════════════════════════════════════════════╝
              """),
    OP_ESCOLHIDA_LISTA_INATIVA("""
              ╔═════════════════════════════════════════════════════════════════════════════╗
              ║ Opção escolhida: LISTAR AGENDA INATIVA. Vamos listar seus treinos inativos. ║
              ╚═════════════════════════════════════════════════════════════════════════════╝
              """),
    OP_ESCOLHIDA_TREINO_ATIVO("""
              ╔═══════════════════════════════════════════════════════════════════════════════╗
              ║ Opção escolhida: ATUALIZAR TREINO ATIVO. Vamos atualizar seus treinos ativos. ║
              ╚═══════════════════════════════════════════════════════════════════════════════╝"""),
    OP_ESCOLHIDA_CANCELAR_TREINO("""
              ╔══════════════════════════════════════════════════════════════╗
              ║ Opção escolhida: CANCELAR TREINO. Vamos cancelar seu treino. ║
              ╚══════════════════════════════════════════════════════════════╝"""),
    OPCOES_MENU_CLIENTE("""
              
              ╔════════════════════════════════════════════╗
              ║ [1] - Agendar um treino                    ║
              ║ [2] - Listar agenda ativa                  ║
              ║ [3] - Listar agenda inativa                ║
              ║ [4] - Atualizar treino ativo               ║
              ║ [5] - Cancelar treino                      ║
              ║ [6] - Buscar dados                         ║
              ║ [0] - Sair                                 ║
              ╚════════════════════════════════════════════╝
              Digite uma opção:""");

    private final String mensagem;

    OpcoesClientesEnum(String mensagem){
        this.mensagem = mensagem;
    }

    public String getMensagem(){
        return mensagem;
    }
}
