FROM maven:3.8.3-openjdk-17
VOLUME /tmp
RUN mvn clean compile package
COPY target/*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
EXPOSE 8080