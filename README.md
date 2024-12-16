Spring Boot Pre-BootCamp Application

This project is a Spring Boot application designed to handle authentication, role-based access control, and CRUD operations for students and subjects. It includes JWT-based authentication, role distinction (Student vs Admin), and uses JPA for database management.

Features

Authentication:

Register users (students and admins).

Login to generate a JWT token.

Secure API endpoints using JWT.

Role-based Access Control:

Student: Can only view their own data.

Admin: Can view and manage all students and subjects.

CRUD Operations:

Add and retrieve students.

Add and retrieve subjects linked to students.

Technology Stack:

Spring Boot (REST API)

Spring Security (JWT Authentication)

JPA with Hibernate (Database)

H2 Database (in-memory database for testing)

Postman (for testing APIs)

Prerequisites

Java 17 or higher.

Maven 3.8+.

An IDE (e.g., IntelliJ IDEA, Eclipse, or VS Code).

Postman (for testing API calls).

Project Structure

├── src
│ ├── main
│ │ ├── java/com/Pre_BootCamp
│ │ │ ├── controller # Controllers for handling API endpoints
│ │ │ ├── model # Entity classes
│ │ │ ├── repository # Repositories for database access
│ │ │ ├── service # Business logic and JWT utility
│ │ │ ├── config # Security and application configuration
│ │ ├── resources
│ │ ├── application.properties # Application configuration
├── pom.xml # Maven configuration file

How to Run the Application

Step 1: Clone the Repository

git clone <repository-url>
cd Pre_BootCamp

Step 2: Configure the Application

Update src/main/resources/application.properties as needed:

# H2 Database configuration

spring.datasource.url=jdbc:h2:mem:prebootcampdb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=password
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect

# JWT Secret Key (ensure it's kept secret)

jwt.secret=<your-secret-key>

Step 3: Build the Project

Use Maven to build the project:

mvn clean install

Step 4: Run the Application

Start the application using:

mvn spring-boot:run

The application will be available at http://localhost:8080.

API Documentation

Authentication APIs

1. Register a User

Endpoint: POST /register

Description: Registers a user (default role: STUDENT).

Request Body:

{
"username": "user1",
"password": "password123"
}

Response:

{
"message": "Register successfully"
}

2. Login

Endpoint: POST /authentication

Description: Authenticates a user and returns a JWT token.

Request Body:

{
"username": "user1",
"password": "password123"
}

Response:

{
"token": "<jwt-token>"
}

Student APIs

3. Get Student Data

Endpoint: GET /getStudent

Description: Returns student data.

Authorization:

STUDENT: Returns only the authenticated student's data.

ADMIN: Returns all student data.

Headers:

{
"Authorization": "Bearer <jwt-token>"
}

Response (STUDENT):

{
"id": 1,
"name": "John Doe",
"address": "123 Main St"
}

Response (ADMIN):

[
{
"id": 1,
"name": "John Doe",
"address": "123 Main St"
},
{
"id": 2,
"name": "Jane Smith",
"address": "456 Elm St"
}
]

4. Add a Student

Endpoint: POST /addStudent

Description: Adds a student (Admin only).

Request Body:

{
"name": "John Doe",
"address": "123 Main St"
}

Response:

{
"id": 1,
"name": "John Doe",
"address": "123 Main St"
}

Subject APIs

5. Add a Subject

Endpoint: POST /addSubject

Description: Adds a subject to a student (Admin only).

Request Body:

{
"name": "Math",
"student": {
"id": 1
}
}

Response:

{
"id": 1,
"name": "Math",
"student": {
"id": 1,
"name": "John Doe",
"address": "123 Main St"
}
}

6. Get All Subjects

Endpoint: GET /getSubject

Description: Returns all subjects.

Headers:

{
"Authorization": "Bearer <jwt-token>"
}

Response:

[
{
"id": 1,
"name": "Math",
"student": {
"id": 1,
"name": "John Doe",
"address": "123 Main St"
}
}
]

Database Details

H2 Database

The application uses an in-memory H2 database for testing purposes. The schema and data are auto-generated at runtime. Access the H2 console at http://localhost:8080/h2-console.

Database Schema:

Auth Table: Stores user credentials and roles.

CREATE TABLE Auth (
id BIGINT AUTO_INCREMENT PRIMARY KEY,
username VARCHAR(255) UNIQUE NOT NULL,
password VARCHAR(255) NOT NULL,
role VARCHAR(50) NOT NULL
);

Student Table: Stores student information.

CREATE TABLE Student (
id BIGINT AUTO_INCREMENT PRIMARY KEY,
name VARCHAR(255) NOT NULL,
address VARCHAR(255) NOT NULL
);

Subject Table: Stores subject information linked to students.

CREATE TABLE Subject (
id BIGINT AUTO_INCREMENT PRIMARY KEY,
name VARCHAR(255) NOT NULL,
student_id BIGINT NOT NULL,
FOREIGN KEY (student_id) REFERENCES Student(id)
);

Postman Collection

A Postman collection for testing all endpoints is available here.

Notes

Default Role: Users registering through the /register API are assigned the STUDENT role by default.

Role Management: To assign an ADMIN role, update the role field in the database manually or use a custom admin-registration API.

JWT Expiry: Tokens expire after 30 minutes. Users need to log in again to get a new token.

Future Enhancements

Implement a frontend for better user experience.

Add more detailed error handling.

Extend roles and permissions for more granular access control.

Switch to a persistent database like MySQL or PostgreSQL for production.

License

This project is licensed under the MIT License.
