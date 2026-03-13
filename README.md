# 🎟️ Full-Stack Ticketing Platform

A complete, full-stack solution designed to handle high-volume ticket sales securely. This project features a robust, event-driven RESTful API backend and a responsive, modern Single Page Application (SPA) frontend.

## 🚀 Key Features & Architecture

### Backend (Core Logic & Security)
* **Stateless Security:** Custom filter chain implementing token-based authentication (JWT) and Role-Based Access Control (RBAC) to isolate `ADMIN` and `CUSTOMER` operations.
* **Event-Driven Asynchronous Processing:** Integrates **RabbitMQ** to decouple heavy post-purchase operations, ensuring the main thread responds to the user in milliseconds.
* **Concurrency Control:** Engineered transaction safety using `@Version` Optimistic Locking in Hibernate to prevent race conditions and overselling during traffic spikes.
* **Containerized Infrastructure:** PostgreSQL and RabbitMQ environments are fully containerized using Docker Compose for instant local setup.
* **CORS Configured:** Securely configured Cross-Origin Resource Sharing to allow seamless communication with the frontend client.

### Frontend (User Interface)
* **Modern SPA:** Built with **React** and **TypeScript** using the ultra-fast Vite build tool.
* **Responsive Design:** Fully styled with **Tailwind CSS v4**, ensuring a premium, mobile-first user experience.
* **Client-Side Routing:** Utilizes **React Router** for seamless, refresh-free navigation between the Login and Events catalog.
* **API Integration:** Centralized HTTP client using **Axios** for clean and predictable data fetching from the Spring Boot backend.
* **State Management:** Securely manages user sessions by storing JWTs in the browser's Local Storage.

## 🛠️ Tech Stack

**Frontend Client:**
* React 18, TypeScript, Vite
* Tailwind CSS v4
* Axios, React Router DOM

**Backend API:**
* Java 17, Spring Boot 3.x, Spring Web
* Spring Security, JSON Web Tokens (JJWT), BCrypt
* RabbitMQ (AMQP)
* PostgreSQL, Spring Data JPA, Hibernate
* Docker, Docker Compose, Maven

---

## ⚙️ Getting Started (Local Development)

### 1. Prerequisites
* **Java 17 JDK** & **Maven**
* **Node.js** (v18+) & **npm**
* **Docker** & Docker Desktop running

### 2. Spin up the Infrastructure (Database & Broker)
Navigate to the backend root directory containing `docker-compose.yml` and run:
`docker-compose up -d`
*(Starts PostgreSQL on port 5432 and RabbitMQ on 5672/15672).*

### 3. Start the Backend (Spring Boot)
In the backend directory, run the application:
`mvn spring-boot:run`
*(The API will be available at http://localhost:8080)*

### 4. Start the Frontend (React/Vite)
Open a new terminal, navigate to the `ticketing-frontend` directory, install dependencies, and start the dev server:
`npm install`
`npm run dev`
*(The UI will be available at http://localhost:5173)*

## 🧪 Application Flow
1. Navigate to `http://localhost:5173/login` and authenticate using registered credentials.
2. The JWT token is securely stored in Local Storage.
3. You will be redirected to the `/events` dashboard to view the available catalog (fetched securely from the database).

## 🧠 Future Enhancements
* Implement Redis for caching frequently accessed event catalogs.
* Build the complete "Add to Cart" and checkout flow in React.
* Add a mock Payment Gateway integration.
