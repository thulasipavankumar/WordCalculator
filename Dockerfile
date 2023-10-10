FROM maven:3.8.5-openjdk-17 
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean package -DskipTests
RUN echo "------------------------------------------------- completed build -------------------------------------------------"
RUN ls -l /home/app/
COPY  /home/app/target/*.jar /usr/local/lib/app.jar
ENTRYPOINT ["java","-jar","/usr/local/lib/app.jar"]
EXPOSE 8080