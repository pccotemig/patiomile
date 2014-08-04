-- Cria o banco de dados patiomile
CREATE DATABASE patiomile;

-- Usa o banco de dados patiomile
USE patiomile;

-- Cria a tabela grupousuario
CREATE TABLE grupousuario(
	grupousuarioID	INTEGER NOT NULL AUTO_INCREMENT,
	nomeUsuario		VARCHAR(50),
	PRIMARY KEY(grupousuarioID)
);

-- Insere registros na tabela grupousuario
INSERT INTO grupousuario (nomeUsuario) VALUES ('Administrador');
INSERT INTO grupousuario (nomeUsuario) VALUES ('Gerente');
INSERT INTO grupousuario (nomeUsuario) VALUES ('Atentente');

-- Cria a tabela usuario
CREATE TABLE usuario(
	usuarioID		INTEGER NOT NULL AUTO_INCREMENT,
	nomeusuario		VARCHAR(50) NOT NULL,
	emailusuario 	VARCHAR(50) NULL,
	loginusuario	VARCHAR(20) NOT NULL,
	senhausuario	VARCHAR(20) NOT NULL,
	usuarioativo	INTEGER NULL,
	PRIMARY KEY(usuarioID)
);

-- Insere registros na tabela usuario
INSERT INTO usuario (nomeusuario, emailusuario, loginusuario, senhausuario, usuarioativo) 
VALUES ('Administrador', 'administrador@administrador.com.br', 'admin', 'admin', 1);

-- Cria a tabela Marca
CREATE TABLE marca(
	marcaID		INTEGER NOT NULL AUTO_INCREMENT,
	nomemarca	VARCHAR(30) NOT NULL,
	PRIMARY KEY (marcaID)
);

-- Insere registros na tabela marca
INSERT INTO marca (nomemarca) VALUES ('AGRALE');
INSERT INTO marca (nomemarca) VALUES ('AUDI');
INSERT INTO marca (nomemarca) VALUES ('BASHAN');
INSERT INTO marca (nomemarca) VALUES ('BMW');
INSERT INTO marca (nomemarca) VALUES ('BRANDY');
INSERT INTO marca (nomemarca) VALUES ('CALOI');
INSERT INTO marca (nomemarca) VALUES ('CASE');

-- Cria a tabela Modelo
CREATE TABLE modelo(
	modeloID	INTEGER NOT NULL AUTO_INCREMENT,
	nomemodelo	VARCHAR(30) NOT NULL,
	marcaID		INTEGER,
	PRIMARY KEY(nomemodelo)
);

-- Insere registros na tabela modelo
INSERT INTO modelo (nomemodelo, marcaID) VALUES ('7000 DRD', 1);
INSERT INTO modelo (nomemodelo, marcaID) VALUES ('BUSSCAR', 1);
INSERT INTO modelo (nomemodelo, marcaID) VALUES ('DAKAR', 1);
INSERT INTO modelo (nomemodelo, marcaID) VALUES ('MASSEY', 1);

-- Cria a tabela Frota
CREATE TABLE frota(
	frotaID		INTEGER NOT NULL AUTO_INCREMENT,
	marcaID		INTEGER,
	modeloID	INTEGER,
	placa		VARCHAR(8) NULL,
	ano			VARCHAR(4) NULL,
	PRIMARY KEY (frotaID),
	FOREIGN KEY (marcaID) REFERENCES marca(marcaID) ON DELETE SET NULL,
	FOREIGN KEY (modeloID) REFERENCES modelo(modeloID) ON DELETE SET NULL
);

-- Insere registro na tabela frota
INSERT INTO frota (marcaID, modeloID, placa, ano) 
VALUES (1, 1, 'DTA-1787', '2007');

-- Cria a tabela Tipo de Veiculo
CREATE TABLE tipoveiculo(
	tipoveiculoID	INTEGER NOT NULL AUTO_INCREMENT,
	nometipoveiculo	VARCHAR(30) NOT NULL,
	PRIMARY KEY (tipoveiculoID)
);

-- Insere registro na tabela Tipo de Veículo
INSERT INTO tipoveiculo (nometipoveiculo) VALUES ('CAMIONETA');
INSERT INTO tipoveiculo (nometipoveiculo) VALUES ('MICROONIBUS');
INSERT INTO tipoveiculo (nometipoveiculo) VALUES ('CAMINHONETE');
INSERT INTO tipoveiculo (nometipoveiculo) VALUES ('ONIBUS');
INSERT INTO tipoveiculo (nometipoveiculo) VALUES ('CAMINHAO');
INSERT INTO tipoveiculo (nometipoveiculo) VALUES ('MOTO');
INSERT INTO tipoveiculo (nometipoveiculo) VALUES ('AUTOMOVEL');

-- Cria a tabela Motivo de Apreensão
CREATE TABLE motivoapreensao(
	motivoapreensaoID	INTEGER NOT NULL AUTO_INCREMENT,
	nomemotivoapreensao	VARCHAR(50),
	PRIMARY KEY (motivoapreensaoID)
);

