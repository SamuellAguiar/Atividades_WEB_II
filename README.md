# Sistema de Gerenciamento de Ingressos - Microsserviço Sales

Este repositório contém a implementação do microsserviço de **Vendas (Sales)** para o Sistema de Gerenciamento de Tickets. O projeto foi desenvolvido como parte da disciplina de Sistemas Web II, utilizando **Java**, **Spring Boot** e **Docker**.

## Tecnologias Utilizadas

[![Java](https://img.shields.io/badge/Java-%23ED8B00.svg?logo=openjdk&logoColor=white)](#)

[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-6DB33F?logo=springboot&logoColor=fff)](#)

[![Postgres](https://img.shields.io/badge/Postgres-%23316192.svg?logo=postgresql&logoColor=white)](#)

[![Docker](https://img.shields.io/badge/Docker-2496ED?logo=docker&logoColor=fff)](#)

## Arquitetura

O projeto segue uma arquitetura em camadas para garantir a separação de responsabilidades:
* **Controller:** Camada de API (REST).
* **Service:** Regras de negócio.
* **Repository:** Acesso a dados (JPA).
* **Domain/Entity:** Representação do banco e do negócio.
* **DTO:** Transferência de dados (Entrada/Saída).
