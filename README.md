# todos-java21-docker

Todos crud api built with modern technologies: Java 21, Spring Boot 3.4+, Gradle 8+, MongoDB, and Redis running apim and cloud resources in Docker containers.

## Personal Note

While my professional background is in .NET development, I thoroughly enjoyed this project as an opportunity to delve into new backend technologies such as Java and Go, as well as containerization with Docker and Kubernetes.

## Technology Stack

This project leverages a powerful combination of technologies to deliver a robust and scalable application. 
Here's a breakdown:

### Java 21

*   **Why Java 21?** This project utilizes Java 21, the latest Long-Term Support (LTS) release of Java. Java 21 brings significant performance improvements, enhanced language features (like virtual threads), and improved security. It ensures the application benefits from the latest advancements in the Java ecosystem.
* **Key Features**: Virtual Threads, Pattern Matching for switch, Record Patterns, String Templates.

### Spring Boot 3.4+

*   **Why Spring Boot 3.4+?** Spring Boot 3.4 (and later) is a major release that builds upon the solid foundation of previous versions. It offers improved performance, enhanced developer experience, and seamless integration with modern cloud-native technologies.
*   **Key Features**:
    *   **Jakarta EE 10 Support:** Spring Boot 3.4 fully embraces Jakarta EE 10, providing access to the latest specifications and APIs.
    *   **GraalVM Native Image Support:**  Improved support for building native images with GraalVM, resulting in faster startup times and reduced memory footprint.
    *   **Observability Enhancements:** Enhanced support for metrics, tracing, and logging, making it easier to monitor and troubleshoot applications.
    * **Docker Compose Support**: Spring boot 3.4 has built in support for docker compose.
    * **Dev Services**: Spring boot 3.4 has dev services which automatically starts the services like mongodb and redis if they are not running.
* **Spring Data**: Spring Data MongoDB and Spring Data Redis are used for data access.

### Gradle

*   **Why Gradle?** Gradle is a powerful build automation tool that offers flexibility, performance, and excellent dependency management. This project uses Gradle to manage dependencies, build the application, and create Docker images.
* **Version**: The specific Gradle version used in this project is defined in `gradle/wrapper/gradle-wrapper.properties`. You can check the `distributionUrl` property to find the exact version.
* **Key Features**:
    *   **Groovy/Kotlin DSL:** Gradle supports both Groovy and Kotlin for build scripts, offering a more expressive and powerful way to define build logic.
    *   **Dependency Management:** Gradle's dependency management system is robust and efficient, handling transitive dependencies and version conflicts effectively.
    *   **Task-Based Build:** Gradle uses a task-based approach, allowing for fine-grained control over the build process.
    * **Build Scans**: Gradle build scans provide insights into the build process.

### MongoDB

*   **Why MongoDB?** MongoDB is a NoSQL document database that provides flexibility and scalability. It's well-suited for applications that require dynamic schemas and high performance.
*   **Usage:** This project uses MongoDB to store the todo items.
* **Spring Data MongoDB**: Spring Data MongoDB is used to interact with MongoDB.

### Redis

*   **Why Redis?** Redis is an in-memory data structure store that excels at caching and real-time data processing.
*   **Usage:** This project uses Redis as a cache to improve the performance of frequently accessed data.
* **Spring Data Redis**: Spring Data Redis is used to interact with Redis.

### Docker and Docker Compose

*   **Why Docker?** Docker provides a containerization platform that allows you to package and run applications in isolated environments. This ensures consistency across different environments (development, testing, production).
*   **Dockerfile:** The `Dockerfile` in this project defines how to build a Docker image for the application. It specifies the base image, dependencies, and the steps to build and run the application.
*   **Docker Compose:** `compose.yaml` defines the services required for the application (MongoDB, Redis, and the application itself). Docker Compose simplifies the process of managing multi-container applications.
* **Images**: The `compose.yaml` file uses the `mongo:latest` and `redis:latest` images. It is recommended to use specific versions in production.

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
