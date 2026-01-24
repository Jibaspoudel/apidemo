# REST API CRUD + MySQL (Spring Boot)

## Requirements
- Java 17+
- MySQL running on localhost:3306
- IntelliJ IDEA

## 1) Create database
```sql
CREATE DATABASE demo_crud;
```

## 2) Configure MySQL credentials
Edit:
`src/main/resources/application.properties`

Update:
- `spring.datasource.username`
- `spring.datasource.password`

## 3) Run
From IntelliJ: run `RestApplication`

Or from terminal:
```bash
mvn spring-boot:run
```

## Endpoints (Postman)
Base URL: `http://localhost:8080`

### Create user
POST `http://localhost:8080/api/users`
Body (JSON):
```json
{
  "name": "Dhiraj",
  "email": "dhiraj@test.com"
}
```

### Get all users
GET `http://localhost:8080/api/users`

### Get one user
GET `http://localhost:8080/api/users/1`

### Update user
PUT `http://localhost:8080/api/users/1`
Body:
```json
{
  "name": "Updated",
  "email": "dhiraj@test.com"
}
```

### Delete user
DELETE `http://localhost:8080/api/users/1`

## Verify in MySQL
```sql
USE demo_crud;
SELECT * FROM users;
```

## Validation errors
If you send invalid data, the API returns HTTP 400 with field errors like:
```json
{
  "timestamp": "2026-01-23T00:00:00Z",
  "status": 400,
  "error": "Bad Request",
  "message": "Validation failed",
  "path": "/api/users",
  "fieldErrors": {
    "email": "email must be valid"
  }
}
```
