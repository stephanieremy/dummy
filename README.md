# Getting Started

### Reference Documentation

For further reference, please consider the following sections:

* [Spring Boot DevTools](https://docs.spring.io/spring-boot/3.5.6/reference/using/devtools.html)
* [Spring Web](https://docs.spring.io/spring-boot/3.5.6/reference/web/servlet.html)
* [Spring Data JPA](https://docs.spring.io/spring-boot/3.5.6/reference/data/sql.html#data.sql.jpa-and-spring-data)

### 🚀 Running the Application with Docker Compose

This project includes a docker-compose.yml file to simplify the process of running the application.

🧭 Prerequisites

Make sure Docker is installed on your machine

This project uses Docker Compose to run a Spring Boot application connected to a PostgreSQL database.

▶️ Start the Application
In the root directory (where docker-compose.yml is located), run:

```
mvn clean install
docker-compose up --build
```

This will:

* Build the application image using the DockerFile located in docker/
* Start two containers:
    * app: The Spring Boot application
    * db: A PostgreSQL 13.1 database
* Automatically initialize the database with the init.sql script

* Once running, the application will be available at: http://localhost:8080

⛔ Stopping the Application
To stop the containers:

```
docker-compose down
```

### Test the API

The application integrates OpenAPI documentation.
It is available here : http://localhost:8080/api/swagger-ui/index.html
You can use Postman or even the swagger UI to test the API

You can access the database with the following url to ensure that the data is well persisted : jdbc:postgresql:
//localhost:5432/testdb

🧠 Why did I use Domain-Driven Design (DDD) in This Spring Boot Application ?

This application follows the Domain-Driven Design (DDD) approach to structure the codebase around the core business
logic.

🗂️ DDD Structure

The project is organized into layers:

domain/ – Core business logic (entities, value objects, domain services)

infrastructure/ or repository – Technical details (e.g., database, messaging, external APIs)

interfaces/ or adapter/ – REST controllers or other input/output interfaces

✅ Why Use DDD?

Business-Centric: Code reflects real-world business processes

Clear Separation of Concerns: Domain logic is isolated from technical infrastructure

Scalable and Maintainable: Easy to evolve and extend

Better Collaboration: Shared language between developers and business experts