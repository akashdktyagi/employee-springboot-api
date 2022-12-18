FROM openjdk:18-jdk-alpine3.15
COPY target/employee-springboot-api-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 9000
ENTRYPOINT ["java","-jar","/app.jar"]