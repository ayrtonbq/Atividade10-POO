
CREATE DATABASE Aula10;

use Aula10;

CREATE TABLE Categoria (
    id_categoria integer primary key auto_increment,
    nome varchar(100) not null
);

CREATE TABLE Livro (
    id_livro integer primary key auto_increment,
    nome varchar(100) not null,
    autor varchar(50),
    ano_publicacao varchar(4),
    tipo varchar(10)
);

CREATE TABLE LivroCategoria (
    id_lc INTEGER PRIMARY KEY AUTO_INCREMENT,
    id_livro INTEGER,
    id_categoria INTEGER,
    FOREIGN KEY (id_livro) REFERENCES Livro(id_livro),
    FOREIGN KEY (id_categoria) REFERENCES Categoria(id_categoria)
);


INSERT INTO categoria VALUES (1,'Romance');
INSERT INTO categoria VALUES (2,'Policial');
INSERT INTO categoria VALUES (3,'Terror');
INSERT INTO categoria VALUES (4,'Ficção Científica');
INSERT INTO categoria VALUES (5,'Infantil');