-- Insere registro na tabela Motivo de Apreensão
INSERT INTO motivoapreensao (nomemotivoapreensao) VALUES ('RESGATE COM DESPESA');
INSERT INTO motivoapreensao (nomemotivoapreensao) VALUES ('EVADIU DO LOCAL');
INSERT INTO motivoapreensao (nomemotivoapreensao) VALUES ('VISTORIA IRREGULAR');
INSERT INTO motivoapreensao (nomemotivoapreensao) VALUES ('VEÍCULO COM IMPEDIMENTO JUDICIAL');
INSERT INTO motivoapreensao (nomemotivoapreensao) VALUES ('VEÍCULO TRANSPLANTADO');
INSERT INTO motivoapreensao (nomemotivoapreensao) VALUES ('VEÍCULO TOMADO DE ASSALTO');

-- Cria a tabela UF
CREATE TABLE estado(
	estadoID	INTEGER NOT NULL AUTO_INCREMENT,
	nomeestado	VARCHAR(50),
	siglaestado VARCHAR(2)	
);

-- Insere registros na tabela UF
INSERT INTO estado (nomeEstado, siglaEstado) VALUES ('Acre', 'AC');
INSERT INTO estado (nomeEstado, siglaEstado) VALUES ('Alagoas', 'AL');
INSERT INTO estado (nomeEstado, siglaEstado) VALUES ('Amapá', 'AP');
INSERT INTO estado (nomeEstado, siglaEstado) VALUES ('Amazonas', 'AM');
INSERT INTO estado (nomeEstado, siglaEstado) VALUES ('Bahia', 'BA');
INSERT INTO estado (nomeEstado, siglaEstado) VALUES ('Ceará', 'CE');
INSERT INTO estado (nomeEstado, siglaEstado) VALUES ('Distrito Federal', 'DF');
INSERT INTO estado (nomeEstado, siglaEstado) VALUES ('Espírito Santo', 'ES');
INSERT INTO estado (nomeEstado, siglaEstado) VALUES ('Goiás', 'GO');
INSERT INTO estado (nomeEstado, siglaEstado) VALUES ('Maranhão', 'MA');
INSERT INTO estado (nomeEstado, siglaEstado) VALUES ('Mato Grosso', 'MT');
INSERT INTO estado (nomeEstado, siglaEstado) VALUES ('Mato Grosso do Sul', 'MS');
INSERT INTO estado (nomeEstado, siglaEstado) VALUES ('Minas Gerais', 'MG');
INSERT INTO estado (nomeEstado, siglaEstado) VALUES ('Pará', 'PA');
INSERT INTO estado (nomeEstado, siglaEstado) VALUES ('Paraíba', 'PB');
INSERT INTO estado (nomeEstado, siglaEstado) VALUES ('Paraná', 'PR');
INSERT INTO estado (nomeEstado, siglaEstado) VALUES ('Pernambuco', 'PE');
INSERT INTO estado (nomeEstado, siglaEstado) VALUES ('Piauí', 'PI');
INSERT INTO estado (nomeEstado, siglaEstado) VALUES ('Rio de Janeiro', 'RJ');
INSERT INTO estado (nomeEstado, siglaEstado) VALUES ('Rio Grande do Norte', 'RN');
INSERT INTO estado (nomeEstado, siglaEstado) VALUES ('Rio Grande do Sul', 'RS');
INSERT INTO estado (nomeEstado, siglaEstado) VALUES ('Rondônia', 'RO');
INSERT INTO estado (nomeEstado, siglaEstado) VALUES ('Roraima', 'RR');
INSERT INTO estado (nomeEstado, siglaEstado) VALUES ('Santa Catarina', 'SC');
INSERT INTO estado (nomeEstado, siglaEstado) VALUES ('São Paulo', 'SP');
INSERT INTO estado (nomeEstado, siglaEstado) VALUES ('Sergipe', 'SE');
INSERT INTO estado (nomeEstado, siglaEstado) VALUES ('Tocantins', 'TO');

-- Cria a tabela Tipo de Pessoa
CREATE TABLE tipopessoa(
	tipopessoaID	INTEGER NOT NULL AUTO_INCREMENT,
	nometipopessoa	VARCHAR(30),
	PRIMARY KEY (tipopessoaID)
);

-- Insere registros na tabela Tipo de Pessoa
INSERT INTO estado (nometipopessoa) VALUES ('FISICA');
INSERT INTO estado (nometipopessoa) VALUES ('JURIDICA');

-- 
CREATE TABLE categoriacnh(
	categoriacnhID		INTEGER NOT NULL AUTO_INCREMENT,
	nomecategoriacnh	VARCHAR(1),
	PRIMARY KEY (categoriacnhID)
);

--
INSERT INTO categoriacnh (nomecategoriacnh) VALUES ('A');
INSERT INTO categoriacnh (nomecategoriacnh) VALUES ('B');
INSERT INTO categoriacnh (nomecategoriacnh) VALUES ('C');
INSERT INTO categoriacnh (nomecategoriacnh) VALUES ('D');
INSERT INTO categoriacnh (nomecategoriacnh) VALUES ('E');

