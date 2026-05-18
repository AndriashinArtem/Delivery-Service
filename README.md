# Delivery Service

Delivery Service is a REST API application for managing and tracking parcels in a delivery service system.

The project was built using Spring Boot and PostgreSQL with Docker support for quick deployment and testing.

## Features

- Create parcels
- Get all parcels
- Get parcel by ID
- Update parcel information
- Change parcel status
- Delete parcels
- Get parcel statistics
- Automatic test data initialization via `data.sql`

## Technologies

- Java
- Spring Boot
- Spring Data JPA
- Hibernate
- PostgreSQL
- Docker
- Docker Compose
- Maven

## Project Structure

The application consists of two Docker containers:

- App — Spring Boot application
- DB — PostgreSQL database

## Running the Project

### Requirements

- Docker
- Docker Compose

### Start application

Clone the repository:

```bash
git clone <your-repository-url>
```

Run the project:

```bash
docker compose up --build
```

After startup, the application will be available at:

```text
http://localhost:8080
```

## API Endpoints

### Get all parcels

```http
GET /parcels
```

### Get parcel by ID

```http
GET /parcels/{id}
```

### Get parcel statistics

```http
GET /parcels/stats
```

### Create parcel

```http
POST /parcels/createParcel
```

### Update parcel status

```http
PATCH /parcels/{id}
```

### Update parcel

```http
PUT /parcels/updateParcel
```

### Delete parcel

```http
DELETE /parcels/deleteParcel/{id}
```

## Database Initialization

The project automatically creates test records during startup using:

```text
data.sql
```

This allows immediate testing of the API after launching the containers.

## Notes

- The application uses PostgreSQL as the main database.
- Parcel statuses are implemented using Enum.
- API testing was performed using Postman.