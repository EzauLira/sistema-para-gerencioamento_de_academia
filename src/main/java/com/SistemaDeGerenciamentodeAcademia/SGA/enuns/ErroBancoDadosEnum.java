package com.SistemaDeGerenciamentodeAcademia.SGA.enuns;

/**
 * Enumeração para representar os diferentes tipos de erros que podem ocorrer
 * ao interagir com o banco de dados. Cada tipo de erro tem uma mensagem padrão
 * e uma mensagem customizada associada a ele.
 */
public enum ErroBancoDadosEnum {

    MESMO_TREINO("O mesmo treino já está agendado", "O mesmo treino já está agendado para este cliente nesta data."),
    JA_EXISTE_TREINO("Já existe um treino agendado", "Já existe um treino agendado para este cliente nesta data e hora. Deve haver pelo menos 30 minutos de diferença entre os treinos."),
    CLIENTE_NAO_ENCONTRADO("Cliente não encontrado", "Cliente não encontrado. Por favor cadastre o clien1te ou reveja o nome digitado."),
    NOME_JA_CADASTRADO("Erro: Nome já cadastrado.", "Nome já está cadastrado."),
    CPF_JA_CADASTRADO("Erro: CPF já cadastrado.", "CPF já está cadastrado."),
    TELEFONE_JA_CADASTRADO("Erro: Telefone já cadastrado.", "Telefone já está cadastrado."),
    EMAIL_JA_CADASTRADO("Erro: Email já cadastrado.", "Email já está cadastrado."),
    SENHA_SEM_CARACTERE_ESPECIAL("A senha deve conter pelo menos um caractere especial (@ ou .)", "A senha deve conter pelo menos um caractere especial (@ ou .)"),
    SENHA_SEM_LETRA_MAIUSCULA("A senha deve conter pelo menos uma letra maiúscula", "A senha deve conter pelo menos uma letra maiúscula"),
    SENHA_SEM_CINCO_CARACTERES("A senha deve ter pelo menos 5 caracteres", "A senha deve ter pelo menos 5 caracteres"),
    SENHA_SEM_NUMERO("A senha deve conter pelo menos um número", "A senha deve conter pelo menos um número"),
    OPCAO_INVALIDA_TREINO("inserção ou atualização em tabela", "Opção inválida de treino ou gênero. Por favor escolha um das três opções de existentes."),
    NOME_NAO_ENCONTRADO("Nome não encontrado", "Cliente não encontrado. Verifique se o nome está correto ou talvez essa pessoa não esteja cadastrada."),
    CPF_NAO_ENCONTRADO("CPF não cadastrado", "CPF não encontrado ou não cadastrado."),
    SENHA_INCORRETA("Senha incorreta", "Senha inválida."),
    NENHUM_TRIENO_ATIVO_ENCONTRADO("Nenhum treino ativo encontrado para o cliente.", "Nenhum treino ativo encontrado ou a senha está incorreta."),
    NENHUM_TRIENO_INATIVO_ENCONTRADO("Nenhum treino inativo encontrado para o cliente.", "Nenhum treino inativo encontrado ou a senha está incorreta."),
    ERRO_NOVO_AGENDAMENTO("Agendamento não encontrado ou não pertence ao cliente.", "Agendamento não encontrado ou a senha está incorreta."),
    ERRO_DELETAR_AGENDAMENTO("Nenhum treino ativo encontrado para o agendamento fornecido.", "Nenhum treino ativo encontrado ou a senha está incorreta."),
    OUTRO_ERRO("Outro erro", "Erro não catalogado. Favor, entre em contato com nosso suporte técnico.");

    private final String mensagem;
    private final String mensagemCustom;

    /**
     * Construtor para criar uma nova instância {@link ErroBancoDadosEnum}.
     *
     * @param mensagem A mensagem padrão associada ao erro.
     * @param mensagemCustom A mensagem customizada associada ao erro.
     */
    ErroBancoDadosEnum(String mensagem, String mensagemCustom) {
        this.mensagem = mensagem;
        this.mensagemCustom = mensagemCustom;
    }

    /**
     * Retorna o tipo de erro correspondente com base na mensagem fornecida.
     * Se a mensagem não corresponder a nenhum erro catalogado, retorna {@link #OUTRO_ERRO}.
     *
     * @param message A mensagem de erro recebida.
     * @return O tipo de erro correspondente.
     */
    public static ErroBancoDadosEnum mensagemDoBanco(String message) {
        for (ErroBancoDadosEnum mensagem : ErroBancoDadosEnum.values()) {
            if (message.contains(mensagem.mensagem)) {
                return mensagem;
            }
        }
        return OUTRO_ERRO;
    }

    /**
     * Obtém a mensagem customizada associada ao erro.
     *
     * @return A mensagem customizada do erro.
     */
    public String getMensagemCustom() {
        return mensagemCustom;
    }
}