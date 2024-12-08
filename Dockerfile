FROM maven:3.8.5-openjdk-17-slim AS build
WORKDIR /app
COPY . /app
RUN mvn clean package
FROM openjdk:17-jre-slim
WORKDIR /app
COPY --from=build /app/target/my-app-1.0-SNAPSHOT.jar /app/my-app.jar
CMD ["java", "-jar", "my-app.jar"]
