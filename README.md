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

- **Estrutura de Microsserviços:** O sistema foi dividido em três domínios principais: Users, Sales e Notifications. Cada um possui seu próprio banco de dados PostgreSQL via Docker, evitando dependências diretas e facilitando a manutenção isolada de cada parte.


- **API Gateway:** Gerencia todas as chamadas do Frontend. Ele utiliza o Eureka para encontrar os serviços e aplica regras de *rewritePath* para esconder as rotas internas, aumentando a segurança.


- **DTOs e Records:** Foram utilizados para definir contratos rígidos de entrada e saída. Isso garante que o backend receba apenas os dados necessários (como UUIDs e Enums) e responda de forma padronizada.


- **Segurança de Acesso:** O controle de CORS foi centralizado no Gateway. Isso permite que apenas o domínio do frontend consiga acessar as APIs, protegendo o ecossistema de acessos externos não autorizados.

## Autor

> Samuell Carlos de OIiveria Aguiar - 21.2.8025
