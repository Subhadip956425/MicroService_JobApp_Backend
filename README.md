
# 🧩 Microservice JobApp Backend

This repository contains the **backend microservices** for the JobApp application, a scalable job portal system built using Spring Boot and PostgreSQL. Each microservice is responsible for a specific domain such as user management, job posting, application handling, and company reviews.

---

## 🚀 Tech Stack

- **Java 17**
- **Spring Boot**
- **Spring Cloud & Eureka**
- **Spring Data JPA**
- **PostgreSQL**
- **Docker**
- **Feign Client**
- **API Gateway**
- **Lombok**
- **JWT Security**
- **ModelMapper**

---

## 🧱 Microservices Architecture

This project follows a **microservice architecture** with the following modules:

- `api-gateway`: Centralized entry point for routing requests to appropriate microservices.
- `user-service`: Handles registration, login, and user profile management.
- `job-service`: Manages job listings (create, update, delete, view).
- `review-service`: Allows users to review companies.
- `application-service`: Handles job applications by users.
- `discovery-server`: Eureka service registry for microservices.

---

## 📂 Project Structure

```
MicroService_JobApp_Backend/
├── api-gateway/
├── discovery-server/
├── job-service/
├── review-service/
├── user-service/
├── application-service/
└── README.md
```

---

## ⚙️ How to Run

### Prerequisites

- Java 17+
- Maven
- Docker (for PostgreSQL or containerization)

### Step 1: Clone the repository

```bash
git clone https://github.com/Subhadip956425/MicroService_JobApp_Backend.git
cd MicroService_JobApp_Backend
```

### Step 2: Start PostgreSQL (Docker)

```bash
docker run --name jobapp-postgres -e POSTGRES_USER=subhadip -e POSTGRES_PASSWORD=subhadip -e POSTGRES_DB=jobapp -p 5432:5432 -d postgres
```

### Step 3: Start Services

Start each service individually from your IDE or with Maven:

```bash
cd discovery-server && mvn spring-boot:run
cd api-gateway && mvn spring-boot:run
cd user-service && mvn spring-boot:run
# Repeat for other services
```

---

## 🔐 Security

- All APIs are protected with **JWT-based authentication**.
- Role-based access control is implemented.

---

## 📬 API Endpoints (Examples)

| Service          | Endpoint                          | Method | Description                    |
|------------------|-----------------------------------|--------|--------------------------------|
| User Service     | `/api/users/register`             | POST   | Register new users             |
| Job Service      | `/api/jobs/{id}`                  | GET    | Fetch job by ID                |
| Review Service   | `/api/reviews/{companyId}`        | POST   | Add review for a company       |
| Application      | `/api/applications/user/{userId}` | GET    | List user applications         |

*Detailed Swagger/OpenAPI docs coming soon.*

---

## 🧑‍💻 Author

**Subhadip Guchhait**  
Java Full Stack Developer | Blockchain Enthusiast  
GitHub: [Subhadip956425](https://github.com/Subhadip956425)  
LinkedIn: [subhadip-guchhait](https://www.linkedin.com/in/subhadip-guchhait/)

---

## 📜 License

This project is licensed under the [MIT License](LICENSE).
