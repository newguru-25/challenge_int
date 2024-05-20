FROM openjdk:17-jdk-slim-buster

COPY target/*.jar challenge-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java","-jar","/challenge-0.0.1-SNAPSHOT.jar"]