CREATE TABLE professor (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    telefone VARCHAR(15),
    especialidade VARCHAR(50)
);

CREATE TABLE aluno (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    telefone VARCHAR(15),
    data_nascimento DATE
);

CREATE TABLE turma (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    professor_id INTEGER REFERENCES professor(id)
);

CREATE TABLE avaliacao (
    id SERIAL PRIMARY KEY,
    trimestre INTEGER NOT NULL,
    notas DOUBLE PRECISION[],
    nota_recuperacao DOUBLE PRECISION,
    aluno_id INTEGER REFERENCES aluno(id)
);

CREATE TABLE aluno_turma (
    aluno_id INTEGER REFERENCES aluno(id),
    turma_id INTEGER REFERENCES turma(id),
    PRIMARY KEY (aluno_id, turma_id)
);