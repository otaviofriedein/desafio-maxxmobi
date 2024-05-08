# Projeto Spring Boot - CRUD Candidatos

Este é um projeto Spring Boot que requer Java JDK 17+ e Maven para execução. Ele também utiliza integração com banco de dados MySQL através da dependência "spring-boot-docker-compose".

## Pré-requisitos

Certifique-se de ter os seguintes pré-requisitos instalados em sua máquina:

- [Java JDK 17+](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)
- [Maven](https://maven.apache.org/)
- [Docker](https://www.docker.com/)

## Configuração do Banco de Dados

O banco de dados MySQL será configurado automaticamente ao executar a aplicação com Docker Compose. Certifique-se de que nenhum outro serviço esteja utilizando a porta 3307.

Aqui está a configuração do banco de dados no arquivo [application.properties](src/main/resources/application.properties):


 - spring.datasource.url=jdbc:mysql://localhost:3307/my-service-db?useSSL=false
 - spring.datasource.username=root
 - spring.datasource.password=Octopus@123@ 

## Executando Localmente

Para executar a aplicação localmente, siga estas etapas:

1. Certifique-se de que o Docker está instalado e em execução na sua máquina.
2. Navegue até o diretório raiz do projeto no terminal.
3. Execute o seguinte comando Maven para compilar o projeto:

```
mvn clean package
```

4. Após a conclusão da compilação, execute o seguinte comando para iniciar a aplicação com Docker Compose:

```
docker-compose up --build
```

Isso iniciará a aplicação e o banco de dados MySQL em contêineres Docker.

5. Acesse a aplicação em `http://localhost:8080`.

## Contribuindo

Sinta-se à vontade para contribuir para este projeto. Você pode abrir problemas para relatar bugs ou solicitar novos recursos.

Se desejar contribuir com código, siga estas etapas:

1. Faça um fork do repositório.
2. Crie uma branch com a sua feature (`git checkout -b feature/MinhaFeature`).
3. Faça commit das suas mudanças (`git commit -am 'Adiciona nova feature'`).
4. Faça push para a branch (`git push origin feature/MinhaFeature`).
5. Crie um novo Pull Request.

## Licença

Este projeto está licenciado sob a [MIT License](LICENSE).

