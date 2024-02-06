-- V1__Baseline.sql

-- Criação da Tabela Curso
CREATE TABLE IF NOT EXISTS curso (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    categoria VARCHAR(255) NOT NULL
);

-- Criação da Tabela Usuario
CREATE TABLE IF NOT EXISTS usuario (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL
);

-- Criação da Tabela Topico
CREATE TABLE IF NOT EXISTS topico (
    id SERIAL PRIMARY KEY,
    titulo VARCHAR(100) NOT NULL,
    mensagem TEXT,
    data_criacao TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    curso_id INTEGER,
    autor_id INTEGER,
    status VARCHAR(255) DEFAULT 'NAO_RESPONDIDO',
    FOREIGN KEY (curso_id) REFERENCES curso(id),
    FOREIGN KEY (autor_id) REFERENCES usuario(id)
);

-- Criação da Tabela Resposta
CREATE TABLE IF NOT EXISTS resposta (
    id SERIAL PRIMARY KEY,
    mensagem TEXT NOT NULL,
    data_criacao TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    autor_id INTEGER,
    topico_id INTEGER,
    solucao BOOLEAN DEFAULT false,
    FOREIGN KEY (autor_id) REFERENCES usuario(id),
    FOREIGN KEY (topico_id) REFERENCES topico(id)
);

-- Fim do Script
