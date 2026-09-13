# UserService

Spring Boot microservice that owns user data for the [Flight Booking system](https://github.com/varshini39/flightbooking). Provides CRUD REST APIs for users and is called by [BookingService](https://github.com/varshini39/BookingService) to fetch user details for a booking.

## Tech stack

Spring Boot · Spring Data JPA · MySQL · Spring Security Crypto (BCrypt) · [EntityService](https://github.com/varshini39/EntityService) (shared `User` entity)

## API

Base path: `/api/users` (server runs with `context-path=/api`)

| Method | Endpoint | Description |
|---|---|---|
| GET | `/users` | List all users |
| GET | `/users/{userId}` | Get a user by ID |
| POST | `/users` | Add a user |
| PUT | `/users` | Update a user |
| DELETE | `/users/{userId}` | Delete a user |

**User fields:** `user_id`, `first_name`, `last_name`, `age`, `gender`, `phone_number`, `email_id`, `password`

Passwords are BCrypt-hashed on the way in ([`BCryptPasswordDeserializer`](https://github.com/varshini39/EntityService) in EntityService) and never returned in responses (`password` is write-only).

## Running locally

Requires `entity-service` installed to your local Maven repo first (see [EntityService](https://github.com/varshini39/EntityService)):

```bash
mvn spring-boot:run
```

Configure the datasource in `src/main/resources/application.properties`.

## Running with Docker

```bash
docker-compose up --build
```

Runs the service on host port **8081** against a MySQL container.

To run alongside FlightService and BookingService with a single shared database, use [docker-compose.yml](./docker-compose.yml) at the repo root, or `docker-compose-kubernetes.yml` for the Kubernetes-oriented variant.

## Kubernetes

Manifests included: `mysqldb-deployment.yaml`, `mysqldb-pv.yaml`, `mysqldb-pvc.yaml`, `mysqldb-service.yaml`, `user-service-deployment.yaml`, `user-service-service.yaml`.

`kubernetes-commands.txt` documents the full workflow used to deploy this project on Minikube: building images, pushing to Docker Hub, applying manifests, and inspecting pods/services — the same steps apply to FlightService and BookingService.

## Part of

[flightbooking](https://github.com/varshini39/flightbooking) (project overview) · [EntityService](https://github.com/varshini39/EntityService) · [FlightService](https://github.com/varshini39/FlightService) · [BookingService](https://github.com/varshini39/BookingService)
