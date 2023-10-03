CREATE TABLE EMPRESTIMO (
 id INT PRIMARY KEY AUTO_INCREMENT,
 dateEmprestimo DATE,
 dateDevolucao DATE,
 aluno_id INT,
 publicacao_id INT,
 FOREIGN KEY (aluno_id) REFERENCES ALUNO (id),
 FOREIGN KEY (publicacao_id) REFERENCES PUBLICACAO (id)
);

CREATE TABLE PUBLICACAO (
 id INT PRIMARY KEY AUTO_INCREMENT,
 ano INT,
 tipo VARCHAR(100),
 autor VARCHAR(100),
 titulo VARCHAR(100),
 codigoPub INT
);

CREATE TABLE ALUNO (
 id INT PRIMARY KEY AUTO_INCREMENT,
 nome VARCHAR(100),
 matriculaAluno INT
);