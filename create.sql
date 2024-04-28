create table candidato (id integer not null auto_increment, nascimento date, nota integer, sexo varchar(1), uf varchar(2), data_criacao datetime(6), bairro varchar(50), cidade varchar(50), nome varchar(100), logradouro varchar(200), primary key (id)) engine=InnoDB;
create table users (id integer not null, created_at datetime(6), updated_at datetime(6), email varchar(100) not null, full_name varchar(255) not null, password varchar(255) not null, primary key (id)) engine=InnoDB;
create table users_seq (next_val bigint) engine=InnoDB;
insert into users_seq values ( 1 );
alter table users add constraint UK_6dotkott2kjsp8vw4d0m25fb7 unique (email);
