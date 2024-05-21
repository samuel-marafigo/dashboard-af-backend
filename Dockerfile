FROM openjdk:17-jdk-slim

WORKDIR /app

COPY . /app

RUN apt-get update && apt-get install -y maven

EXPOSE 8080

CMD ["mvn", "spring-boot:run"]