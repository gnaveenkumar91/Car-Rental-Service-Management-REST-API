# Car Rental Service Management REST API

A RESTful Car Rental Management System developed using Java and Spring Boot. The application manages cars, customers, bookings, rental pricing, late-return fines, and damage reports using REST APIs and a MySQL database.

## Project Overview

The Car Rental Service Management REST API provides backend functionality for managing a car rental business. It allows users to register cars and customers, create bookings for specific rental dates, calculate rental charges based on weekday and weekend rates, and process vehicle returns.

The application uses Spring Data JPA and Hibernate for database operations, with a layered architecture consisting of controllers, services, repositories, and entity classes.

## Features

- **Car Management:** Add, retrieve, update, and delete car records.
- **Customer Management:** Register customers and retrieve customer information.
- **Booking Management:** Create bookings for cars and customers over a selected date range.
- **Booking Conflict Detection:** Prevent overlapping bookings for the same car when an existing booking has `BOOKED` status.
- **Dynamic Rental Pricing:** Calculate rental charges using separate weekday and weekend rates.
- **Late Return Fine:** Calculate a fine of ₹1,000 per day for late returns.
- **Damage Reporting:** Record damage descriptions and repair costs during vehicle returns.
- **Booking Status Management:** Track booking status, including booked and returned vehicles.
- **Global Exception Handling:** Handle resource-not-found and booking-conflict errors.
- **Database Persistence:** Store cars, customers, bookings, and damage reports in MySQL.
- **API Documentation:** Use Swagger UI and OpenAPI to explore and test REST endpoints.
- **Application Monitoring:** Expose Spring Boot Actuator endpoints.

## Technology Stack

| Technology | Purpose |
|---|---|
| Java 25 | Programming language |
| Spring Boot 4.0.0 | Backend application framework |
| Spring Web | REST API development |
| Spring Data JPA | Database access |
| Hibernate | Object-relational mapping |
| MySQL | Relational database |
| Jakarta Validation | Validation support |
| Springdoc OpenAPI | Swagger API documentation |
| Spring Boot Actuator | Application monitoring |
| Lombok | Reduce boilerplate code |
| Maven | Build and dependency management |
| Postman | API testing |

## Application Architecture

The project follows a layered architecture.

- **Controller Layer:** Receives HTTP requests and returns API responses.
- **Service Layer:** Implements business logic for cars, customers, and bookings.
- **Repository Layer:** Uses Spring Data JPA to interact with the database.
- **Model Layer:** Defines the Car, Customer, Booking, BookingStatus, and DamageReport entities.
- **Exception Layer:** Provides custom exceptions and centralized exception handling.

### Architecture Flow

```text
Client / Postman
       |
       v
REST Controllers
       |
       v
Service Layer
       |
       v
Repository Layer
       |
       v
Hibernate / JPA
       |
       v
MySQL Database
```

## Project Structure

```text
Car-Rental-Service-Management-REST-API/
└── crsapp01/
    ├── pom.xml
    ├── mvnw
    ├── mvnw.cmd
    └── src/
        ├── main/
        │   ├── java/
        │   │   └── com/vcube/crsapp01/
        │   │       ├── controller/
        │   │       │   ├── CarController.java
        │   │       │   ├── CustomerController.java
        │   │       │   └── BookingController.java
        │   │       ├── exception/
        │   │       │   ├── BookingConflictException.java
        │   │       │   ├── CustomerNotFoundException.java
        │   │       │   ├── ErrorResponse.java
        │   │       │   ├── GlobalExceptionHandler.java
        │   │       │   └── ResourceNotFoundException.java
        │   │       ├── model/
        │   │       │   ├── Car.java
        │   │       │   ├── Customer.java
        │   │       │   ├── Booking.java
        │   │       │   ├── BookingStatus.java
        │   │       │   └── DamageReport.java
        │   │       ├── repo/
        │   │       │   ├── CarRepository.java
        │   │       │   ├── CustomerRepository.java
        │   │       │   ├── BookingRepository.java
        │   │       │   └── DamageReportRepository.java
        │   │       ├── service/
        │   │       │   ├── CarService.java
        │   │       │   ├── CarServiceImpl.java
        │   │       │   ├── CustomerService.java
        │   │       │   ├── CustomerServiceImpl.java
        │   │       │   ├── BookingService.java
        │   │       │   └── BookingServiceImpl.java
        │   │       └── Crsapp01Application.java
        │   └── resources/
        │       └── application.properties
        └── test/
```

## Database Configuration

The application uses MySQL with the database name `springbootdb`.

### 1. Create the database

```sql
CREATE DATABASE springbootdb;
```

### 2. Configure the connection

Update `crsapp01/src/main/resources/application.properties`:

```properties
spring.application.name=crsapp01

server.port=8090

spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.datasource.url=jdbc:mysql://localhost:3306/springbootdb
spring.datasource.username=root
spring.datasource.password=YOUR_MYSQL_PASSWORD

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

management.endpoints.web.exposure.include=*
management.info.env.enabled=true

info.app.name=Car Rental Services
info.app.description=A simple application to maintain rental cars
info.app.version=1.0.0
```

