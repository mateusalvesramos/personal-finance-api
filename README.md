<h1 align="center" style="font-weight: bold;">personal-finance-api</h1>

<p align="center">
 <a href="#technologies">Technologies</a> • 
 <a href="#started">Getting Started</a> •
 <a href="#routes">API Endpoints</a> •
 <a href="#documentation">Documentation</a>
</p>

<p align="center">
    <b>API REST desenvolvida em Java e Spring Boot para gerenciamento de finanças pessoais, permitindo o cadastro de usuários, contas e transações financeiras.</b>
</p>

<h2 id="technologies">💻 Technologies</h2>

* Java
* Spring Boot
* Spring Data JPA
* Hibernate
* MySQL
* Maven
* Lombok
* Swagger / OpenAPI

<h2 id="started">🚀 Getting Started</h2>

<h3>Prerequisites</h3>

* Java 17+
* Maven
* MySQL

<h3>Cloning</h3>

```bash
git clone https://github.com/mateusalvesramos/personal-finance-api.git
cd personal-finance-api
```

<h3>Config Database</h3>

Make sure you have MySQL installed and running on your machine.

The application uses the `finance` database and obtains the database credentials through the `DATABASE_USERNAME` and `DATABASE_PASSWORD` environment variables.

You can set the environment variables on Windows using PowerShell:

```powershell
$env:DATABASE_USERNAME="seu_usuario"
$env:DATABASE_PASSWORD="sua_senha"
```

On Linux/macOS:

```bash
export DATABASE_USERNAME="seu_usuario"
export DATABASE_PASSWORD="sua_senha"
```

The database will be created automatically if it does not exist.

<h3>Starting</h3>

Using Maven Wrapper:

**Windows:**

```powershell
.\mvnw.cmd spring-boot:run
```

**Linux/macOS:**

```bash
./mvnw spring-boot:run
```

Or run the application directly through your IDE.

The API will be available at:

```text
http://localhost:8080
```

<h2 id="routes">📍 API Endpoints</h2>

<h3>Users</h3>

| Method            | Route         | Description            |
| ----------------- | ------------- | ---------------------- |
| <kbd>POST</kbd>   | `/users`      | Creates a new user     |
| <kbd>GET</kbd>    | `/users`      | Retrieves all users    |
| <kbd>GET</kbd>    | `/users/{id}` | Retrieves a user by ID |
| <kbd>PUT</kbd>    | `/users/{id}` | Updates a user         |
| <kbd>DELETE</kbd> | `/users/{id}` | Deletes a user         |

<h3>Accounts</h3>

| Method            | Route            | Description                |
| ----------------- | ---------------- | -------------------------- |
| <kbd>POST</kbd>   | `/accounts`      | Creates a new account      |
| <kbd>GET</kbd>    | `/accounts`      | Retrieves all accounts     |
| <kbd>GET</kbd>    | `/accounts/{id}` | Retrieves an account by ID |
| <kbd>PUT</kbd>    | `/accounts/{id}` | Updates an account         |
| <kbd>DELETE</kbd> | `/accounts/{id}` | Deletes an account         |

<h3>Transactions</h3>

| Method            | Route                | Description                   |
| ----------------- | -------------------- | ----------------------------- |
| <kbd>POST</kbd>   | `/transactions`      | Creates a new transaction     |
| <kbd>GET</kbd>    | `/transactions`      | Retrieves all transactions    |
| <kbd>GET</kbd>    | `/transactions/{id}` | Retrieves a transaction by ID |
| <kbd>PUT</kbd>    | `/transactions/{id}` | Updates a transaction         |
| <kbd>DELETE</kbd> | `/transactions/{id}` | Deletes a transaction         |

<h2 id="documentation">📖 API Documentation</h2>

The complete API documentation is available through Swagger UI:

<a href="http://localhost:8080/swagger-ui/index.html">Swagger UI</a>

<h2 id="contribute">🤝 Contribute</h2>

Contributions, suggestions and improvements are welcome.

1. Fork the project
2. Create a new branch
3. Commit your changes
4. Open a Pull Request
