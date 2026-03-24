# Build do projeto
FROM maven:3.9.9-eclipse-temurin-21 AS build

WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

# Executando o projeto
FROM eclipse-temurin:21-jdk-jammy
WORKDIR /app
COPY --from=build /app/target/*.jar application.jar

EXPOSE 8080

ENTRYPOINT [ "java", "-jar", "/app/application.jar" ]
