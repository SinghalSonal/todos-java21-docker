# todos-java21-docker

Todos crud api built using modern tech stack: 

* Java 21
* Gradle 8+
* Spring Boot 3.4+
   * Spring Web   
   * Spring Data: Spring Data MongoDB and Spring Data Redis are used for data access.
* Cloud Resources
   * MongoDB
   * Redis
* Docker Container
   * Dockerfile: The `Dockerfile` in this project defines how to build a Docker image for the application. It specifies the base image, dependencies, and the steps to build and run the application.
   * Docker Compose: `compose.yaml` defines the services required for the application (MongoDB, Redis, and the application itself). Docker Compose simplifies the process of managing multi-container applications.
   * Images: The `compose.yaml` file uses the `mongo:latest` and `redis:latest` images. It is recommended to use specific versions in production.

## Local Development Setup

Here's how to set up and run the project locally using Docker and Gradle:

### Prerequisites

*   Docker Desktop installed and running.
*   Java 21 JDK installed.
*   Gradle installed (or use the Gradle wrapper).

### Steps

1.  **Build the Application with Gradle:**

    ```bash
    ./gradlew build
    ```

    This command builds the application, runs tests, and creates a JAR file in the `build/libs` directory.

3. **Run the application with docker compose**
    
    ```bash
    docker compose up --build
    ```

    This command will start the application, mongodb and redis in todos network of docker desktop

3. **Stop the services**
    
    ```bash
    docker compose down
    ```
    This command will stop the services started by docker compose.

### Additional Gradle Commands

*   **Clean:** `./gradlew clean` - Removes the `build` directory.
*   **Test:** `./gradlew test` - Runs the unit and integration tests.
*   **Build Docker Image:** `./gradlew bootBuildImage` - Builds a Docker image of the application.

### Accessing the Application

Once the application is running, you can access it at `http://localhost:8080`.
Postman collection and environment files are available at `src/test/resources/postman`.

## Next Phase - libraries / extensions planned

*   **Reactive:**: Spring Web Reactive
*   **Gateway:** Spring Cloud Gateway
*   **Rate Limiting:** Resilience4j, Circuit Breaker
*   **Health/Metrics:** Spring Boot Actuator
*   **Observability:** Micrometer
*   **Logging/Security:** Spring Boot Aop, Logback/LogStash
*   **Security:**: Spring Boot Security, JWT token

## Further Information

*   **Spring Boot Documentation:** https://docs.spring.io/spring-boot/3.4.4/reference/
*   **Java 21 Documentation:** https://docs.oracle.com/en/java/javase/21/
*   **Gradle Documentation:** https://docs.gradle.org/
*   **MongoDB Documentation:** https://www.mongodb.com/docs/
*   **Redis Documentation:** https://redis.io/docs/
*   **Docker Documentation:** https://docs.docker.com/
*   **Spring Data MongoDB**: https://docs.spring.io/spring-data/mongodb/docs/current/reference/html/
*   **Spring Data Redis**: https://docs.spring.io/spring-data/redis/docs/current/reference/html/
*   **Gradle Build Scans**: https://scans.gradle.com#gradle

## Personal Note

While my professional background provided opportunities in .NET and related Azure cloud tech stack, I thoroughly enjoyed learning & coding in Java & Go, as well as containerization with Docker and Kubernetes.
