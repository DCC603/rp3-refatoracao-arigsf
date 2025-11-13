FROM eclipse-temurin:17-jdk-alpine AS builder

WORKDIR /app
COPY src ./src
RUN javac -d out src/*.java

FROM eclipse-temurin:17-jre-alpine

WORKDIR /app
COPY --from=builder /app/out .
CMD ["java", "-cp", ".", "Main"]