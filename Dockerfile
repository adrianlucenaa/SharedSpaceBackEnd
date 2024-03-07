FROM maven:3.8.5-openjdk-17 as build
COPY . .
RUN mvn clean package -DskipTests

FROM openjdk:17-jdk-slim
COPY --from=build /target/SharedSpace-0.0.1-SNAPSHOT.jar /app/SharedSpace.jar
EXPOSE 8080
CMD ["java","-jar","/app/SharedSpace.jar"]