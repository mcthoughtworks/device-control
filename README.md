# Device Control Service

This microservice is responsible for retrieving all devices associated with users.

## Technologies

- Kotlin
- Spring Boot
- Postgres
- Docker
- JUnit 5
- TestContainers

## Docker

For generate and publish the image in the docker hub you can run the following command.

    ./gradlew jib

After this, we can run the docker command that will provision the application and database containers.

    docker compose up --build -d