Replace `YOUR_MYSQL_PASSWORD` with your local MySQL password.

Hibernate creates or updates the database tables based on the entity mappings. The project uses the following explicit table names:

- `car65`
- `customer65`
- `booking65`
- `damagereport65`

**Security note:** Do not publish real database credentials in a public repository. Use environment variables or external configuration for sensitive values.

## How to Run the Project

### Prerequisites

- JDK 25
- MySQL Server
- Maven or the included Maven Wrapper
- Eclipse, IntelliJ IDEA, or another Java IDE
- Postman for API testing

### Step 1: Clone the repository

```bash
git clone https://github.com/gnaveenkumar91/Car-Rental-Service-Management-REST-API.git
```

### Step 2: Open the project directory

```bash
cd Car-Rental-Service-Management-REST-API/crsapp01
```

Run the following commands from the directory containing `pom.xml`.

### Step 3: Create the database

```sql
CREATE DATABASE springbootdb;
```

### Step 4: Configure MySQL

Update the username and password in `application.properties`.

### Step 5: Start the application

Using Maven:

```bash
mvn spring-boot:run
```

On Windows, using the Maven Wrapper:

```bat
mvnw.cmd spring-boot:run
```

### Step 6: Access the application

The application runs on port `8090`.

Base URL:

`http://localhost:8090`

## REST API Endpoints

All endpoints below are defined in the uploaded controllers.

### Car APIs

Base path: `/api/cars`

| HTTP Method | Endpoint | Description |
|---|---|---|
| POST | `/api/cars` | Add a car |
| GET | `/api/cars` | Retrieve all cars |
| GET | `/api/cars/{id}` | Retrieve a car by ID |
| PUT | `/api/cars/{id}` | Update a car |
| DELETE | `/api/cars/{id}` | Delete a car |

### Customer APIs

Base path: `/api/customers`

| HTTP Method | Endpoint | Description |
|---|---|---|
| POST | `/api/customers` | Add a customer |
| GET | `/api/customers` | Retrieve all customers |
| GET | `/api/customers/getCustomer/{id}` | Retrieve a customer by ID |

### Booking APIs

Base path: `/api/bookings`

| HTTP Method | Endpoint | Description |
|---|---|---|
| POST | `/api/bookings` | Create a booking |
| GET | `/api/bookings` | Retrieve all bookings |
| PUT | `/api/bookings/{id}/return` | Process a car return |

#### Create a booking

Send a POST request to:

```text
http://localhost:8090/api/bookings?carId=1&customerId=1&startDate=2026-11-01&endDate=2026-11-03
```

The request uses query parameters for the car ID, customer ID, start date, and end date. Dates must use the `YYYY-MM-DD` format.

The service checks whether the car and customer exist, checks for conflicting bookings, calculates the rental price, and saves the booking.

#### Return a car

Send a PUT request to:

```text
http://localhost:8090/api/bookings/1/return?actualReturnDate=2026-11-04
```

Optional damage information can be supplied using `damageDescription` and `repairCost` query parameters.

Example:

```text
http://localhost:8090/api/bookings/1/return?actualReturnDate=2026-11-04&damageDescription=Scratched%20door&repairCost=2000
```

The service calculates late fines and, when a positive repair cost is provided, creates a damage report.

## Business Logic

### Rental Price Calculation

The total booking price is calculated by adding the daily rental rate for each date in the selected booking period.

- Weekdays use the car's weekday price.
- Saturdays and Sundays use the car's weekend price.

The current implementation includes both the start date and the end date in the price calculation.

### Booking Conflict Validation

The system checks existing bookings for the selected car. If a booking with `BOOKED` status overlaps the requested date range, the service throws a `BookingConflictException`.

### Late Return Fine

The fine is calculated at ₹1,000 per day when a car is returned after the booking's end date.

For example, returning a car one day late results in a late fine of ₹1,000, excluding any repair charges.

### Damage Report

When a positive repair cost is supplied during a return, the application stores the booking reference, damage description, and repair cost in the damage report table.

## Swagger API Documentation

After starting the application, open:

**http://localhost:8090/swagger-ui/index.html**

The OpenAPI specification is generally available at:

`http://localhost:8090/v3/api-docs`

These URLs require the application's Swagger configuration and dependencies to start successfully.

## Actuator Monitoring

The application includes Spring Boot Actuator.

Check the health endpoint:

`http://localhost:8090/actuator/health`

The project exposes all Actuator endpoints through its current configuration. For production deployments, restrict access to sensitive monitoring endpoints.

## Error Handling

The project includes centralized exception handling and custom exceptions for cases such as:

- Resource not found
- Customer not found
- Booking conflicts

The `GlobalExceptionHandler` and `ErrorResponse` classes are used to provide structured error responses.

## Future Enhancements

- Add automated unit and integration tests.
- Improve validation for booking dates and repair costs.
- Add authentication and authorization if required.
- Externalize database credentials and secure Actuator endpoints.
- Improve booking cancellation and availability management.
- Add Docker support for easier deployment.

## Author

**Naveen Kumar**

GitHub: [gnaveenkumar91](https://github.com/gnaveenkumar91)

