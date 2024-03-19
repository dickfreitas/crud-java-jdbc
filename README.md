# CRUD em Java utilizando JDBC

Este repositório contém um exemplo básico de um CRUD (Create, Read, Update, Delete) implementado em Java utilizando JDBC (Java Database Connectivity). O objetivo deste projeto é demonstrar como realizar operações básicas de banco de dados utilizando Java.

## Funcionalidades

O CRUD implementado neste projeto permite:

- Criar novos registros no banco de dados
- Ler informações existentes no banco de dados
- Atualizar registros no banco de dados
- Deletar registros do banco de dados

## Requisitos

Para executar este projeto localmente, é necessário ter os seguintes requisitos:

- Java Development Kit (JDK) instalado na sua máquina
- Um banco de dados MySQL (ou outro banco de dados suportado pelo JDBC) configurado e acessível

## Configuração do Banco de Dados

Antes de executar o projeto, certifique-se de configurar corretamente o banco de dados. Você pode fazer isso editando o arquivo de configuração `db.properties` e fornecendo as informações de conexão necessárias, como URL do banco de dados, usuário e senha.

Exemplo de `db.properties`:
db.url=jdbc:mysql://localhost:3306/meu_banco_de_dados

db.username=usuario

db.password=minha_senha

## Executando o Projeto

1. Clone este repositório para o seu ambiente local.
2. Configure o banco de dados conforme descrito acima.
3. Compile o projeto utilizando o comando `javac`.
4. Execute o projeto utilizando o comando `java`.
5. Siga as instruções no console para interagir com o CRUD.

## Contribuição

Contribuições são bem-vindas! Se você encontrar algum problema ou tiver sugestões de melhorias, sinta-se à vontade para abrir uma issue ou enviar um pull request.