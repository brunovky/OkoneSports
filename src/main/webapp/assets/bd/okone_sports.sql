DROP SCHEMA IF EXISTS OKONE_SPORTS;

CREATE SCHEMA OKONE_SPORTS;

USE OKONE_SPORTS;

CREATE TABLE ENDERECO (
	ID INT PRIMARY KEY AUTO_INCREMENT,
	LOGRADOURO VARCHAR(200) NOT NULL,
	COMPLEMENTO VARCHAR(200),
	NUMERO VARCHAR(40) NOT NULL,
	CEP CHAR(9) NOT NULL,
	BAIRRO VARCHAR(60) NOT NULL,
	CIDADE VARCHAR(100) NOT NULL,
	ESTADO VARCHAR(100) NOT NULL,
	PAIS VARCHAR(40) NOT NULL
);

CREATE TABLE USUARIO (
	ID INT PRIMARY KEY AUTO_INCREMENT,
	NOME VARCHAR(200) NOT NULL,
	EMAIL VARCHAR(200) NOT NULL,
	SENHA VARCHAR(255) NOT NULL,
	RG CHAR(12) NOT NULL,
	CPF CHAR(14) NOT NULL,
	DATANASCIMENTO DATE NOT NULL,
	TIPO CHAR(1) NOT NULL, /* 0 - ADMIN; 1 - CLIENTE */
	IDENDERECO INT NOT NULL,
	ATIVO BOOLEAN NOT NULL,
	FOREIGN KEY (IDENDERECO) REFERENCES ENDERECO(ID) ON UPDATE CASCADE
);

CREATE TABLE CATEGORIA (
	ID INT PRIMARY KEY AUTO_INCREMENT,
	NOME VARCHAR(100) NOT NULL
);

CREATE TABLE PRODUTO (
	ID INT PRIMARY KEY AUTO_INCREMENT,
	NOME VARCHAR(200) NOT NULL,
	DESCRICAO VARCHAR(255),
	VALOR DECIMAL(8, 2) NOT NULL,
	MARCA VARCHAR(100) NOT NULL,
	IDCATEGORIA INT NOT NULL,
	FOREIGN KEY (IDCATEGORIA) REFERENCES CATEGORIA(ID) ON UPDATE CASCADE
);

CREATE TABLE CARRINHO (
	ID INT PRIMARY KEY AUTO_INCREMENT,
	DATA DATE NOT NULL,
	VALORTOTAL DECIMAL(8, 2) NOT NULL,
	IDCLIENTE INT NOT NULL,
	FOREIGN KEY (IDCLIENTE) REFERENCES USUARIO(ID) ON UPDATE CASCADE 
);

CREATE TABLE ITEMCARRINHO (
	ID INT PRIMARY KEY AUTO_INCREMENT,
	QUANTIDADE INT NOT NULL,
	IDPRODUTO INT NOT NULL,
	IDCARRINHO INT NOT NULL,
	FOREIGN KEY (IDPRODUTO) REFERENCES PRODUTO(ID) ON UPDATE CASCADE,
	FOREIGN KEY (IDCARRINHO) REFERENCES CARRINHO(ID) ON UPDATE CASCADE
);