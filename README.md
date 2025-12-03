# 🎫 Sistema de Gerenciamento de Ingressos - Microsserviço Sales

Este repositório contém a implementação do microsserviço de **Vendas (Sales)** para o Sistema de Gerenciamento de Tickets. O projeto foi desenvolvido como parte da disciplina de Sistemas Web II, utilizando **Java**, **Spring Boot** e **Docker**.

## 🚀 Tecnologias Utilizadas

* **Java 17**
* **Spring Boot 3** (Web, Data JPA)
* **PostgreSQL** (Banco de Dados)
* **Docker & Docker Compose** (Containerização do Banco)

## ⚙️ Arquitetura

O projeto segue uma arquitetura em camadas para garantir a separação de responsabilidades:
* **Controller:** Camada de API (REST).
* **Service:** Regras de negócio.
* **Repository:** Acesso a dados (JPA).
* **Domain/Entity:** Representação do banco e do negócio.
* **DTO:** Transferência de dados (Entrada/Saída).
