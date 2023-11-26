FROM maven:3.8.4-openjdk-17 AS builder
WORKDIR /app
COPY pom.xml .
RUN mvn dependency:go-offline
COPY src ./src
RUN mvn package
FROM openjdk:17
WORKDIR /app
COPY --from=builder /app/target/tatame-0.jar .
CMD ["java", "-jar", "tatame-0.jar"]