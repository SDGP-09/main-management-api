# Stage 1: Build the application
FROM maven:3.8.6-amazoncorretto-17 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn package -DskipTests

# Stage 2: Create the final image
FROM openjdk:17
WORKDIR /app
COPY --from=build /app/target/main-management.jar .
EXPOSE 7075
CMD ["java", "-jar", "main-management.jar"]