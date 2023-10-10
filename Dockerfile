FROM maven:3.8.5-openjdk-17 AS build
COPY . .
RUN mvn clean package -DskipTests -DskipTests
RUN echo "------------------------------------------------- completed build -------------------------------------------------"

FROM openjdk:17-jdk-slim
COPY --from=build /target/*.jar app.jar
# ENV PORT=8080
EXPOSE 8080
ENTRYPOINT ["java","-jar","app.jar"]