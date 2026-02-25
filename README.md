# 🎟️ Scalable Event Ticketing API

A robust backend REST API built with Java and Spring Boot for managing events and processing ticket orders. This project serves as an MVP for a high-concurrency ticketing platform, specifically addressing data integrity during simultaneous purchase requests.

## 🚀 Key Features
* **Event & Order Management:** Full CRUD operations for creating events and processing ticket purchases.
* **Concurrency Control:** Implemented **Optimistic Locking** (`@Version`) to solve Race Conditions. Ensures the system never sells more tickets than available, even when hundreds of users attempt to buy the last ticket simultaneously.
* **Centralized Error Handling:** Uses `@ControllerAdvice` to intercept exceptions (e.g., `ObjectOptimisticLockingFailureException`) and return clean, standardized JSON responses (e.g., `409 Conflict`, `400 Bad Request`) instead of raw server errors.
* **Layered Architecture:** Strict separation of concerns (Controllers, Services, Repositories, Entities).

## 🛠️ Tech Stack
* **Language:** Java 21 (or 17)
* **Framework:** Spring Boot 3.x
* **Data Access:** Spring Data JPA / Hibernate
* **Database:** H2 In-Memory Database (for rapid MVP testing)
* **Tools:** Lombok, Maven, Postman (Performance Testing)

## 🏃‍♂️ How to Run Locally
1. Clone the repository.
2. Run `mvn spring-boot:run` or start `TicketServiceApplication.java` from your IDE.
3. The server will start on `http://localhost:8080`.
4. Access the H2 Database console at `http://localhost:8080/h2-console` (JDBC URL: `jdbc:h2:mem:ticketdb`).

## 🗺️ Phase 2 Roadmap (In Progress)
To elevate this MVP to an enterprise-grade distributed system, the following architecture upgrades are planned:
* Extracting monolithic components into **Microservices** (`User-Service`, `Event-Service`, `Order-Service`).
* Implementing **Redis** for high-speed ticket availability caching.
* Integrating **RabbitMQ/Kafka** for asynchronous order processing and email notifications.
* **Dockerizing** the infrastructure.
