USE reserva;

INSERT INTO modalidade(nome) VALUES ('Caminhada');
INSERT INTO modalidade(nome) VALUES ('Escalada');
INSERT INTO modalidade(nome) VALUES ('Mergulho');
INSERT INTO modalidade(nome) VALUES ('Salto de para-quedas');

INSERT INTO tipo_passeio (nome_passeio, descricao_passeio) VALUES
('Privativo', 'Passeio somente para pessoa ou casal');
INSERT INTO tipo_passeio (nome_passeio, descricao_passeio) VALUES
('Em Grupo', 'Passeio para grupos abertos');
INSERT INTO tipo_passeio (nome_passeio, descricao_passeio) VALUES
('Seletivo', 'Passeio para grupos fechados');

INSERT INTO guia (nome_guia, documento_guia, data_nascimento, credencial)
VALUES ('Romeu', '123456', '1980-01-01', '456789');

INSERT INTO guia (nome_guia, documento_guia, data_nascimento, credencial)
VALUES ('Julieta', '654321', '1990-01-01', '987654');

INSERT INTO guia (nome_guia, documento_guia, data_nascimento, credencial)
VALUES ('Hannibal Lecter', '142536', '1985-01-01', '362514');

INSERT INTO modalidade(nome) VALUES ('Corrida');
INSERT INTO modalidade(nome) VALUES ('Museu');
INSERT INTO modalidade(nome) VALUES ('Caminhada Histórica');

-- Modalidades ROMEU
INSERT INTO guia_modalidade (id_guia, id_modalidade)
VALUES(
(SELECT id_guia FROM guia WHERE nome_guia = 'Romeu'), 
(SELECT id_modalidade FROM modalidade WHERE nome = 'Caminhada'));

INSERT INTO guia_modalidade (id_guia, id_modalidade)
VALUES(
(SELECT id_guia FROM guia WHERE nome_guia = 'Romeu'), 
(SELECT id_modalidade FROM modalidade WHERE nome = 'Escalada'));

INSERT INTO guia_modalidade (id_guia, id_modalidade)
VALUES(
(SELECT id_guia FROM guia WHERE nome_guia = 'Romeu'), 
(SELECT id_modalidade FROM modalidade WHERE nome = 'Mergulho'));

-- Modalidades Julieta
INSERT INTO guia_modalidade (id_guia, id_modalidade)
VALUES(
(SELECT id_guia FROM guia WHERE nome_guia = 'Julieta'), 
(SELECT id_modalidade FROM modalidade WHERE nome = 'Corrida'));

INSERT INTO guia_modalidade (id_guia, id_modalidade)
VALUES(
(SELECT id_guia FROM guia WHERE nome_guia = 'Julieta'), 
(SELECT id_modalidade FROM modalidade WHERE nome = 'Escalada'));

-- Modalidades Hannibal
INSERT INTO guia_modalidade (id_guia, id_modalidade)
VALUES(
(SELECT id_guia FROM guia WHERE nome_guia = 'Hannibal Lecter'), 
(SELECT id_modalidade FROM modalidade WHERE nome = 'Museu'));

INSERT INTO guia_modalidade (id_guia, id_modalidade)
VALUES(
(SELECT id_guia FROM guia WHERE nome_guia = 'Hannibal Lecter'), 
(SELECT id_modalidade FROM modalidade WHERE nome = 'Caminhada Histórica'));

-- Modalidades ROMEU
INSERT INTO guia_tipo_passeio (id_guia, id_tipo_passeio)
VALUES
((SELECT id_guia FROM guia WHERE nome_guia = 'Romeu'),
(SELECT id_tipo_passeio FROM tipo_passeio WHERE nome_passeio = 'Privativo'));

INSERT INTO guia_tipo_passeio (id_guia, id_tipo_passeio)
VALUES
((SELECT id_guia FROM guia WHERE nome_guia = 'Romeu'),
(SELECT id_tipo_passeio FROM tipo_passeio WHERE nome_passeio = 'Em Grupo'));

-- Modalidades JULIETA
INSERT INTO guia_tipo_passeio (id_guia, id_tipo_passeio)
VALUES
((SELECT id_guia FROM guia WHERE nome_guia = 'Julieta'),
(SELECT id_tipo_passeio FROM tipo_passeio WHERE nome_passeio = 'Seletivo'));

INSERT INTO guia_tipo_passeio (id_guia, id_tipo_passeio)
VALUES
((SELECT id_guia FROM guia WHERE nome_guia = 'Julieta'),
(SELECT id_tipo_passeio FROM tipo_passeio WHERE nome_passeio = 'Em Grupo'));

-- Modalidades Hannibal
INSERT INTO guia_tipo_passeio (id_guia, id_tipo_passeio)
VALUES
((SELECT id_guia FROM guia WHERE nome_guia = 'Hannibal Lecter'),
(SELECT id_tipo_passeio FROM tipo_passeio WHERE nome_passeio = 'Seletivo'));

INSERT INTO guia_tipo_passeio (id_guia, id_tipo_passeio)
VALUES
((SELECT id_guia FROM guia WHERE nome_guia = 'Hannibal Lecter'),
(SELECT id_tipo_passeio FROM tipo_passeio WHERE nome_passeio = 'Em Grupo'));

INSERT INTO guia_tipo_passeio (id_guia, id_tipo_passeio)
VALUES
((SELECT id_guia FROM guia WHERE nome_guia = 'Hannibal Lecter'),
(SELECT id_tipo_passeio FROM tipo_passeio WHERE nome_passeio = 'Privativo'));

-- VIAJANTE
INSERT INTO viajante (nome_viajante, documento_viajante, data_nascimento)
VALUES ('Jonathan', '123678', '1988-01-08');

INSERT INTO viajante (nome_viajante, documento_viajante, data_nascimento)
VALUES ('Jose', '369147', '1982-05-15');

-- PAIS
INSERT INTO pais (nome_pais) VALUES ('Brasil');

-- ESTADO
INSERT INTO estado (nome_estado, id_pais) VALUES
('Rio Grande do Sul', 
(SELECT id_pais FROM pais WHERE nome_pais = 'Brasil'));

-- CIDADE 
INSERT INTO cidade (nome_cidade, id_estado)
VALUES ('Porto Alegre', 
(SELECT id_estado FROM estado WHERE nome_estado = 'Rio Grande do Sul'));

SELECT id_viajante FROM viajante WHERE nome_viajante = 'Jonathan';

SELECT distinct g.id_guia FROM guia g
INNER JOIN guia_modalidade gm ON g.id_guia = gm.id_guia
INNER JOIN modalidade mo ON gm.id_modalidade = mo.id_modalidade
WHERE mo.nome in ('Caminhada', 'Mergulho');

SELECT distinct g.id_guia FROM guia g, 
guia_modalidade gm , modalidade mo 
WHERE g.id_guia = gm.id_guia
AND gm.id_modalidade = mo.id_modalidade
AND mo.nome in ('Caminhada', 'Mergulho');

