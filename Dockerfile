FROM eclipse-temurin:17-jdk-alpine
VOLUME /tmp
RUN mvn clean compile package
COPY target/*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
EXPOSE 8080