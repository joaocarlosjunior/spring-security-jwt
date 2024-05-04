<h1 align="center" style="font-weight: bold;">Implementação de segurança com Spring Security e JWT</h1>
<p align="center">
  <a href="#recursos">Recursos</a> • 
  <a href="#tecnologias">Tecnologias</a> • 
  <a href="#instalar">Instalação</a> •
  <a href="#rotas">API Endpoints</a>
</p>
<p align="center">
    <b>Este projeto demonstra a implementação de segurança em uma aplicação Spring Boot usando Spring Security e JSON Web Tokens (JWT).</b>
</p>

<h2 id="recursos">Recursos</h2>

- **Cadastro e Login de Usuário**: Sistema de registro e login de usuários.

- **Autenticação JWT**: Utiliza JSON Web Tokens para autenticar usuários. Permitindo autenticação sem salvar estado.

- **Criptografia de Senha**: Senhas dos usuários são criptografadas usando o algoritmo BCrypt, proporcionando uma camada
  adicional de segurança.

- **Autorização Baseada em Role**: Acesso a rotas e recursos com base nas funções (roles) do usuário.

<h2 id="tecnologias">Tecnologias</h2>

- [Spring Boot 3.2.5](https://spring.io/projects/spring-boot)

- [Spring Security](https://spring.io/projects/spring-security)

- [H2 Database](https://www.h2database.com/html/main.html)

- [JWT](https://jwt.io/)

- [Lombok](https://projectlombok.org/)

<h2 id="instalar">Instalação</h2>

#### Pré Requisitos

- Java 17
- GIT

#### Clonando projeto</h3>

```bash
git clone git@github.com:joaocarlosjunior/spring-security-jwt.git
```

<h2 id="rotas">API Endpoints</h2>
Rotas sem necessidade de autenticação e autorização:

| rota                         | descrição                                                        |
|------------------------------|------------------------------------------------------------------|
| <kbd>POST /auth/signup</kbd> | Cria usuário [request e response details](#post-user-signup)     |
| <kbd>POST /auth/login</kbd>  | Autentica usuário [request e response details](#post-user-login) |

Rotas que precisam de autenticação e autorização USER:

| rota                       | descrição                                                                    |
|----------------------------|------------------------------------------------------------------------------|
| <kbd>GET /users/user</kbd> | Retorna dados do usuário autenticado [request e response details](#get-user) |

Rotas que precisam de autenticação e autorização ADMIN:

| rota                  | descrição                                                                         |
|-----------------------|-----------------------------------------------------------------------------------|
| <kbd>GET /users</kbd> | Retorna todos usuários cadastrados [request e response details](#get-users-admin) |

<h3 id="post-user-signup">POST /auth/signup</h3>

**REQUEST**
```json
{
  "firstName": "João",
  "lastName": "Carlos",
  "email": "email@gmail.com",
  "password": "1234",
  "role": "ROLE_USER"
}
```

**RESPONSE**
```json
{
  "firstName": "João",
  "lastName": "Carlos",
  "email": "email@gmail.com",
  "role": "ROLE_USER"
}
```

<h3 id="post-user-login">POST /auth/login</h3>

**REQUEST**
```json
{
  "email": "email@gmail.com",
  "password": "1234"
}
```

**RESPONSE**
```json
{
  "token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzZWN1cml0eS1qd3QtYXBpIiwiaWF0IjoxNzE0NzYyNzIzLCJleHAiOjE3MTQ3OTg3MjMsInN1YiI6ImVtYWlsQGdtYWlsLmNvbSJ9.mBrdogTyydRMUeuIXwnVWF1n8wl00sBRXZoHzH3aPfw"
}
```

<h3 id="get-user">GET /users/user</h3>

**REQUEST HEADER**
```json
{
  "Authorization": "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzZWN1cml0eS1qd3QtYXBpIiwiaWF0IjoxNzE0NzYyNzIzLCJleHAiOjE3MTQ3OTg3MjMsInN1YiI6ImVtYWlsQGdtYWlsLmNvbSJ9.mBrdogTyydRMUeuIXwnVWF1n8wl00sBRXZoHzH3aPfw"
}
```

**RESPONSE**
```json
{
  "firstName": "João",
  "lastName": "Carlos",
  "email": "email@gmail.com",
  "role": "ROLE_USER"
}
```

<h3 id="get-users-admin">GET /users</h3>

**REQUEST HEADER**
```json
{
  "Authorization": "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzZWN1cml0eS1qd3QtYXBpIiwiaWF0IjoxNzE0NzY2MDgzLCJleHAiOjE3MTQ4MDIwODMsInN1YiI6ImpvYW9AZW1haWwuY29tIn0.So9Z0B91jo1A0hbiBE9ELBNyVuAU-_tsZzVGQUlZNGE"
}
```

**RESPONSE**
```json
[
  {
    "firstName": "João",
    "lastName": "Carlos",
    "email": "email@gmail.com",
    "role": "ROLE_USER"
  },
  {
    "firstName": "João",
    "lastName": "Ribas",
    "email": "joao@email.com",
    "role": "ROLE_ADMIN"
  }
]
```

