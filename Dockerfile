FROM java:8
WORKDIR /
COPY ${JAR_FILE} target/ws.rest.crud-0.0.1-SNAPSHOT.jar
EXPOSE 8080
ENTRYPOINT [ "java", "-jar", "/ws.rest.crud-0.0.1-SNAPSHOT.jar"]