-- Cria a tabela Pessoa
CREATE TABLE pessoa(
	pessoaID				INTEGER NOT NULL AUTO_INCREMENT,
	tipopessoaID			INTEGER,
	nome					VARCHAR(50),
	cpf						VARCHAR(14),
	rg						VARCHAR(20),
	cnh						VARCHAR(20),
	categoriacnh			INTEGER,
	datavencimentochn		DATETIME,
	datanascimento			DATE,
	razaosocial				VARCHAR(50),
	cnpj					VARCHAR(20),
	inscricaoestadual		VARCHAR(20),
	email					VARCHAR(50),
	telefone				VARCHAR(14), -- (00) 0000-0000
	celular					VARCHAR(14),
	cep						VARCHAR(9), -- 00000-000
	estadoID				INTEGER,
	cidade					VARCHAR(50),
	bairro					VARCHAR(50),
	logradouro				VARCHAR(60),
	complemento				VARCHAR(20),
	ufcomercial				INTEGER,
	cidadecomercial			VARCHAR(50),
	bairrocomercial			VARCHAR(50),
	logradourocomercial		VARCHAR(60),
	complementocomercial	VARCHAR(20),
	ufcobranca				INTEGER,
	cidadecobranca			VARCHAR(50),
	bairrocobranca			VARCHAR(50),
	logradourocobranca		VARCHAR(60),
	complementocobranca		VARCHAR(20),
	limitecredito			INTEGER,
	nomecontato				VARCHAR(50),
	emailcontato			VARCHAR(50),
	telefonecontato			VARCHAR(14),
	celularcontato			VARCHAR(14),
	observacao				TEXT,
	departamento			VARCHAR(30),
	cargo					VARCHAR(30),
	
	PRIMARY KEY (pessoaID),
	FOREIGN KEY (tipopessoaID) REFERENCES tipopessoa(tipopessoaID) ON DELETE SET NULL,
	FOREIGN KEY (estadoID) REFERENCES estado(estadoID) ON DELETE SET NULL
);

-- 
CREATE TABLE formaremocao(
	formaremocaoID		INTEGER NOT NULL AUTO_INCREMENT,
	nomeformaremocao	VARCHAR(30),
	PRIMARY KEY (formaremocaoID)
);

-- 
INSERT INTO formaremocao (nomeformaremocao) VALUES ('PELO POLICIAL');
INSERT INTO formaremocao (nomeformaremocao) VALUES ('PELO CONDUTOR');
INSERT INTO formaremocao (nomeformaremocao) VALUES ('REBOQUE');

-- 
CREATE TABLE especieveiculo(
	especieveiculoID		INTEGER NOT NULL AUTO_INCREMENT,
	nomeespecieveiculo	VARCHAR(30),
	PRIMARY KEY (especieveiculoID)
);

-- 
INSERT INTO especieveiculo (nomeespecieveiculo) VALUES ('CARGA');
INSERT INTO especieveiculo (nomeespecieveiculo) VALUES ('PASSAGEIRO');

-- 
CREATE TABLE apreensaoveiculo(
	apreensaoveiculoID	INTEGER NOT NULL AUTO_INCREMENT,
	placa				VARCHAR(8),
	estadoID			INTEGER,
	marcaID				INTEGER,
	modeloID			INTEGER,
	anofabricacao		VARCHAR(4),
	anomodelo			VARCHAR(4),
	cor					VARCHAR(20),
	renavam				VARCHAR(8),
	especieveiculoID	INTEGER,
	chassi				VARCHAR(8),
	tipoveiculoID		INTEGER,
	datarecepcao		DATE,
	horarecepcao		TIME,
	rva					VARCHAR(30),
	databo				DATE,
	horabo				TIME,
	numbo				VARCHAR(20),
	objetospessoais		TEXT,
	avarias				TEXT,
	formaremocaoID		INTEGER,
	motivo				INTEGER,
	kmreboque			VARCHAR(10),
	municipio			VARCHAR(50),
	reboquistaID		INTEGER,
	placareboque		INTEGER,
	policialresp		VARCHAR(30),
	cargopolicial		VARCHAR(30),
	matriculapolicial	VARCHAR(20),
	PRIMARY KEY (apreensaoveiculoID),
	FOREIGN KEY (estadoID) REFERENCES estado(estadoID) ON DELETE SET NULL,
	FOREIGN KEY (marcaID) REFERENCES marca(marcaID) ON DELETE SET NULL,
	FOREIGN KEY (modeloID) REFERENCES modelo(modeloID) ON DELETE SET NULL,
	FOREIGN KEY (especieveiculoID) REFERENCES especieveiculo(especieveiculoID) ON DELETE SET NULL,
	FOREIGN KEY (tipoveiculoID) REFERENCES tipoveiculo(tipoveiculoID) ON DELETE SET NULL,
	FOREIGN KEY (formaremocaoID) REFERENCES formaremocao(formaremocaoID) ON DELETE SET NULL,
	FOREIGN KEY (pessoaID) REFERENCES pessoa(pessoaID) ON DELETE SET NULL
);
















