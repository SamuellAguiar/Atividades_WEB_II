## Endpoints
Todos os endpoints passam pelo prefixo http://localhost:9081.

### 👤 User Service
Responsável pelo gerenciamento de usuários.

| Método | Endpoint | Descrição |
| :--- | :--- | :--- |
| **GET** | `/api/users` | Listar todos os usuários registrados |
| **POST** | `/api/users` | Criar um novo usuário (exige DTO completo) |
| **GET** | `/users/{id}` | Buscar detalhes de um usuário específico |
| **DELETE** | `/users/remove` | Apagar um usuário do sistema |

---

### 🎫 Event (Sales Service)
Gerencia a criação e listagem de eventos.

| Método | Endpoint | Descrição |
| :--- | :--- | :--- |
| **GET** | `/events/list-events` | Listar eventos disponíveis para venda |
| **POST** | `/events` | Registrar novo evento (exige descrição, preço e datas) |
| **DELETE** | `/events/exclude-event` | Remover um evento existente |

---

### 🛒 Sale (Sales Service)

> **Base URL:** `http://localhost:9081`

| Método | Endpoint | Descrição |
| :--- | :--- | :--- |
| **GET** | `/sales/list-sales` | Histórico completo de vendas realizadas |
| **POST** | `/sales` | Criar novo ticket (vincular User UUID e Event UUID) |
| **PUT** | `/sales/saleStatus` | Atualizar o status de uma venda ativa |

---

### 🔔 Notifications Service
Alertas e logs do sistema.

| Método | Endpoint | Descrição |
| :--- | :--- | :--- |
| **GET** | `/notifications/notifications-list` | Listar logs de notificações enviadas |
| **GET** | `/notifications/status` | Verificar se o serviço está online |

---