CREATE OR REPLACE FUNCTION login_cliente(p_cpf VARCHAR, p_senha VARCHAR)
RETURNS TEXT AS $$
DECLARE
    v_senha_db VARCHAR;
BEGIN
    -- Verifica se o CPF existe
    SELECT senha INTO v_senha_db
    FROM cliente
    WHERE cpf = p_cpf;

    IF NOT FOUND THEN
        RAISE EXCEPTION 'CPF não cadastrado';
    END IF;

    -- Verifica se a senha está correta
    IF v_senha_db != p_senha THEN
        RAISE EXCEPTION 'Senha incorreta';
    END IF;

    RETURN 'Login realizado com sucesso';
END;
$$ LANGUAGE plpgsql;
