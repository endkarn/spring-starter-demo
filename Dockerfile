## Use official base image of Java Runtim
#FROM openjdk:8-jdk-alpine
#
##RUN apk update && apk add bash
#
## Set volume point to /tmp
#VOLUME /tmp
#
## Make port 8080 available to the world outside container
#EXPOSE 8555
#
## Set application's JAR file
#ARG JAR_FILE=docker-spring-boot.jar
#
## Add the application's JAR file to the container
#ADD ${JAR_FILE} app.jar
#
## Run the JAR file
#ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/app.jar"]

FROM openjdk:8-jdk-alpine
ADD target/docker-spring-boot.jar docker-spring-boot.jar
EXPOSE 8085
ENTRYPOINT ["java","-jar","docker-spring-boot.jar"]


