# Stage 1: Build the application using Maven
FROM maven:3.8.4-jdk-11 AS build
COPY src /app/src
COPY pom.xml /app/ 
WORKDIR /app
RUN mvn -f /app/pom.xml clean package -DskipTests

# Stage 2: Create the final container with the JAR file
FROM openjdk:11-jre-slim
COPY --from=build  /app/target/incident-service.jar  /app/incident-service.jar
EXPOSE 8080 
ENTRYPOINT ["java","-jar","/app/incident-service.jar"]