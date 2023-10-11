FROM maven:3.8.5-openjdk-17 AS build
COPY . .
RUN mvn clean package -DskipTests
RUN echo "------------------------------------------------- completed build -------------------------------------------------"

FROM openjdk:17-jdk-slim
COPY --from=build /target/*.jar app.jar
COPY --from=build /words_alpha.txt words_alpha.txt
# ENV PORT=8080
EXPOSE 8080
ENTRYPOINT ["java","-jar","app.jar"]