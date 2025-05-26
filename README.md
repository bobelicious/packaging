# API do Seu Manoel

Bem-vindo ao repositório da API de empacotamento de pedidos da loja do seu Manoel! Este projeto implementa uma API REST robusta e escalável, desenvolvida com Spring Boot e outras tecnologias modernas. Abaixo, você encontrará instruções para executar o projeto e detalhes sobre as tecnologias e padrões utilizados.

## Pré-requisitos

- Docker e Docker Compose instalados.
- Git para clonar o repositório.

## Como Executar

1. Clone o repositório:
   ```bash
   git clone https://github.com/bobelicious/packaging
   cd packaging
   ```

2. No diretório do arquivo `docker-compose.yml`, execute:
   ```bash
   docker compose up -d
   ```

3. Após a inicialização do container, acesse a API no endpoint:
   ```
   http://localhost/api/pedido/v1/new
   ```

4. Consulte a documentação da API via Swagger:
   ```
   http://localhost/swagger-ui.html
   ```

## Tecnologias e Padrões Utilizados

- **Spring Boot**: Framework principal para construção da API, garantindo desenvolvimento rápido e escalabilidade.
- **Testcontainers**: Biblioteca para testes de integração, simulando ambientes reais com alta confiabilidade.
- **Padrão Model-Service-Controller**: Arquitetura REST que organiza o código e facilita a manutenção.
- **DTO (Data Transfer Object)**: Utilizado para manipulação segura de payloads, aumentando a robustez da aplicação.
- **Mapper**: Converte entidades em DTOs, reduzindo duplicação de código e simplificando a lógica.
- **Lombok**: Elimina código boilerplate, melhorando a legibilidade e produtividade.
- **PostgreSQL**: Banco de dados relacional para armazenamento eficiente e confiável.
- **JPA (Java Persistence API)**: ORM padrão do Spring para mapeamento objeto-relacional.
- **Tomcat**: Servidor embutido do Spring Boot, simplificando o deploy.
- **Swagger**: Ferramenta para documentação interativa dos endpoints da API.
