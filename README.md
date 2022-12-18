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

  
  CREATE TABLE employee ( id serial PRIMARY KEY, age VARCHAR ( 50 ) ,
  department VARCHAR ( 50 ) , 
  designation VARCHAR ( 255 ) ,
  email VARCHAR ( 255 ) ,
  name VARCHAR ( 255 ) , 
  phone VARCHAR ( 255 ) ,
  salary VARCHAR ( 255 )

);

### Docker Commands
Learn Docker from Here: https://docker-curriculum.com/
Steps to take:

1. Add Docker file
2. Add Docker ignore file
3. run maven command: mvn clean install
4. Run Docker Login : docker login
5. Run Docker build :  docker build -t 333743/employee-service-api:latest .
6. Run Docker images to see the image: docker images
7. Run Docker container locally: docker run -p8099:9000 333743/employee-service-api:v1
6. Run Docker Push: docker push 333743/employee-service-api:1
7. Test this API on your local or Docker Playground: https://labs.play-with-docker.com/

#### Usefull Docker Commands:
1. Get all docker images: docker images -a
2. Delete all docker images: docker rmi $(docker images -a -q)
3. List all containers: docker ps -a rmi
4. Stop all containers: docker stop $(docker ps -a -q)
5. Delete all containers: docker rm $(docker ps -a -q)
6. Build simple Docker image: docker build .
7. Tag an image with Build:
  1. docker build -t vieux/apache:2.0:latest .
  2. docker build --tag com.yantracloud/spring-ref-app:latest .
8. For forcefully build the image: docker build --pull --no-cache --tag yantracloud/spring-ref-app:latest .
9. Docker build with File name: docker build -f Dockerfile.prod -t fullstack/ui .
10. Run the image:
    docker run -itd -p9096:9096 com.yantracloud/spring-ref-app:latest
1. Check if the port is free in Mac: netstat -vanp tcp | grep 8083
2. Push Images:
  1. First login to docker hub: docker login
  2. Make sure you have docker hub token
  3. docker image push yantraqa/spring-ref-app:latest
3. Conditional Statement in Docker file:
  1. https://www.dev-diaries.com/social-posts/conditional-logic-in-dockerfile/
  2.

13. Docker run Pull always:
  1. docker run -itd -p9008:80 --pull=always docker.io/yantraqa/gotocloud-appointment-app-ui:latest


To login in to docker and open bash: docker exec -it dind-test /bin/sh


-p<HostPost>:<Container_port>


Docker Compose:

Cheat Sheet links:

https://devhints.io/docker-compose
Docker-compose pull. ==> to pull the latest images
docker-compose start. => only to start containers which were previously created already
docker-compose stop
docker-compose pause
docker-compose unpause
docker-compose ps
docker-compose up. ==> to start all the containers afresh mentioned in the compose file.
docker-compose down



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

