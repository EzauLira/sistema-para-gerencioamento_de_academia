CREATE OR REPLACE FUNCTION listar_generos()
RETURNS TABLE (id INT, nome VARCHAR)
AS $$
BEGIN
	RETURN QUERY
	SELECT g.id, g.nome FROM genero g;
	end;
$$ LANGUAGE plpgsql;


CREATE OR REPLACE FUNCTION listar_treinos()
RETURNS TABLE (id INT, nome VARCHAR, descricao TEXT)
AS $$
BEGIN
	RETURN QUERY
	SELECT t.id, t.nome, t.descricao FROM treino t;
	END
$$ LANGUAGE plpgsql;

CREATE OR REPLACE FUNCTION listar_planos()
RETURNS TABLE (id INT, nome VARCHAR, descricao TEXT,duracao INT, preco NUMERIC)
AS $$
BEGIN
	RETURN QUERY
	SELECT P.id, p.nome, p.descricao, p.duracao, p.preco FROM plano p;
	END
$$ LANGUAGE plpgsql;
