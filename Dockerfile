# ---- Stage 1: build ----
FROM gradle:8.10-jdk17 AS builder
WORKDIR /app
COPY . .
RUN gradle clean bootJar --no-daemon

# ---- Stage 2: runtime ----
FROM gradle:8.10-jdk17
WORKDIR /app

# копируем собранный jar из builder
COPY --from=builder /app/build/libs/*.jar app.jar

# переменные окружения
ENV SPRING_PROFILES_ACTIVE=docker
ENV JAVA_OPTS="-Xms256m -Xmx512m"

EXPOSE 8080

ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -jar app.jar"]
