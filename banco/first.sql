CREATE DATABASE firstroad;

use firstroad;

CREATE TABLE tb_unidades(
	id BINARY(16) NOT NULL,
	razao_social VARCHAR(50) NOT NULL,
    cnpj VARCHAR(14) NOT NULL UNIQUE,
    logradouro VARCHAR(200) NOT NULL,
    numero INT NOT NULL,
    complemento VARCHAR(100),
    bairro VARCHAR (200) NOT NULL,
    cep VARCHAR(9) NOT NULL,
    
    PRIMARY KEY(id)
);

CREATE TABLE tb_conteudo(
	id BINARY(16) NOT NULL,
	titulo_conteudo VARCHAR(50) NOT NULL,
    descricao_conteudo VARCHAR(255) NOT NULL,
    link VARCHAR(255) NOT NULL,
    tempo_conteudo TIME NOT NULL,
    tipo TINYINT NOT NULL,
    
    PRIMARY KEY(id)
);

CREATE TABLE tb_usuarios(
	id BINARY(16) NOT NULL,
    nome VARCHAR(255) NOT NULL,
    email VARCHAR (100) NOT NULL UNIQUE,
    senha VARCHAR (60) NOT NULL,
    nif INT NOT NULL UNIQUE,
    data_nascimento DATE NOT NULL,
    
    tipo_usuario TINYINT NOT NULL,
	id_unidade BINARY(16)NOT NULL,
	url_imagem VARCHAR (255),
    url_avatar varchar (255),
    
	PRIMARY KEY(id),
    FOREIGN KEY(id_unidade) REFERENCES tb_unidades(id)
);

CREATE TABLE tb_unidades_organizacionais(
	id BINARY(16) NOT NULL,
    nome_departamento VARCHAR (200) NOT NULL,
    
    id_usuario BINARY(16) NOT NULL,
	id_unidade BINARY(16) NOT NULL,
    
	PRIMARY KEY(id),
    FOREIGN KEY(id_usuario) REFERENCES tb_usuarios(id),
    FOREIGN KEY(id_unidade) REFERENCES tb_unidades(id)
);

CREATE TABLE tb_trilha(
	id BINARY(16) NOT NULL,
    titulo_trilha VARCHAR (100) NOT NULL,
    descricao_trilha VARCHAR (255) NOT NULL,
    tempo_trilha TIME NOT NULL,
    situacao VARCHAR(50),
        
	PRIMARY KEY(id)
);
CREATE TABLE tb_trilha_conteudo(
	id_trilha BINARY(16) NOT NULL,
    id_conteudo BINARY(16) NOT NULL,
    concluido BOOLEAN NOT NULL,
    
    FOREIGN KEY(id_trilha) REFERENCES tb_trilha(id),
    FOREIGN KEY(id_conteudo) REFERENCES tb_conteudo(id)
);

CREATE TABLE tb_usuario_trilha(
	id_usuario BINARY(16) NOT NULL,
    id_trilha BINARY(16) NOT NULL,
    
	FOREIGN KEY(id_usuario) REFERENCES tb_usuarios(id),
    FOREIGN KEY(id_trilha) REFERENCES tb_trilha(id)
)