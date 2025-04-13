# Spring Boot 3 Web Application

This project is a **Spring Boot 3** based web application that provides **RESTful API** services and performs basic CRUD operations.

## Features

- Developed using **Spring Boot 3**.
- Supports **RESTful APIs**.
- **H2 Database** for development.
- **Spring Security** for user authentication and authorization.
- **Actuator** support for application health monitoring and metrics.
- **JWT Authentication** for secure API requests.
- **Swagger UI** for API documentation.

## Technologies

- **Java 17+** (compatible with Spring Boot 3)
- **Spring Boot 3**
- **Spring Data JPA** (for database operations)
- **H2 Database** (for development)
- **Spring Security** (for user authentication)
- **Spring Boot Actuator** (for application health checks)
- **Swagger UI** (for API documentation)
- **JWT Authentication** (for user authentication)
- **Maven** (for dependency management)
- **Apache Tomcat** (web server)

## Getting Started

To run this project locally, follow these steps:

### Prerequisites

- **Java 17** or newer.
- **Maven** installed.
- An IDE (IntelliJ IDEA, VSCode, Eclipse, etc.) is recommended.

### Running the Project

1. Clone the project from GitHub:
    ```bash
    git clone https://github.com/saityolal/Spring-boot-3.git
    ```

2. Navigate to the project directory:
    ```bash
    cd Spring-boot-3
    ```

3. Install dependencies with Maven:
    ```bash
    mvn clean install
    ```

4. Run the application:
    ```bash
    mvn spring-boot:run
    ```

   After the application starts, you can access it at [http://localhost:8080](http://localhost:8080).

### Swagger UI
- The API documentation can be accessed through the Swagger UI at:
  [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

### H2 Database Console
The application uses the **H2 Database** for development. You can access the H2 console at:
- H2 Console: [http://localhost:8080/h2-console](http://localhost:8080/h2-console)
  
Database URL: `jdbc:h2:mem:testdb`

Username: `SA`  
Password: (Leave empty)

## Security

The project uses **Spring Security** to secure endpoints. **JWT Authentication** is implemented for API security. Unauthorized access to API endpoints is blocked unless a valid JWT token is provided.

The following endpoints are available:

- **POST /login**: User login and JWT token retrieval.
- **GET /user/**: Retrieve authenticated user information.

Make sure to send the JWT token as a header in API requests to access secured endpoints.

## Tests

The project uses **Spring Boot Test** for unit and integration tests. You can run the tests using the following command:

```bash
mvn test
