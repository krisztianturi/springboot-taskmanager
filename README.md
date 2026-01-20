# Spring Boot Task Manager – Backend REST API

This project is a Spring Boot–based backend application that implements a simple customer–order management system.
It demonstrates the structure, architecture, and commonly used technologies of a modern Java backend application.

## Features

- Customer management (create, list)
- Order management
    - Create new orders
    - List all orders
    - List orders of a specific customer
- Pagination and sorting
- Validation and global exception handling
- REST API documentation using Swagger / OpenAPI


## Technology Stack

- Java 21
- Spring Boot
  - Spring Web (REST)
  - Spring Data JPA (Hibernate)
  - Spring Validation
  - Spring Security (basic configuration)
- Oracle Database (Oracle XE – Docker container)
- Maven
- Lombok
- Springdoc OpenAPI (Swagger UI)

## Architecture

The application follows a layered architecture:
- Controller layer
  - REST endpoints
  - Handling HTTP requests and responses
- Service layer
  - Business logic
  - Mapping between entities and DTOs
- Repository layer
  - Database operations using Spring Data JPA
- DTOs
  - Request and response objects
  - Prevent recursive JSON responses
- Entity layer
  - JPA entities mapped to the Oracle database

## Data Model (Overview)

- Customer
  - id
  - name
  - email
  - orders (list of Order)

- Order
  - id
  - orderDate
  - status (enum)
  - product
  - quantity
  - customer (reference to Customer)

Relationships:

- One Customer can have multiple Orders (OneToMany)
- Each Order belongs to exactly one Customer (ManyToOne)

## Validation and Error Handling

- Bean Validation annotations (@NotBlank, @Email, @Positive, etc.)
- Invalid requests are not persisted to the database
- Global exception handler returns consistent JSON error responses

## API Documentation (Swagger)

The API is automatically documented using OpenAPI.
Swagger UI is available at:
http://localhost:8080/swagger-ui.html


Features:

- Interactive API testing
- Request and response DTO visualization
- Validation rules displayed directly in the UI

## Project Purpose

This project was created for learning and demonstration purposes, especially to:
- Support junior Java backend developer job applications
- Showcase Spring Boot + JPA + REST knowledge
- Serve as a GitHub portfolio project

## Future Improvements

- Update and delete operations
- JWT-based authentication
- Role-based authorization
- Integration tests
- Docker Compose setup