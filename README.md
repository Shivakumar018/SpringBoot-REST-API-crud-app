# Employee Management API

A Spring Boot REST API for managing employees with full CRUD operations, MySQL integration, Lombok, Swagger API documentation, and centralized exception handling.

---

## Features

- Create, read, update, and delete employee records
- Fetch employees by:
  - ID
  - Email
  - Department
- Supports **PUT** (full update) and **PATCH** (partial update)
- Clean layered architecture: Controller → Service → Repository
- Global Exception Handling using `@ControllerAdvice`
- Lombok to reduce boilerplate code
- Swagger UI for API testing

---

## Tech Stack

- **Java**
- **Spring Boot**
  - Spring Web
  - Spring Data JPA
- **MySQL**
- **Lombok**
- **Swagger (Springdoc OpenAPI)**
- **Maven**

---

## Employee Entity

| Field        | Type   | Description                |
|--------------|---------|----------------------------|
| `id`         | Long    | Auto-generated ID          |
| `name`       | String  | Employee name              |
| `email`      | String  | Unique email               |
| `number`     | String  | Contact number             |
| `department` | String  | Employee department        |

Example JSON:

```json
{
  "name": "John Doe",
  "email": "john.doe@example.com",
  "number": "9876543210",
  "department": "IT"
}
