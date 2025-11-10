# Stage 1: build (для prod)
FROM gradle:8.10-jdk17 AS builder
WORKDIR /workspace
COPY . .
RUN gradle clean bootJar --no-daemon

# Stage 2: runtime (prod)
FROM eclipse-temurin:17-jre
WORKDIR /app
COPY --from=builder /workspace/build/libs/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
