# Formula One Microservices Project 🏎️

This project is a **microservices-based application** for managing **Formula 1 racing statistics**.  
It uses **Spring Boot**, **Spring Cloud Eureka**, **Spring Cloud Gateway**, **PostgreSQL**, and **Docker** for containerization.

---

## 🛠 Technologies Used

- **Spring Boot 3.4**
- **Spring Cloud Eureka** (Service Discovery)
- **Spring Cloud Gateway** (API Gateway & Routing)
- **PostgreSQL 15** (Database)
- **Docker & Docker Compose** (Containerization and orchestration)
- **OpenFeign** (Inter-service communication)

---

## 📂 Microservices Structure

- **eureka-server** — Service registry and discovery (Eureka Server)
- **api-gateway** — Single entry point for clients (Spring Cloud Gateway)
- **driver-service** — Manages drivers (CRUD operations)
- **team-service** — Manages racing teams (CRUD operations)
- **race-service** — Manages race results and history (CRUD operations)
- **postgres** — Relational database to store all data

---

## 🚀 How to Run the Project

1. **Build all services**
   ```bash
   ./gradlew clean build
   ```
2.	**Start Docker containers**
   ```bash
    ./docker-compose up --build
   ```
3.	Access Services
- Eureka Server Dashboard: http://localhost:8761
-	API Gateway: http://localhost:8765
4.	Sample API Requests (through Gateway)
-	Get all drivers: GET http://localhost:8765/api/drivers/all
-	Get all teams: GET http://localhost:8765/api/teams/all
-	Get all races: GET http://localhost:8765/api/races/all

---

## 🐳 Docker Compose Overview
-	postgres: PostgreSQL database with custom schemas for drivers, teams, and races.
-	eureka-server: Starts only after Postgres becomes healthy.
-	driver-service, team-service, and race-service: Depend on healthy Eureka and Postgres.
-	api-gateway: Routes external API requests to internal services.

Health checks ensure that services start only when their dependencies are ready.

---

## ⚙️ Key Features
- Service Discovery via Eureka Server
-	Dynamic Routing with API Gateway
-	Microservices Communication via OpenFeign
-	Dockerized Infrastructure for easy local deployment
-	Database Schema Separation (different schemas for drivers, teams, races)
-	Health Checks for PostgreSQL and Eureka Server

---

## 📝 Notes
•	PostgreSQL schemas (drivers, teams, races) must exist before Hibernate can create tables.
•	API Gateway listens on port 8765, not the default 8080.
•	Each service registers itself dynamically in Eureka at startup.
•	If you get connection errors at first boot, wait a few seconds for services to become healthy.

---

## 🌱 Future Improvements
•	Add security with Spring Security and OAuth2.
•	Implement Kafka or RabbitMQ for event-driven communication.
•	Add distributed tracing with Sleuth and Zipkin.
•	Create frontend UI with React or Angular for statistics visualization.
•	Write unit and integration tests for each service.

---

## 📸 Project Screenshots
•	Eureka Server Dashboard — All services properly registered and UP.
•	Docker Containers — All microservices running isolated and communicating inside the same network.

---

### If you find this project interesting, feel free to ⭐️ it or contribute!
