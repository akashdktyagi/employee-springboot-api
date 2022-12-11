# employee-springboot-api
This is a sample reference api using Spring boot api

## Topics Done so far
* Microservices architecture and System Design
* Spring Boot Init
* Controller/Repository/Services Concepts
* Get/Put/Post/Delete Delete
* Error Codes
* Swagger Documentation
* JpaRepository
* H2 Database
* yml config file
* Lombok lib
* Builder Pattern/Pojo


### Create table in postgresDB
CREATE TABLE employee (
id serial PRIMARY KEY,
age VARCHAR ( 50 ) ,
department VARCHAR ( 50 ) ,
designation VARCHAR ( 255 ) ,
email VARCHAR ( 255 ) ,
name VARCHAR ( 255 ) ,
phone VARCHAR ( 255 ) ,
salary VARCHAR ( 255 )

);

<properties>
  <sonar.organization>akashdktyagi-github</sonar.organization>
  <sonar.host.url>https://sonarcloud.io</sonar.host.url>
</properties>

mvn verify org.sonarsource.scanner.maven:sonar-maven-plugin:sonar -Dsonar.projectKey=akashdktyagi_about-me

mvn verify org.sonarsource.scanner.maven:sonar-maven-plugin:sonar -Dsonar.projectKey=akashdktyagi_about-me

mvn verify sonar:sonar

<properties>
  <sonar.organization>akashdktyagi-github</sonar.organization>
  <sonar.host.url>https://sonarcloud.io</sonar.host.url>
</properties>

