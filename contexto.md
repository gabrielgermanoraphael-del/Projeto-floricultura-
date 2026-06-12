Contexto do Projeto

Este projeto é um trabalho acadêmico desenvolvido em Java 25 utilizando Spring Boot e MySQL.

Tema

O sistema será uma Floricultura, responsável pelo gerenciamento de flores, clientes e pedidos.

Arquitetura

O projeto seguirá o padrão Spring MVC, utilizando as seguintes camadas:

Model (Entidades)
Repository
Service
Controller

A comunicação deverá seguir o fluxo:

Controller → Service → Repository → Banco de Dados

Objetivo de Aprendizado

O objetivo principal é compreender os conceitos de Java Orientado a Objetos, Spring Boot, JPA/Hibernate, injeção de dependências e relacionamentos entre entidades.

Portanto, ao sugerir código:

Explique o que cada parte faz.
Explique o motivo das anotações utilizadas.
Explique como uma camada se relaciona com a outra.
Prefira orientar e ensinar em vez de entregar soluções completas sem explicação.
Adicione comentários educativos ao código sempre que possível.
Requisitos do Projeto

A aplicação deve possuir:

Pelo menos 3 entidades.
Pelo menos 3 controllers.
CRUD completo para cada controller.
Pelo menos 3 buscas diferentes por controller.
Pelo menos um relacionamento entre entidades.
Persistência em banco de dados MySQL.
Possíveis Entidades
Flor
Cliente
Pedido
Relacionamentos Esperados

Exemplos de relacionamentos que podem existir:

Um cliente pode realizar vários pedidos.
Um pedido pertence a um cliente.
Um pedido pode conter uma ou mais flores.
Diretrizes para Respostas

Quando sugerir implementações:

Explique primeiro o conceito.
Depois mostre um exemplo.
Explique cada anotação utilizada.
Explique como a implementação afeta o banco de dados.
Evite gerar grandes blocos de código sem explicação.
Priorize o aprendizado e entendimento da arquitetura.

Considere que o desenvolvedor está aprendendo Spring Boot e deseja compreender o
funcionamento do projeto, e não apenas copiar soluções prontas.