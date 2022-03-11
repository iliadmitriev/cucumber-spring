FROM maven:3.8.4-openjdk-11-slim as builder
COPY src /usr/src/app/src
COPY pom.xml /usr/src/app
RUN mvn -f /usr/src/app/pom.xml clean package

FROM openjdk:11-jdk-slim-buster
RUN mkdir -p /app
COPY src/main/resources/features /app/features
COPY --from=builder /usr/src/app/target/cuc-test-1.0-SNAPSHOT.jar /app/cuc-test-1.0-SNAPSHOT.jar
WORKDIR /app
CMD ["java","-jar","/app/cuc-test-1.0-SNAPSHOT.jar","features"]
