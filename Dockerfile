from openjdk:8-jdk-alpine
VOLUME /tmp
ARG JAR_FILE=target/account-backend.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
