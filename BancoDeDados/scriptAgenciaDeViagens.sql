create database agencia_de_viagens;
use agencia_de_viagens;

CREATE TABLE pacotesViagens (
Cod_pacote INTEGER PRIMARY KEY AUTO_INCREMENT,
Cod_destino INTEGER,
quantidade NUMERIC(10),
Preco DECIMAL(10),
Descricao VARCHAR(200 )
);

Create TABLE destinos (
Cod_destino INTEGER PRIMARY KEY AUTO_INCREMENT,
Endereco VARCHAR(100 ),
Nome VARCHAR(100),
Telefone VARCHAR( 15),
Quantidade NUMERIC(10 )
);

CREATE TABLE clientes (
id_clientes INTEGER PRIMARY KEY AUTO_INCREMENT,
Nome VARCHAR(100 ),
Endereco VARCHAR(100 ),
Cpf VARCHAR(15),
idade integer,
Email VARCHAR(50 )
);

CREATE TABLE compra (
Cod_compra INTEGER PRIMARY KEY AUTO_INCREMENT,
id_clientes INTEGER,
Cod_pacote INTEGER,
dataCompra DATETIME,
FOREIGN KEY(id_clientes) REFERENCES clientes (id_clientes),
FOREIGN KEY(Cod_pacote) REFERENCES pacotesViagens (Cod_pacote)
);

ALTER TABLE pacotesViagens ADD FOREIGN KEY(Cod_destino) REFERENCES destinos (Cod_destino);



