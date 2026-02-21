# Sistema de Gerenciamento de Ingressos - Microsserviço Sales
> **Atividade Prática 01 - Implementação do microsserviço de Vendas de Ingressos**

> **Atividade Prática 02 - Implementação da interface do Sistemas de Ingressos**

> **Disciplina:** CSI607 - Sistemas WEB II (2025/2)

> **Professor:** Fernando Bernardes de Oliveira, Ph.D

Este projeto é uma plataforma completa de gerenciamento e venda de ingressos, desenvolvida para a disciplina de **Sistemas Web II**. A solução utiliza uma arquitetura de microsserviços para garantir escalabilidade, independência de serviços e alta disponibilidade.

## Como Executar o sistema
Para que o sistema funcione, os serviços devem ser iniciados na ordem correta, garantindo que o Service Discovery consiga mapear todas as instâncias.

### 1. Infraestrutura e Banco de Dados
Certifique-se de que o Docker está rodando os containers do PostgreSQL para os bancos *users, sales e notifications*.

### 2. Backend (Ordem de Inicialização)
- 2.1. **Nameservice (Eureka Server):** Porta *8761*. O coração do sistema onde todos os serviços se registram.
- 2.2.  **Microsserviços de Negócio:** 
  -  *Users-Service:* Porta 3000
  -  *Sales-Service:* Porta 3030
  -  *Notifications-Service:* Porta 5000

- 2.3. **API Gateway (9081):** O ponto de entrada único que gerencia o roteamento e o CORS.

### 3. Frontend (React + Vite)
No diretório ticketFrontend, execute:

```
npm install
npm run dev
```

## Tecnologias Utilizadas
### BackEnd:

[![Java](https://img.shields.io/badge/Java-%23ED8B00.svg?logo=openjdk&logoColor=white)](#)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-6DB33F?logo=springboot&logoColor=fff)](#)

### FrontEnd:

[![React](https://img.shields.io/badge/React-%2320232a.svg?logo=react&logoColor=%2361DAFB)](#)
[![TypeScript](https://img.shields.io/badge/TypeScript-3178C6?logo=typescript&logoColor=fff)](#)

### Banco de Dados:

[![Postgres](https://img.shields.io/badge/Postgres-%23316192.svg?logo=postgresql&logoColor=white)](#)
[![Docker](https://img.shields.io/badge/Docker-2496ED?logo=docker&logoColor=fff)](#)

##  Critérios de Implementação
O projeto foi construído seguindo rigorosos critérios técnicos:
- **API Gateway:** Roteamento centralizado com reescrita de caminhos (*rewritePath*) para isolar os microsserviços.
- **Service Discovery:** Registro dinâmico de instâncias no Eureka, permitindo balanceamento de carga via lb://.
- **Contratos Rígidos (DTOs):** Uso de *Records* e *DTOs* no Java para validação de entrada de dados, garantindo a integridade entre Front e Back.
- **Segurança (CORS):** Configuração centralizada no Gateway para permitir apenas requisições originadas do domínio do Frontend.
- **Interface Reativa:** Frontend com gerenciamento de estado, navegação dinâmica via *Outlet*.


## Autor
> Samuell Carlos de OIiveria Aguiar - 21.2.8025
