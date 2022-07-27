FROM openjdk:17-alpine

ADD /target/example.jar example.jar

EXPOSE ${PORT}

ENTRYPOINT ["java", "-jar", "-Dspring.profiles.active=docker", "example.jar"]