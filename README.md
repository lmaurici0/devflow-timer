# DevFlow Timer API

API REST para controle de **sessões de foco** e **métricas de produtividade** baseada no famoso metodo de ensino, Pomodoro. desenvolvida com Spring Boot.  
A API é focada em **regras de negócio**, controle de estado e estatísticas automáticas.

---

## Objetivo do Projeto

Ajudar desenvolvedores e estudantes a registrarem sessões de foco (ex: técnica Pomodoro) e obterem métricas simples de produtividade diária.

Este projeto foi criado com foco em:
- Arquitetura limpa
- Regras de negócio bem definidas
- APIs pequenas e objetivas
- Código fácil de manter e evoluir

---

## Regras de Negócio

- Apenas **uma sessão de foco ativa por vez**
- Uma sessão pode ser **iniciada** e **finalizada**
- As métricas do dia são calculadas automaticamente:
  - Total de sessões
  - Tempo total focado
- Não utiliza banco de dados (estado em memória)

---

## Tecnologias Utilizadas

- Java 17+
- Spring Boot
- Spring Web
- Springdoc OpenAPI (Swagger)
- Maven

---

## Como rodar a API:

1. Clone o repositório:
   ```bash
   git clone https://github.com/seu-usuario/devflow-timer.git
   cd devflow-timer
   
2. Execute a classe:
   ```bash
   DevflowTimerApplication

3. Acesse a API em:
   ```bash
   http://localhost:8080

## Endpoints Principais

### Iniciar sessão de foco
`POST /sessions/start`

Inicia uma nova sessão de foco.

---

### Finalizar sessão de foco
`POST /sessions/end`

Finaliza a sessão ativa e calcula o tempo focado.

---

### Estatísticas do dia
`GET /sessions/stats/today`

Retorna as métricas de produtividade do dia atual.

---

## Documentação da API (Swagger)

A API possui documentação automática via Swagger, permitindo testar todos os endpoints diretamente pelo navegador, disponível em:

```bash
  http://localhost:8080/swagger-ui/index.html
