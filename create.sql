create table candidato (id integer not null auto_increment, nascimento date, nota integer, sexo varchar(1), uf varchar(2), data_criacao datetime(6), bairro varchar(50), cidade varchar(50), nome varchar(100), logradouro varchar(200), primary key (id)) engine=InnoDB;
