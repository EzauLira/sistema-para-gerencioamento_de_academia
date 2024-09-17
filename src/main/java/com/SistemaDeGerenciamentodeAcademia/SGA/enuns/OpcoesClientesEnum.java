package com.SistemaDeGerenciamentodeAcademia.SGA.enuns;

public enum OpcoesClientesEnum {

    OPCOES_ENUM("""
            ╔══════════════════════════════╗
            ║ Você é cliente ou instrutor? ║
            ║ [1] - CLIENTE                ║
            ║ [2] - INSTRUTOR              ║
            ╚══════════════════════════════╝
            Digite uma opção:"""),
    OPCOES_CLIENTE("""
              ╔════════════════════════════════════════════╗
              ║ Você deseja Fazer login ou se cadastrar?   ║
              ║ [1] - LOGIN                                ║
              ║ [2] - CADASTRAR                            ║
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
              ╚═══════════════════════════════════════════════════════════════════════════════════════════════════╝"""),
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
